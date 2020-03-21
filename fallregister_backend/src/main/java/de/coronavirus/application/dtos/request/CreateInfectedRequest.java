package de.coronavirus.application.dtos.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
@ApiModel("CreateInfectedRequest")
public class CreateInfectedRequest {

    /* Entity */
    @ApiModelProperty
    List<String> phoneNumbers;

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
}