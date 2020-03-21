package de.coronavirus.application.dtos.service;

import de.coronavirus.domain.model.Infected;

import javax.persistence.Column;
import java.util.Date;
import java.util.List;

public interface InfectedDto {

    long getId();
    String getFirstName();
    String getLastName();
    Infected.Gender getGender();
    Date getDateOfBirth();
    boolean isJobInMedicalField();
    boolean isJobInFoodFiled();
    boolean isJobInCommunityField();
    AccommodationDto getAccommodation();

    Date getDateOfIllness();

    List<DiagnosisDto> getDiagnosis();
    Date getDateOfDeath();
    String getInfectionSource();
    boolean getIntensiveCareTreatment();

    List<PhoneNumberDto> getPhoneNumber();
    AddressDto getAddress();
    EmailAddressDto getEmailAddress();
    
}
