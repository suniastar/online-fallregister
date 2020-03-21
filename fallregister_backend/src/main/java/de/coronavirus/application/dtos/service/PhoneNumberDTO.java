package de.coronavirus.application.dtos.service;

import de.coronavirus.domain.model.Entity;

import java.util.List;

public interface PhoneNumberDTO {

    long getId();
    String getName();
    List<Entity> getEntities();
}
