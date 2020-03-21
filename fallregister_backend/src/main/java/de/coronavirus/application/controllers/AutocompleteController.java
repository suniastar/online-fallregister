package de.coronavirus.application.controllers;

import de.coronavirus.application.controllers.api.AutocompleteApi;
import de.coronavirus.application.dtos.mapper.*;
import de.coronavirus.application.dtos.response.*;
import de.coronavirus.application.dtos.service.*;
import de.coronavirus.application.service.AutocompleteService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@RestController
@CrossOrigin
public class AutocompleteController implements AutocompleteApi {
	
	
	
	private final AutocompleteService autocompleteService;
	private final StreetMapper streetMapper;
	private final AddressMapper addressMapper;
	private final EmailAddressMapper emailAddressMapper;
	private final DiagnosisMapper diagnosisMapper;
	private final PhoneNumberMapper phoneNumberMapper;

	
    @Autowired
    public AutocompleteController(AutocompleteService autocompleteService,
    		StreetMapper streetMapper,
    		AddressMapper addressMapper, 
    		EmailAddressMapper emailAddressMapper,
    		DiagnosisMapper diagnosisMapper,
    		PhoneNumberMapper phoneNumberMapper) {

        this.autocompleteService = autocompleteService;
        this.streetMapper = streetMapper;
        this.addressMapper = addressMapper;
        this.emailAddressMapper = emailAddressMapper;
        this.diagnosisMapper = diagnosisMapper;
        this.phoneNumberMapper = phoneNumberMapper;

    }

    @Override
    PhoneNumberResponse autocompletePhone(@PathVariable String partialPhone) {
        List<PhoneNumberDto> phoneNumbers = autocompleteService.findPhoneNumbersStartingWith(partialPhone);
        return null;
		
	}
	
	@Override
    public EmailAddressResponse autocompleteEmail(@PathVariable String partialEmail) {
        List<EmailAddressDto> emailAddresses = autocompleteService.findEmailAddressesStartingWith(partialEmail);
        return null;
	}


	@Override
    public StreetResponse autocompleteStreet(@PathVariable String partialStreet){
		List<StreetDto> streets = autocompleteService.findStreetsStartingWith(partialStreet);
		return StreetMapper.toResponse(streets);
	}

    @Override
    public List<AddressResponse> autocompletePostalCode(String partialPostCode) {
        List<PostCodeDto> postCodes = autocompleteService.findPostCodesStartingWith(partialPostCode);
        return AddressMapper.PostCodeDtoToResponseList(postCodes);
    }

    @Override
    public List<AddressResponse> autocompleteCity(String partialCity) {
        List<CityDto> cities = autocompleteService.findCitiesStartingWith(partialCity);
        return addressMapper.CityDtoToResponseList(cities);
    }

    @Override
    public List<AddressResponse> autocompleteCountry(String partialCountry) {
        List<CountryDto> countries = autocompleteService.findCountriesStartingWith(partialCountry);
        return addressMapper.CountryDtoToResponseList(countries);
    }

//	@Override
//    DiagnosisResponse autocompleteDiagnosis(@PathVariable String partialDiagnosis) {
//        List<DiagnosisDto> diagnosis = autocompleteService.findDiagnosisStartingWith(partialDiagnosis);
//        return null;
//	}


}
