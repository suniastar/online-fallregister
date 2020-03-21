package de.coronavirus.application.dtos.mapper;

import de.coronavirus.application.dtos.response.InfectedResponse;
import de.coronavirus.application.dtos.service.InfectedDto;
import de.coronavirus.application.dtos.service.PhoneNumberDto;

import java.util.ArrayList;
import java.util.List;

public class InfectedMapper {

    public static InfectedResponse toResponse(InfectedDto infectedDto){
        return infectedDtoToResponse(infectedDto);
    }

    public static List<InfectedResponse> toResponseList(List<InfectedDto> infectedDtoList){
        List<InfectedResponse> infectedResponseList = new ArrayList<InfectedResponse>();
        for(InfectedDto infectedDto : infectedDtoList){
            infectedResponseList.add(infectedDtoToResponse(infectedDto));
        }
        return infectedResponseList;
    }

    private static InfectedResponse infectedDtoToResponse(InfectedDto infectedDto){
        InfectedResponse infectedResponse = new InfectedResponse();
        infectedResponse.setFirstName(infectedDto.getFirstName());
        infectedResponse.setLastName(infectedDto.getLastName());
        infectedResponse.setGender(infectedDto.getGender().toString());
        infectedResponse.setDateOfBirth(infectedDto.getDateOfBirth());
        for(PhoneNumberDto phoneNumberDto : infectedDto.getPhoneNumbers()) {
            infectedResponse.getPhoneNumbers().add(phoneNumberDto.getNumber());
        }
        infectedResponse.setHouseNumber(infectedDto.getAddress().getHouseNumber());
        infectedResponse.setStreetName(infectedDto.getAddress().getStreet().getName());
        infectedResponse.setCityName(infectedDto.getAddress().getStreet().getPostCode().getCity().getName());
        infectedResponse.setCountry(infectedDto.getAddress().getStreet().getPostCode().getCity().getCountry().getName());
        infectedResponse.setAccommodationName(infectedDto.getAccommodation().getName());
        infectedResponse.setDateOfIllness(infectedDto.getDateOfIllness());
        infectedResponse.setDateOfDeath(infectedDto.getDateOfDeath());
        infectedResponse.setInfectionSource(infectedDto.getInfectionSource());
        infectedResponse.setIntensiveCareTreatment(infectedDto.getIntensiveCareTreatment());
        return infectedResponse;
    }
}
