package de.coronavirus.application.dtos.mapper;

import de.coronavirus.application.dtos.response.PhoneNumberResponse;
import de.coronavirus.application.dtos.service.PhoneNumberDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PhoneNumberMapper {

    PhoneNumberResponse toResponse(PhoneNumberDto phoneNumberDTO);
    List<PhoneNumberResponse> toResponseList(List<PhoneNumberDto> phoneNumberDTOList);
}
