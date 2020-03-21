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
    List<String> phoneNumber;

    /* -Address */
    @ApiModelProperty
    Integer houseNumber;

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
    List<String> jobs;

    /* -Accommodation */
    @ApiModelProperty
    String accommodationName;

    /* -Diagnosis */
    @NotEmpty
    @ApiModelProperty(required = true)
    String diagnosisResult;

    @NotNull
    @ApiModelProperty(required = true)
    Date diagnosisDate;

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

    public List<String> getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(List<String> phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
    }

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

    public List<String> getJobs() {
        return jobs;
    }

    public void setJobs(List<String> jobs) {
        this.jobs = jobs;
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

    public Date getDiagnosisDate() {
        return diagnosisDate;
    }

    public void setDiagnosisDate(Date diagnosisDate) {
        this.diagnosisDate = diagnosisDate;
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
}