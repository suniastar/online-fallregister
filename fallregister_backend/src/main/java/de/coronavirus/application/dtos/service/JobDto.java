package de.coronavirus.application.dtos.service;

import java.util.List;

public interface JobDto {

    long getId();
    String getName();
    List<InfectedDto> getInfected();
    List<PhoneNumberDto> getPhoneNumber();
    AddressDto getAddress();
    EmailAddressDto getEmailAddress();
}
