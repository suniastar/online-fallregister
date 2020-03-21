package de.coronavirus.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@EqualsAndHashCode
@Entity
@Table(name = "infected")
public class Infected {

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

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "phone_numbers")
    private List<PhoneNumber> phoneNumbers;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @OrderBy("email asc")
    private List<EmailAddress> emailAddresses;

    @Column(name = "job_medical_field")
    private boolean jobInMedicalField;

    @Column(name = "job_food_field")
    private boolean jobInFoodFiled;

    @Column(name = "job_community_field")
    private boolean jobInCommunityField;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "accommodation_id")
    private Accommodation accommodation; // like hospital, care station or homeless accommodation

    @Column(name = "date_of_illness")
    private Date dateOfIllness;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @OrderBy("date asc")
    private List<Diagnosis> diagnoses;

    @Column(name = "date_of_death")
    private Date dateOfDeath;

    // TODO range of infection see: https://vladmihalcea.com/map-postgresql-range-column-type-jpa-hibernate/

    @Column(name = "infection_source")
    private String infectionSource;

    // TODO range of treatment in hospital

    @Column(name = "intensive_care_treatment")
    private boolean intensiveCareTreatment;

    public enum Gender {

        MALE,
        FEMALE,
        DIVERSE

    }
}
