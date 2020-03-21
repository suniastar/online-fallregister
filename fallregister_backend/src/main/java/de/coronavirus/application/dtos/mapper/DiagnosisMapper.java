package de.coronavirus.application.dtos.mapper;

import de.coronavirus.application.dtos.response.DiagnosisResponse;
import de.coronavirus.application.dtos.service.DiagnosisDto;

import java.util.ArrayList;
import java.util.List;

public class DiagnosisMapper {

    public static DiagnosisResponse toResponse(DiagnosisDto diagnosisDto) {
        return diagnosisDtoToResponse(diagnosisDto);
    }

    public static List<DiagnosisResponse> toResponseList(List<DiagnosisDto> diagnosisDtoList){
        List<DiagnosisResponse> diagnosisResponseList = new ArrayList<>();
        for(DiagnosisDto diagnosisDto : diagnosisDtoList){
            diagnosisResponseList.add(diagnosisDtoToResponse(diagnosisDto));
        }
        return diagnosisResponseList;
    }

    private static DiagnosisResponse diagnosisDtoToResponse(DiagnosisDto diagnosisDto){
        DiagnosisResponse diagnosisResponse = new DiagnosisResponse();
        diagnosisResponse.setDiagnosticResult(diagnosisDto.getDiagnosticResult());
        diagnosisResponse.setDate(diagnosisDto.getDate());
        diagnosisResponse.setLaboratoryName(diagnosisDto.getLaboratory().getName());
        diagnosisResponse.setConfirmed(diagnosisDto.isConfirmed());
        diagnosisResponse.setSuspicion(diagnosisDto.isSuspicion());
        diagnosisResponse.setClinicalDiagnosis(diagnosisDto.isClinicalDiagnosis());
        diagnosisResponse.setDead(diagnosisDto.isDead());
        return diagnosisResponse;
    }
}
