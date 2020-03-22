package de.coronavirus.application.dtos.mapper;

import de.coronavirus.application.dtos.response.autocomplete.ACLaboratoryNameResponse;
import de.coronavirus.application.dtos.service.LaboratoryDto;

import java.util.List;

public class LaboratoryMapper {

    public static ACLaboratoryNameResponse toNameResponse(LaboratoryDto laboratoryDto) {
        ACLaboratoryNameResponse laboratoryNameResponse = new ACLaboratoryNameResponse();
        laboratoryNameResponse.getNames().add(laboratoryDto.getName());
        return laboratoryNameResponse;
    }

    public static ACLaboratoryNameResponse toNameResponse(List<LaboratoryDto> laboratoryDtoList) {
        ACLaboratoryNameResponse laboratoryNameResponse = new ACLaboratoryNameResponse();
        for(LaboratoryDto laboratoryDto : laboratoryDtoList) {
            laboratoryNameResponse.getNames().add(laboratoryDto.getName());
        }
        return laboratoryNameResponse;
    }
}
