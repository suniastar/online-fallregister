package de.coronavirus.application.dtos.service;

import java.util.List;

public interface PostCodeDTO {

    long getCode();
    String getCity();
    List<StreetDto> getStreets();
}
