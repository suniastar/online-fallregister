package de.coronavirus.application.dtos.service;

import java.util.List;

public interface PhoneNumberDTO {

    long getId();
    String getName();
    List<EntityDTO> getEntities();
}
