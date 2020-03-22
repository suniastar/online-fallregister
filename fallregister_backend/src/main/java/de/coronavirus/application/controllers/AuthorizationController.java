package de.coronavirus.application.controllers;

import de.coronavirus.application.controllers.api.AuthorizationApi;
import de.coronavirus.application.dtos.mapper.TokenMapper;
import de.coronavirus.application.dtos.request.LoginRequest;
import de.coronavirus.application.dtos.response.TokenResponse;
import de.coronavirus.application.service.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class AuthorizationController implements AuthorizationApi {

    private final AuthorizationService authService;

    @Autowired
    public AuthorizationController(AuthorizationService authService) {
        this.authService = authService;
    }

    @Override
    public TokenResponse postLogin(LoginRequest request) {
        return TokenMapper.toResponse(authService.login(request));
    }

    @Override
    public TokenResponse postRefresh(String token) {
        return TokenMapper.toResponse(authService.refresh(token));
    }
}
