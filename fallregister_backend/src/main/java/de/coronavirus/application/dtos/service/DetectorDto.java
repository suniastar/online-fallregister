package de.coronavirus.application.dtos.service;

import java.util.List;

public interface DetectorDto {

    Long getId();

    String getName();

    List<PhoneNumberDto> getPhoneNumbers();

    AddressDto getAddress();

    List<EmailAddressDto> getEmailAddresses();
}
