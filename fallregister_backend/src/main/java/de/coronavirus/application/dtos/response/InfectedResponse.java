package de.coronavirus.application.dtos.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@ApiModel ("InfectedResponse")
public class InfectedResponse {
    @ApiModelProperty
    long id;

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
    @ApiModelProperty
    String firstName;

    @ApiModelProperty
    String lastName;

    @ApiModelProperty
    String gender;

    @ApiModelProperty
    Date dateOfBirth;

    @ApiModelProperty
    List<String> jobs;

    /* -Accommodation */
    @ApiModelProperty
    String accommodationName;

    /* -Diagnosis */
    @ApiModelProperty
    String diagnosisResult;

    @ApiModelProperty
    Date diagnosisDate;

    /* --Detector */
    @ApiModelProperty
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

    @ApiModelProperty
    boolean intensiveCareTreatment;
}
