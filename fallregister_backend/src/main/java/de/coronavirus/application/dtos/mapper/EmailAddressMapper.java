package de.coronavirus.application.dtos.mapper;

import de.coronavirus.application.dtos.response.EmailAddressResponse;
import de.coronavirus.application.dtos.service.EmailAddressDto;

import java.util.List;

public class EmailAddressMapper {

    public static EmailAddressResponse toResponse(EmailAddressDto emailAddressDto){
        EmailAddressResponse emailAddressResponse = new EmailAddressResponse();
        emailAddressResponse.getEmailAddress().add(emailAddressDto.getEmail());
        return emailAddressResponse;
    }

    public static EmailAddressResponse toResponseList(List<EmailAddressDto> emailAddressDtoList){
        EmailAddressResponse emailAddressResponse = new EmailAddressResponse();
        for(EmailAddressDto emailAddressDto : emailAddressDtoList) {
            emailAddressResponse.getEmailAddress().add(emailAddressDto.getEmail());
        }
        return emailAddressResponse;
    }
}
