package de.coronavirus.application.dtos.service;

import java.util.List;

public interface DetectorDTO {

    long getId();
    String getName();
    List<PhoneNumberDTO> getPhoneNumber();
    AddressDTO getAddress();
    EmailAddressDTO getEmailAddress();
}
