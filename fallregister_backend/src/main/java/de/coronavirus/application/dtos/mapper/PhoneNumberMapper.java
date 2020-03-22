package de.coronavirus.application.dtos.mapper;

import de.coronavirus.application.dtos.response.PhoneNumberResponse;
import de.coronavirus.application.dtos.service.PhoneNumberDto;

import java.util.ArrayList;
import java.util.List;

public class PhoneNumberMapper {

    public static PhoneNumberResponse toResponse(PhoneNumberDto phoneNumberDto){
        PhoneNumberResponse phoneNumberResponse = new PhoneNumberResponse();
        phoneNumberResponse.getNumbers().add(phoneNumberDto.getNumber());
        return phoneNumberResponse;
    }

    public static PhoneNumberResponse toResponse(List<PhoneNumberDto> phoneNumberDtoList){
        PhoneNumberResponse phoneNumberResponse = new PhoneNumberResponse();
        for(PhoneNumberDto phoneNumberDto : phoneNumberDtoList){
            phoneNumberResponse.getNumbers().add(phoneNumberDto.getNumber());
        }
        return phoneNumberResponse;
    }
}
