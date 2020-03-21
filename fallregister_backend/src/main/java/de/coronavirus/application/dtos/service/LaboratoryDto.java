package de.coronavirus.application.dtos.service;

import java.util.List;

public interface LaboratoryDto {

    long getId();
    String getName();
    List<PhoneNumberDto> getPhoneNumber();
    AddressDto getAddress();
    EmailAddressDto getEmailAddress();
}
