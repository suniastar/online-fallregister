package de.coronavirus.application.dtos.mapper;

import de.coronavirus.application.dtos.response.PhoneNumberResponse;
import de.coronavirus.application.dtos.service.PhoneNumberDto;

import java.util.ArrayList;
import java.util.List;

public class PhoneNumberMapper {

    PhoneNumberResponse toResponse(PhoneNumberDto phoneNumberDto){
        PhoneNumberResponse phoneNumberResponse = new PhoneNumberResponse();
        phoneNumberResponse.getNumbers().add(phoneNumberDto.getNumber());
        return phoneNumberResponse;
    }

    List<PhoneNumberResponse> toResponseList(List<PhoneNumberDto> phoneNumberDtoList){
        List<PhoneNumberResponse> phoneNumberResponseList = new ArrayList<>();
        for(PhoneNumberDto phoneNumberDto : phoneNumberDtoList){
            PhoneNumberResponse phoneNumberResponse = new PhoneNumberResponse();
            phoneNumberResponse.getNumbers().add(phoneNumberDto.getNumber());
        }
        return phoneNumberResponseList;
    }
}
