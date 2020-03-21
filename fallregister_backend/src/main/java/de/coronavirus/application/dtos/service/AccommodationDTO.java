package de.coronavirus.application.dtos.service;

import java.util.List;

public interface AccommodationDTO extends EntityDTO {
    Long getId();
    String getName();
    List<InfectedDTO> getInfected();
}
