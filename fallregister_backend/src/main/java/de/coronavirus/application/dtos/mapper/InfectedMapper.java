package de.coronavirus.application.dtos.mapper;

import de.coronavirus.application.dtos.response.InfectedResponse;
import de.coronavirus.application.dtos.service.InfectedDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InfectedMapper {

    InfectedResponse toResponse(InfectedDto infectedDto);
    List<InfectedResponse> toResponseList(List<InfectedDto> infectedDtoList);
}
