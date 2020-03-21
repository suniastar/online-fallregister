package de.coronavirus.application.dtos.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel("Diagnosis")
public class DiagnosisResponse {

    @ApiModelProperty(position = 1)
    List<String> diagnosticResult;

    public List<String> getDiagnosticResult() {
        return diagnosticResult;
    }

    public void setDiagnosticResult(List<String> diagnosticResult) {
        this.diagnosticResult = diagnosticResult;
    }
}
