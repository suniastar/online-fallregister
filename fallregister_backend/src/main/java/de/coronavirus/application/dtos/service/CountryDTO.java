package de.coronavirus.application.dtos.service;

import java.util.List;

public interface CountryDTO {

    long getId();
    String getName();
    List<CityDTO> getCities();
}
