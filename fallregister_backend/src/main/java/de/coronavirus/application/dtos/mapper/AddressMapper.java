package de.coronavirus.application.dtos.mapper;

import de.coronavirus.application.dtos.response.AddressResponse;
import de.coronavirus.application.dtos.service.CityDto;
import de.coronavirus.application.dtos.service.CountryDto;
import de.coronavirus.application.dtos.service.PostCodeDto;

import java.util.ArrayList;
import java.util.List;

public class AddressMapper {

    private AddressMapper() {}

    public static AddressResponse toResponse(PostCodeDto postCodeDto) {
        AddressResponse response = new AddressResponse();

        response.setPostCode(postCodeDto.getCode());
        response.setCityName(postCodeDto.getCity().getName());
        response.setCountryName(postCodeDto.getCity().getCountry().getName());

        return response;
    }
    public static AddressResponse toResponse(CityDto cityDto){
        AddressResponse response = new AddressResponse();

        response.setCityName(cityDto.getName());
        response.setCountryName(cityDto.getCountry().getName());

        return response;
    }
    public static AddressResponse toResponse(CountryDto countryDto) {
        AddressResponse response = new AddressResponse();

        response.setCountryName(countryDto.getName());

        return response;
    }

    public static List<AddressResponse> PostCodeDtoToResponseList(List<PostCodeDto> postCodeDtoList) {
        List<AddressResponse> responseList = new ArrayList<>();

        for(PostCodeDto postCodeDto : postCodeDtoList) {
            responseList.add(toResponse(postCodeDto));
        }

        return responseList;
    }

    public static List<AddressResponse> CityDtoToResponseList(List<CityDto> cityDtoList) {
        List<AddressResponse> responseList = new ArrayList<>();

        for(CityDto cityDto : cityDtoList){
            responseList.add(toResponse(cityDto));
        }

        return responseList;
    }

    public static List<AddressResponse> CountryDtoToResponseList(List<CountryDto> countryDtoList) {
        List<AddressResponse> responseList = new ArrayList<>();

        for(CountryDto countryDto : countryDtoList) {
            responseList.add(toResponse(countryDto));
        }

        return responseList;
    }

}
