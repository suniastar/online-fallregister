package de.coronavirus.application.dtos.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@ApiModel("Create Infected Entry")
public class CreateInfectedRequest {

    /* Entity */
    @ApiModelProperty
    List<String> phoneNumbers;

    /* -Address */
    @ApiModelProperty
    String houseNumber;

    /* --Street */
    @ApiModelProperty
    String streetName;

    /* ---PostCode */
    @ApiModelProperty
    long postCode;

    /* ----City */
    @ApiModelProperty
    String cityName;

    @ApiModelProperty
    String country;

    /* Infected */
    @NotEmpty
    @ApiModelProperty(required = true)
    String firstName;

    @NotEmpty
    @ApiModelProperty(required = true)
    String lastName;

    @NotNull
    @ApiModelProperty(required = true)
    String gender;

    @NotNull
    @ApiModelProperty(required = true)
    Date dateOfBirth;

    @ApiModelProperty
    boolean jobInMedicalField;

    @ApiModelProperty
    boolean jobInFoodField;

    @ApiModelProperty
    boolean jobInCommunityField;

    /* -Accommodation */
    @ApiModelProperty
    String accommodationName;

    /* -Diagnosis */
    @NotEmpty
    @ApiModelProperty(required = true)
    String diagnosisResult;

    @NotNull
    @ApiModelProperty(required = true)
    Date date;

    /* --Detector */
    @NotEmpty
    @ApiModelProperty(required = true)
    String detectorName;

    /* --Laboratory */
    @ApiModelProperty
    String laboratoryName;

    @ApiModelProperty
    boolean diagnosisConfirmed;

    @ApiModelProperty
    Date dateOfIllness;

    @ApiModelProperty
    Date dateOfDeath;

    @ApiModelProperty
    String infectionSource;

    @NotNull
    @ApiModelProperty(required = true)
    boolean intensiveCareTreatment;

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public long getPostCode() {
        return postCode;
    }

    public void setPostCode(long postCode) {
        this.postCode = postCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAccommodationName() {
        return accommodationName;
    }

    public void setAccommodationName(String accommodationName) {
        this.accommodationName = accommodationName;
    }

    public String getDiagnosisResult() {
        return diagnosisResult;
    }

    public void setDiagnosisResult(String diagnosisResult) {
        this.diagnosisResult = diagnosisResult;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDetectorName() {
        return detectorName;
    }

    public void setDetectorName(String detectorName) {
        this.detectorName = detectorName;
    }

    public String getLaboratoryName() {
        return laboratoryName;
    }

    public void setLaboratoryName(String laboratoryName) {
        this.laboratoryName = laboratoryName;
    }

    public boolean isDiagnosisConfirmed() {
        return diagnosisConfirmed;
    }

    public void setDiagnosisConfirmed(boolean diagnosisConfirmed) {
        this.diagnosisConfirmed = diagnosisConfirmed;
    }

    public Date getDateOfIllness() {
        return dateOfIllness;
    }

    public void setDateOfIllness(Date dateOfIllness) {
        this.dateOfIllness = dateOfIllness;
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

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public boolean isJobInMedicalField() {
        return jobInMedicalField;
    }

    public void setJobInMedicalField(boolean jobInMedicalField) {
        this.jobInMedicalField = jobInMedicalField;
    }

    public boolean isJobInFoodField() {
        return jobInFoodField;
    }

    public void setJobInFoodField(boolean jobInFoodField) {
        this.jobInFoodField = jobInFoodField;
    }

    public boolean isJobInCommunityField() {
        return jobInCommunityField;
    }

    public void setJobInCommunityField(boolean jobInCommunityField) {
        this.jobInCommunityField = jobInCommunityField;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }
}