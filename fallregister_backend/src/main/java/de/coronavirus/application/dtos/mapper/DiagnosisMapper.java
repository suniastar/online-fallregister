package de.coronavirus.application.dtos.mapper;

import de.coronavirus.application.dtos.response.DiagnosisResponse;
import de.coronavirus.application.dtos.service.DiagnosisDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DiagnosisMapper {

    DiagnosisResponse toResponse(DiagnosisDTO diagnosisDTO);
    List<DiagnosisResponse> toResponseList(List<DiagnosisDTO> diagnosisDTOList);
}
