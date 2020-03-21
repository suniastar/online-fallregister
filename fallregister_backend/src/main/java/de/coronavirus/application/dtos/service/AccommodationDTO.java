package de.coronavirus.application.dtos.service;

import de.coronavirus.domain.model.Infected;

import java.util.List;

public interface AccommodationDTO {
    Long getId();
    String getName();
    List<Infected> getInfected();
}
