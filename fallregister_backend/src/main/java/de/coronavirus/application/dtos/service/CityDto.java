package de.coronavirus.application.dtos.service;

import java.util.List;

public interface CityDto {

    long getId();
    String getName();
    List<PostCodeDTO> getPostCodes();
    List<StreetDto> getStreets();
}
