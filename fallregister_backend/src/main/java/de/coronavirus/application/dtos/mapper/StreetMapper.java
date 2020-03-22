package de.coronavirus.application.dtos.mapper;

import de.coronavirus.application.dtos.response.autocomplete.ACStreetNameResponse;
import de.coronavirus.application.dtos.service.StreetDto;

import java.util.List;

public class StreetMapper {

    private StreetMapper(){}

    public static ACStreetNameResponse toResponse(StreetDto streetDto) {
        ACStreetNameResponse response = new ACStreetNameResponse();

        response.getNames().add(streetDto.getName());

        return response;
    }

    public static ACStreetNameResponse toResponse(List<StreetDto> streetDtoList) {
        ACStreetNameResponse response = new ACStreetNameResponse();

        for(StreetDto street : streetDtoList) {
            response.getNames().add(street.getName());
        }

        return response;
    }
}
