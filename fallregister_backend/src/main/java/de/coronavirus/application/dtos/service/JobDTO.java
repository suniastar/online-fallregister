package de.coronavirus.application.dtos.service;

import java.util.List;

public interface JobDTO {

    long getId();
    String getName();
    List<InfectedDTO> getInfected();
    List<PhoneNumberDTO> getPhoneNumber();
    AddressDTO getAddress();
    EmailAddressDTO getEmailAddress();
}
