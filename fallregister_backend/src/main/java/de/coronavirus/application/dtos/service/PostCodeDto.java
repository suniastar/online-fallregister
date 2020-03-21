package de.coronavirus.application.dtos.service;

import java.util.List;

public interface PostCodeDto {

    long getCode();
    String getCity();
    List<StreetDto> getStreets();
}
