package de.coronavirus.application.dtos.mapper;

import de.coronavirus.application.dtos.response.autocomplete.ACAddressResponse;
import de.coronavirus.application.dtos.service.CityDto;
import de.coronavirus.application.dtos.service.CountryDto;
import de.coronavirus.application.dtos.service.PostCodeDto;

import java.util.ArrayList;
import java.util.List;

public class AddressMapper {

    private AddressMapper() {}

    public static ACAddressResponse toResponse(PostCodeDto postCodeDto) {
        ACAddressResponse response = new ACAddressResponse();

        response.setPostCode(postCodeDto.getCode());
        response.setCityName(postCodeDto.getCity().getName());
        response.setCountryName(postCodeDto.getCity().getCountry().getName());

        return response;
    }
    public static ACAddressResponse toResponse(CityDto cityDto){
        ACAddressResponse response = new ACAddressResponse();

        response.setCityName(cityDto.getName());
        response.setCountryName(cityDto.getCountry().getName());

        return response;
    }
    public static ACAddressResponse toResponse(CountryDto countryDto) {
        ACAddressResponse response = new ACAddressResponse();

        response.setCountryName(countryDto.getName());

        return response;
    }

    public static List<ACAddressResponse> PostCodeDtoToResponseList(List<PostCodeDto> postCodeDtoList) {
        List<ACAddressResponse> responseList = new ArrayList<>();

        for(PostCodeDto postCodeDto : postCodeDtoList) {
            responseList.add(toResponse(postCodeDto));
        }

        return responseList;
    }

    public static List<ACAddressResponse> CityDtoToResponseList(List<CityDto> cityDtoList) {
        List<ACAddressResponse> responseList = new ArrayList<>();

        for(CityDto cityDto : cityDtoList){
            responseList.add(toResponse(cityDto));
        }

        return responseList;
    }

    public static List<ACAddressResponse> CountryDtoToResponseList(List<CountryDto> countryDtoList) {
        List<ACAddressResponse> responseList = new ArrayList<>();

        for(CountryDto countryDto : countryDtoList) {
            responseList.add(toResponse(countryDto));
        }

        return responseList;
    }

}
