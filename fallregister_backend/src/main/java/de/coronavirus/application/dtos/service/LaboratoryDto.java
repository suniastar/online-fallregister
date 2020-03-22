package de.coronavirus.application.dtos.service;

import java.util.List;

public interface LaboratoryDto {

    Long getId();

    String getName();

    List<PhoneNumberDto> getPhoneNumbers();

    AddressDto getAddress();

    List<EmailAddressDto> getEmailAddresses();
}
