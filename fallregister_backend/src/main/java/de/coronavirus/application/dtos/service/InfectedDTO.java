package de.coronavirus.application.dtos.service;

import de.coronavirus.domain.model.Infected;

import java.util.Date;
import java.util.List;

public interface InfectedDTO {

    long getId();
    String getFirstName();
    String getLastName();
    Infected.Gender getGender();
    Date getDateOfBirth();
    List<JobDTO> getJobs();
    AccommodationDTO getAccommodation();

    Date getDateOfIllness();

    List<DiagnosisDTO> getDiagnosis();
    Date getDateOfDeath();
    String getInfectionSource();
    boolean getIntensiveCareTreatment();

    List<PhoneNumberDTO> getPhoneNumber();
    AddressDTO getAddress();
    EmailAddressDTO getEmailAddress();
    
}
