package de.coronavirus.application.dtos.service;

import de.coronavirus.domain.model.*;

import java.util.Date;
import java.util.List;

public interface InfectedDTO {

    long getId();
    String getFirstName();
    String getLastName();
    Infected.Gender getGender();
    Date getDateOfBirth();
    List<Job> getJobs();
    Accommodation getAccommodation();
    List<Diagnosis> getDiagnosis();
    Date getDateOfIllnes();
    Date getDateOfDeath();
    String getInfectionSource();
    Address getLocation_of_infection();
    boolean getIntensiveCareTreatment();
}
