package de.coronavirus.application.controllers;

import de.coronavirus.application.controllers.api.AutocompleteApi;
import de.coronavirus.application.dtos.response.AddressResponse;
import de.coronavirus.application.service.AutocompleteService;
import de.coronavirus.application.dtos.service.AddressDTO;
import de.coronavirus.application.dtos.service.EmailAddressDTO;
import de.coronavirus.application.dtos.service.PhoneNumberDTO;
import de.coronavirus.application.dtos.service.DiagnosisDTO;
import de.coronavirus.application.dtos.response.DiagnosisResponse;
import de.coronavirus.application.dtos.response.EmailAddressResponse;
import de.coronavirus.application.dtos.response.PhoneNumberResponse;
import de.coronavirus.application.dtos.mapper.AddressMapper;
import de.coronavirus.application.dtos.mapper.DiagnosisMapper;
import de.coronavirus.application.dtos.mapper.EmailAddressMapper;
import de.coronavirus.application.dtos.mapper.PhoneNumberMapper;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@RestController
@CrossOrigin
public class AutocompleteController implements AutocompleteApi {
	
	
	
	private final AutocompleteService autocompleteService;
	private final AddressMapper addressMapper;
	private final EmailAddressMapper emailAddressMapper;
	private final DiagnosisMapper diagnosisMapper;
	private final PhoneNumberMapper phoneNumberMapper;

	
    @Autowired
    public AutocompleteController(AutocompleteService autocompleteService, 
    		AddressMapper addressMapper, 
    		EmailAddressMapper emailAddressMapper,
    		DiagnosisMapper diagnosisMapper,
    		PhoneNumberMapper phoneNumberMapper) {
        this.autocompleteService = autocompleteService;
        this.addressMapper = addressMapper;
        this.emailAddressMapper = emailAddressMapper;
        this.diagnosisMapper = diagnosisMapper;
        this.phoneNumberMapper = phoneNumberMapper;

    }

	
	@Override
    PhoneNumberResponse autocompletePhone(@PathVariable String partialPhone) {
        List<PhoneNumberDTO> phoneNumbers = autocompleteService.findPhoneNumbersStartingWith(partialPhone);
        return phoneNumberMapper.toResponseList(phoneNumbers);
		
	}
	
	@Override
    EmailAddressResponse autocompleteEmail(@PathVariable String partialEmail) {
        List<EmailAddressDTO> emailAddresses = autocompleteService.findEmailAddressesStartingWith(partialEmail);
        return emailAddressMapper.toResponseList(emailAddresses);
	}


	@Override
    List<AddressResponse> autocompleteAddress(@PathVariable String partialStreet){
		List<AddressDTO> addresses = autocompleteService.findAddressesStartingWith(partialStreet);
		return AddressMapper.toResponseList(addresses);
		
	}

	@Override
    DiagnosisResponse autocompleteDiagnosis(@PathVariable String partialDiagnosis) {
        List<DiagnosisDTO> diagnosis = autocompleteService.findDiagnosisStartingWith(partialDiagnosis);
        return diagnosisMapper.toResponseList(diagnosis);
	}

}
