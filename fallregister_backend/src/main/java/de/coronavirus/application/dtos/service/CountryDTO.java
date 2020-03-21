package de.coronavirus.application.dtos.service;

import de.coronavirus.domain.model.City;

import java.util.List;

public interface CountryDTO {

    long getId();
    String getName();
    List<City> getCities();
}
