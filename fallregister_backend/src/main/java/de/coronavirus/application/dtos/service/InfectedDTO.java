package de.coronavirus.application.dtos.service;

import de.coronavirus.domain.model.*;

import javax.persistence.*;
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
    Date getDateOfIllnes();
    List<Diagnosis> getDiagnosis();
    Date getDateOfDeath();
    String getInfectionSource();
    boolean getIntensiveCareTreatment();
    
}
