package de.coronavirus.application.dtos.response;

import de.coronavirus.domain.model.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@ApiModel ("InfectedResponse")
public class InfectedResponse {
    @ApiModelProperty(position = 0, required = true)
    long id;

    @ApiModelProperty
    String firstName;

    @ApiModelProperty
    private String lastName;

    @ApiModelProperty
    private Infected.Gender gender;

    @ApiModelProperty
    private Date dateOfBirth;

    @ApiModelProperty
    private List<Job> jobs;

    @ApiModelProperty
    private Accommodation accommodation; // like hospital, care station or homeless accommodation

    @ApiModelProperty
    private Diagnosis diagnosis;

    @ApiModelProperty
    private boolean diagnosisConfirmed;

    @ApiModelProperty
    private Date dateOfIllnes;

    @ApiModelProperty
    private Date dateOfDiagnosis;

    @ApiModelProperty
    private Date dateOfDeath;

    @ApiModelProperty
    private String infectionSource;

    @ApiModelProperty
    private Address location_of_infection;

    @ApiModelProperty
    private boolean intensiveCareTreatment;
}
