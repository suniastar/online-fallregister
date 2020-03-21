package de.coronavirus.application.dtos.service;

import java.util.Date;

public interface TokenDto {

    long getId();
    Date getValidUntil();
    String getValue();
    UserDto getUser();

}
