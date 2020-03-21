package de.coronavirus.application.dtos.service;

import java.util.List;

public interface CountryDto {

    long getId();
    String getName();
    List<CityDto> getCities();
}
