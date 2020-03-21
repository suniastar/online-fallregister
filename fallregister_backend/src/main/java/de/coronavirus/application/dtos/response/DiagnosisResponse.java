package de.coronavirus.application.dtos.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel("Diagnosis")
public class DiagnosisResponse {
    @ApiModelProperty(position = 1)
    List<String> diagnosticResult;
}
