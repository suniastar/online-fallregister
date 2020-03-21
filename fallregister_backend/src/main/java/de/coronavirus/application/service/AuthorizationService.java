package de.coronavirus.application.service;

import de.coronavirus.application.dtos.request.LoginRequest;
import de.coronavirus.application.dtos.service.TokenDto;
import de.coronavirus.domain.infrastructure.repositories.TokenRepository;
import de.coronavirus.domain.infrastructure.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AuthorizationService {

    private final Logger log;

    private final UserRepository userRepository;

    private final TokenRepository tokenRepository;

    public AuthorizationService(UserRepository userRepository, TokenRepository tokenRepository) {
        this.userRepository = userRepository;
        this.tokenRepository = tokenRepository;
        this.log = LoggerFactory.getLogger(AuthorizationService.class);
    }

    public TokenDto login(LoginRequest request) {
        return null;
    }

    public TokenDto refresh(String token) {
        return null;
    }
}
