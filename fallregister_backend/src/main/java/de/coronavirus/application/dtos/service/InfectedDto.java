package de.coronavirus.application.dtos.service;

import de.coronavirus.domain.model.Infected;

import java.util.Date;
import java.util.List;

public interface InfectedDto {

    Long getId();

    String getFirstName();

    String getLastName();

    Infected.Gender getGender();

    Date getDateOfBirth();

    List<PhoneNumberDto> getPhoneNumbers();

    AddressDto getAddress();

    List<EmailAddressDto> getEmailAddresses();

    boolean isJobInMedicalField();

    boolean isJobInFoodFiled();

    boolean isJobInCommunityField();

    AccommodationDto getAccommodation();

    Date getDateOfIllness();

    List<DiagnosisDto> getDiagnoses();

    Date getDateOfDeath();

    String getInfectionSource();

    boolean getIntensiveCareTreatment();

    
}
