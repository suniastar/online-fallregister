package de.coronavirus.application.dtos.service;

import java.util.List;

public interface JobDTO extends EntityDTO {

    long getId();
    String getName();
    List<InfectedDTO> getInfected();
}
