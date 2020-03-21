package de.coronavirus.application.dtos.service;

import de.coronavirus.domain.model.City;

public interface StreetDTO {

    long getId();
    String getName();
    City getCity();
}
