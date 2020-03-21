package de.coronavirus.application.dtos.service;

import java.util.List;

public interface UserDTO {

    String getName();
    String getPassword();
    List<TokenDTO> getTokens();

}
