package de.coronavirus.application.dtos.service;

import java.util.List;

public interface AccommodationDTO {

    Long getId();
    String getName();
    List<InfectedDTO> getInfected();
    List<PhoneNumberDTO> getPhoneNumber();
    AddressDTO getAddress();
    EmailAddressDTO getEmailAddress();
}
