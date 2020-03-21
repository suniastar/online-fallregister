package de.coronavirus.application.dtos.service;

import java.util.Date;

public interface TokenDTO {

    long getId();
    Date getValidUntil();
    String getValue();
    UserDTO getUser();

}
