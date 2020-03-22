package de.coronavirus.application.service;

import de.coronavirus.application.dtos.request.LoginRequest;
import de.coronavirus.application.dtos.service.TokenDto;
import de.coronavirus.domain.exception.NotAuthorizedException;
import de.coronavirus.domain.infrastructure.repositories.TokenRepository;
import de.coronavirus.domain.infrastructure.repositories.UserRepository;
import de.coronavirus.domain.model.Token;
import de.coronavirus.domain.model.User;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.SecureRandom;
import java.sql.Date;
import java.time.Instant;
import java.util.Base64;
import java.util.Optional;
import java.util.function.Supplier;

@Service
@Transactional
public class AuthorizationService {

    private static final long MAX_SESSION_DURATION = 3 * 60 * 60;

    private final Logger log;

    private final UserRepository userRepository;

    private final TokenRepository tokenRepository;

    private final SecureRandom random;

    private final Base64.Encoder encoder;

    public AuthorizationService(UserRepository userRepository, TokenRepository tokenRepository) {
        this.userRepository = userRepository;
        this.tokenRepository = tokenRepository;
        this.log = LoggerFactory.getLogger(AuthorizationService.class);
        this.random = new SecureRandom();
        this.encoder = Base64.getEncoder();
    }

    public TokenDto login(final LoginRequest request) {
        log.info("Login by {}", request.getUser());

        // hash password
        final String hash = DigestUtils.sha256Hex(request.getPassword());

        // find user
        final Optional<User> userOptional = userRepository.findByNameAndPassword(
                request.getUser(),
                hash);
        final User user = userOptional.orElseThrow(badCredentialsException());

        // add token
        final Token token = user.addToken();

        // fill data into token
        byte[] bitsAndBytes = new byte[128];
        random.nextBytes(bitsAndBytes);
        token.setValue(encoder.encodeToString(bitsAndBytes));
        token.setValidUntil(Date.from(Instant.now().plusSeconds(MAX_SESSION_DURATION)));

        // store in db
        userRepository.flush();

        // send response
        return tokenRepository.findDtoById(token.getId()).orElseThrow(badCredentialsException());
    }

    public TokenDto refresh(final String token) {
        log.info("Refreshing token {}", token);

        if (token == null || token.isBlank()) {
            throw badCredentialsException().get();
        }

        // find token
        final Optional<Token> tokenOptional = tokenRepository.findByValueAndValidUntilAfter(
                token,
                Date.from(Instant.now()));
        final Token tokenObject = tokenOptional.orElseThrow(outDatedTokenException());
        final Optional<User> userOptional = userRepository.findById(tokenObject.getUser().getName());
        final User user = userOptional.orElseThrow();

        // make new random data
        byte[] bitsAndBytes = new byte[128];
        random.nextBytes(bitsAndBytes);
        tokenObject.setValue(encoder.encodeToString(bitsAndBytes));
        tokenObject.setValidUntil(Date.from(Instant.now().plusSeconds(MAX_SESSION_DURATION)));

        // store in db
        userRepository.flush();

        // send response
        return tokenRepository.findDtoById(tokenObject.getId()).orElseThrow(outDatedTokenException());
    }

    private Supplier<NotAuthorizedException> badCredentialsException() {
        return () -> new NotAuthorizedException("BAD_CREDENTIALS",
                "The specified user was not found or the password was incorrect.");
    }

    private Supplier<NotAuthorizedException> outDatedTokenException() {
        return () -> new NotAuthorizedException("BAD_TOKEN",
                "The supplied token is no longer valid.");
    }
}
