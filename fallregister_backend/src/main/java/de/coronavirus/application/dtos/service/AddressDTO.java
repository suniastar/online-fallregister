package de.coronavirus.application.dtos.service;

import java.util.List;

public interface AddressDTO {

    long getId();
    StreetDTO getStreet();
    Integer getHouseNumber();
    List<EntityDTO> getEntities();

}
