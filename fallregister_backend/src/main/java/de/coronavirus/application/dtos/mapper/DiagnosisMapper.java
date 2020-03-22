package de.coronavirus.application.dtos.mapper;

import de.coronavirus.application.dtos.response.autocomplete.ACDiagnosisNameResponse;
import de.coronavirus.application.dtos.service.DiagnosisDto;

import java.util.List;

public class DiagnosisMapper {

    public static ACDiagnosisNameResponse toNameResponse(DiagnosisDto diagnosisDto) {
        ACDiagnosisNameResponse diagnosisNameResponse = new ACDiagnosisNameResponse();
        diagnosisNameResponse.getNames().add(diagnosisDto.getDiagnosticResult());
        return diagnosisNameResponse;
    }

    public static ACDiagnosisNameResponse toNameResponse(List<DiagnosisDto> diagnosisDtoList) {
        ACDiagnosisNameResponse diagnosisNameResponse = new ACDiagnosisNameResponse();
        for(DiagnosisDto diagnosisDto : diagnosisDtoList){
            diagnosisNameResponse.getNames().add(diagnosisDto.getDiagnosticResult());
        }
        return diagnosisNameResponse;
    }

}
