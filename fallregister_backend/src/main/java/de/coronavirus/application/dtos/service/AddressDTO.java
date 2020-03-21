package de.coronavirus.application.dtos.service;

import de.coronavirus.domain.model.Street;

import javax.persistence.*;
import java.util.List;

public interface AddressDTO {

    long getId();
    Street getStreet();
    Integer getHouseNumber();
    List<Entity> getEntities();

}
