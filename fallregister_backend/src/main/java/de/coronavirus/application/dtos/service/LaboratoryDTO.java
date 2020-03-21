package de.coronavirus.application.dtos.service;

import java.util.List;

public interface LaboratoryDTO {

    long getId();
    String getName();
    List<PhoneNumberDTO> getPhoneNumber();
    AddressDTO getAddress();
    EmailAddressDTO getEmailAddress();
}
