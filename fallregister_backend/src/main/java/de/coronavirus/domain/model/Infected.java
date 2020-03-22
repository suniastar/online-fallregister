package de.coronavirus.domain.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

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

    public Infected() {
        this.phoneNumbers = new LinkedList<>();
        this.emailAddresses = new LinkedList<>();
        this.diagnoses = new LinkedList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<EmailAddress> getEmailAddresses() {
        return emailAddresses;
    }

    public void setEmailAddresses(List<EmailAddress> emailAddresses) {
        this.emailAddresses = emailAddresses;
    }

    public boolean isJobInMedicalField() {
        return jobInMedicalField;
    }

    public void setJobInMedicalField(boolean jobInMedicalField) {
        this.jobInMedicalField = jobInMedicalField;
    }

    public boolean isJobInFoodFiled() {
        return jobInFoodFiled;
    }

    public void setJobInFoodFiled(boolean jobInFoodFiled) {
        this.jobInFoodFiled = jobInFoodFiled;
    }

    public boolean isJobInCommunityField() {
        return jobInCommunityField;
    }

    public void setJobInCommunityField(boolean jobInCommunityField) {
        this.jobInCommunityField = jobInCommunityField;
    }

    public Accommodation getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(Accommodation accommodation) {
        this.accommodation = accommodation;
    }

    public Date getDateOfIllness() {
        return dateOfIllness;
    }

    public void setDateOfIllness(Date dateOfIllness) {
        this.dateOfIllness = dateOfIllness;
    }

    public List<Diagnosis> getDiagnoses() {
        return diagnoses;
    }

    public void setDiagnoses(List<Diagnosis> diagnoses) {
        this.diagnoses = diagnoses;
    }

    public Date getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(Date dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public String getInfectionSource() {
        return infectionSource;
    }

    public void setInfectionSource(String infectionSource) {
        this.infectionSource = infectionSource;
    }

    public boolean isIntensiveCareTreatment() {
        return intensiveCareTreatment;
    }

    public void setIntensiveCareTreatment(boolean intensiveCareTreatment) {
        this.intensiveCareTreatment = intensiveCareTreatment;
    }

    public List<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Infected infected = (Infected) o;

        if (id != infected.id) return false;
        if (jobInMedicalField != infected.jobInMedicalField) return false;
        if (jobInFoodFiled != infected.jobInFoodFiled) return false;
        if (jobInCommunityField != infected.jobInCommunityField) return false;
        if (intensiveCareTreatment != infected.intensiveCareTreatment) return false;
        if (!Objects.equals(firstName, infected.firstName)) return false;
        if (!Objects.equals(lastName, infected.lastName)) return false;
        if (gender != infected.gender) return false;
        if (!Objects.equals(dateOfBirth, infected.dateOfBirth)) return false;
        if (!Objects.equals(phoneNumbers, infected.phoneNumbers)) return false;
        if (!Objects.equals(address, infected.address)) return false;
        if (!Objects.equals(emailAddresses, infected.emailAddresses)) return false;
        if (!Objects.equals(accommodation, infected.accommodation)) return false;
        if (!Objects.equals(dateOfIllness, infected.dateOfIllness)) return false;
        if (!Objects.equals(diagnoses, infected.diagnoses)) return false;
        if (!Objects.equals(dateOfDeath, infected.dateOfDeath)) return false;
        return Objects.equals(infectionSource, infected.infectionSource);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
        result = 31 * result + (phoneNumbers != null ? phoneNumbers.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (emailAddresses != null ? emailAddresses.hashCode() : 0);
        result = 31 * result + (jobInMedicalField ? 1 : 0);
        result = 31 * result + (jobInFoodFiled ? 1 : 0);
        result = 31 * result + (jobInCommunityField ? 1 : 0);
        result = 31 * result + (accommodation != null ? accommodation.hashCode() : 0);
        result = 31 * result + (dateOfIllness != null ? dateOfIllness.hashCode() : 0);
        result = 31 * result + (diagnoses != null ? diagnoses.hashCode() : 0);
        result = 31 * result + (dateOfDeath != null ? dateOfDeath.hashCode() : 0);
        result = 31 * result + (infectionSource != null ? infectionSource.hashCode() : 0);
        result = 31 * result + (intensiveCareTreatment ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Infected{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", dateOfBirth=" + dateOfBirth +
                ", phoneNumber=" + phoneNumbers +
                ", address=" + address +
                ", emailAddresses=" + emailAddresses +
                ", jobInMedicalField=" + jobInMedicalField +
                ", jobInFoodFiled=" + jobInFoodFiled +
                ", jobInCommunityField=" + jobInCommunityField +
                ", accommodation=" + accommodation +
                ", dateOfIllness=" + dateOfIllness +
                ", diagnoses=" + diagnoses +
                ", dateOfDeath=" + dateOfDeath +
                ", infectionSource='" + infectionSource + '\'' +
                ", intensiveCareTreatment=" + intensiveCareTreatment +
                '}';
    }

    public enum Gender {

        MALE,
        FEMALE,
        DIVERSE

    }
}
