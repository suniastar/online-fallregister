package de.coronavirus.application.dtos.service;

import java.util.List;

public interface PostCodeDto {

    long getCode();
    CityDto getCity();
    List<StreetDto> getStreets();
}
