package de.coronavirus.application.dtos.service;

import java.util.List;

public interface EntityDTO {

    List<PhoneNumberDTO> getPhoneNumber();
    AddressDTO getAddress();
    EmailAddressDTO getEmailAddress();
}
