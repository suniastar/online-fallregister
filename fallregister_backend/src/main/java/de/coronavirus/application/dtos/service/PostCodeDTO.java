package de.coronavirus.application.dtos.service;

import de.coronavirus.domain.model.Street;

import java.util.List;

public interface PostCodeDTO {

    long getCode();
    String getCity();
    List<Street> getStreets();
}
