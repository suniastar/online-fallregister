package de.coronavirus.application.dtos.service;

import java.util.List;

public interface EmailAddressDTO {

    long getId();
    String getEmail();
    List<EntityDTO> getEntities();
}
