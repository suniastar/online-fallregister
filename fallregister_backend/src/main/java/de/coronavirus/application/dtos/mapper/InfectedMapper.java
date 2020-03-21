package de.coronavirus.application.dtos.mapper;

import de.coronavirus.application.dtos.response.InfectedResponse;
import de.coronavirus.application.dtos.service.InfectedDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InfectedMapper {

    InfectedResponse toResponse(InfectedDTO infectedDTO);
    List<InfectedResponse> toResponseList(List<InfectedDTO> infectedDTOList);
}
