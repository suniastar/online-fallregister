package de.coronavirus.domain.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Table(name = "infected")
public class Infected extends Entity {

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "gender")
    private Gender gender;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "infected", fetch = FetchType.LAZY)
    @JoinColumn(name = "jobs")
    private List<Job> jobs;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "accommodation_id")
    private Accommodation accommodation; // like hospital, care station or homeless accommodation

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "diagnosis_id")
    private Diagnosis diagnosis;

    @Column(name = "diagnosis_confirmed")
    private boolean diagnosisConfirmed;

    @Column(name = "date_of_illness")
    private Date dateOfIllnes;

    @Column(name = "date_of_diagnosis")
    private Date dateOfDiagnosis;

    @Column(name = "date_of_death")
    private Date dateOfDeath;

    // TODO range of infection see: https://vladmihalcea.com/map-postgresql-range-column-type-jpa-hibernate/

    @Column(name = "infection_source")
    private String infectionSource; // TODO maybe use a class or other data type?

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "infected", fetch = FetchType.LAZY)
    @JoinColumn(name = "location_of_infection")
    private Address location_of_infection;

    // TODO range of treatment in hospital

    @Column(name = "intensive_care_treatment")
    private boolean intensiveCareTreatment;

    public enum Gender {

        MALE,
        FEMALE,
        DIVERSE

    }
}
