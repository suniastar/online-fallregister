package de.coronavirus.application.dtos.mapper;

import de.coronavirus.application.dtos.response.PhoneNumberResponse;
import de.coronavirus.application.dtos.service.PhoneNumberDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PhoneNumberMapper {

    PhoneNumberResponse toResponse(PhoneNumberDTO phoneNumberDTO);
    List<PhoneNumberResponse> toResponseList(List<PhoneNumberDTO> phoneNumberDTOList);
}
