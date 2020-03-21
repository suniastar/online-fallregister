package de.coronavirus.application.dtos.service;

import java.util.List;

public interface CityDTO {

    long getId();
    String getName();
    List<PostCodeDTO> getPostCodes();
    List<StreetDTO> getStreets();
}
