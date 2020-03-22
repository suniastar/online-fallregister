package de.coronavirus.application.dtos.mapper;

import de.coronavirus.application.dtos.response.StreetResponse;
import de.coronavirus.application.dtos.service.StreetDto;

import java.util.List;

public class StreetMapper {

    private StreetMapper(){}

    public static StreetResponse toResponse(StreetDto streetDto) {
        StreetResponse response = new StreetResponse();

        response.getStreet().add(streetDto.getName());

        return response;
    }

    public static StreetResponse toResponse(List<StreetDto> streetDtoList) {
        StreetResponse response = new StreetResponse();

        for(StreetDto street : streetDtoList) {
            response.getStreet().add(street.getName());
        }

        return response;
    }
}
