package de.coronavirus.application.dtos.mapper;

import de.coronavirus.application.dtos.response.TokenResponse;
import de.coronavirus.application.dtos.service.TokenDto;

public class TokenMapper {

    private TokenMapper() {
    }

    public static TokenResponse toResponse(TokenDto tokenDto) {
        TokenResponse response = new TokenResponse();
        response.setUser(tokenDto.getUser().getName());
        response.setToken(tokenDto.getValue());
        response.setValidUntil(tokenDto.getValidUntil());
        return response;
    }
}