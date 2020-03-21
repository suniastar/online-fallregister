package de.coronavirus.application.dtos.service;

import de.coronavirus.domain.model.Entity;

import java.util.List;

public interface EmailAddressDTO {

    long getId();
    String getEmail();
    List<Entity> getEntities();
}
