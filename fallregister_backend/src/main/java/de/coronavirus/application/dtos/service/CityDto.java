package de.coronavirus.application.dtos.service;

import java.util.List;

public interface CityDto {

    long getId();
    String getName();
    CountryDto getCountry();
    List<PostCodeDto> getPostCodes();
    List<StreetDto> getStreets();
}
