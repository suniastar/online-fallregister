package de.coronavirus.application.dtos.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import java.util.Date;
import java.util.List;

@ApiModel ("InfectedResponse")
public class InfectedResponse {
    @ApiModelProperty
    long id;

    /* Entity */
    @ApiModelProperty
    List<String> phoneNumbers;

    @ApiModelProperty
    List<String> emailAddresses;

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
    @ApiModelProperty
    String firstName;

    @ApiModelProperty
    String lastName;

    @ApiModelProperty
    String gender;

    @ApiModelProperty
    Date dateOfBirth;

    @ApiModelProperty
    boolean jobInMedicalField;

    @ApiModelProperty
    boolean jobInFoodField;

    @ApiModelProperty
    boolean jobInCommunityField;

    @ApiModelProperty
    Date dateOfIllness;

    @ApiModelProperty
    Date dateOfDeath;

    /* -Accommodation */
    @ApiModelProperty
    String accommodationName;

    @ApiModelProperty
    String infectionSource;

    @ApiModelProperty
    boolean intensiveCareTreatment;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers= phoneNumbers;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
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

    public boolean isJobInMedicalField(){
        return this.jobInMedicalField;
    }

    public void setJobInMedicalField(boolean jobInMedicalField){
        this.jobInMedicalField = jobInMedicalField;
    }

    public boolean isJobInFoodField(){
        return this.jobInFoodField;
    }

    public void setJobInFoodField(boolean jobInFoodField){
        this.jobInFoodField = jobInFoodField;
    }

    public boolean isJobInCommunityField(){
        return this.jobInCommunityField;
    }

    public void setJobInCommunityField(boolean jobInCommunityField){
        this.jobInCommunityField = jobInCommunityField;
    }

    public String getAccommodationName() {
        return accommodationName;
    }

    public void setAccommodationName(String accommodationName) {
        this.accommodationName = accommodationName;
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
