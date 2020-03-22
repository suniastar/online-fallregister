package de.coronavirus.application.dtos.service;

import java.util.List;

public interface UserDto {

    String getName();
    String getPassword();
    List<TokenDto> getTokens();

}
