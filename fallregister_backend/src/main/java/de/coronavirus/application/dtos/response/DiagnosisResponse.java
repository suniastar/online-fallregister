package de.coronavirus.application.dtos.response;

import de.coronavirus.domain.model.Diagnosis;
import de.coronavirus.domain.model.PhoneNumber;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("Diagnosis")
public class DiagnosisResponse {
    @ApiModelProperty
    Diagnosis diagnosis;
}
