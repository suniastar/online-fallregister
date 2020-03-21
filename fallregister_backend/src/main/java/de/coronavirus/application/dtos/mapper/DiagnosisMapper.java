package de.coronavirus.application.dtos.mapper;

import de.coronavirus.application.dtos.response.DiagnosisResponse;
import de.coronavirus.application.dtos.service.DiagnosisDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DiagnosisMapper {

    DiagnosisResponse toResponse(DiagnosisDto diagnosisDto);
    List<DiagnosisResponse> toResponseList(List<DiagnosisDto> diagnosisDtoList);
}
