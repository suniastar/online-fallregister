package de.coronavirus.application.dtos.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@ApiModel("UpdateAppInfoRequest")
public class UpdateInfectedRequest {

    /* Entity */
    @ApiModelProperty
    List<String> phoneNumber;

    /* -Address */
    @ApiModelProperty
    Integer infectedHouseNumber;

    /* --Street */
    @ApiModelProperty
    String infectedStreetName;

    /* ---PostCode */
    @ApiModelProperty
    long infectedPostCode;

    @ApiModelProperty
    String infectedCityName;

    @ApiModelProperty
    String infectedCounty;

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