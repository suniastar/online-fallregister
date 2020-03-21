package de.coronavirus.application.dtos.mapper;

import de.coronavirus.application.dtos.response.EmailAddressResponse;
import de.coronavirus.application.dtos.service.EmailAddressDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmailAddressMapper {

    EmailAddressResponse toResponse(EmailAddressDto emailAddressDTO);
    List<EmailAddressResponse> toResponseList(List<EmailAddressDto> emailAddressDtoList);
}
