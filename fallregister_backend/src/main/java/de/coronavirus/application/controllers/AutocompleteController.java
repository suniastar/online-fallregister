package de.coronavirus.application.controllers;

import de.coronavirus.application.controllers.api.AutocompleteAPI;
import de.coronavirus.application.serive.AutocompleteService;
import edu.kit.tm.cm.tlm.todomanagement.application.dtos.service.TodoListDto;
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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.ArrayList;


@RestController
@CrossOrigin
public class AutocompleteController implements AutocompleteAPI {
	
	
	
	private final AutocompleteService autocompleteService;
	private final AddressMapper addressMapper;
	private final EmailAddressMapper emailAdressMapper;
	private final DiagnosisMapper diagnosisMapper;
	private final PhoneNumberMapper phoneNumberMapper;

	
    @Autowired
    public AutocompleteController(AutocompleteService autocompleteService, 
    		AddressMapper addressMapper, 
    		EmailAddressMapper emailAdressMapper,
    		DiagnosisMapper diagnosisMapper,
    		PhoneNumberMapper phoneNumberMapper) {
        this.autocompleteService = autocompleteService;
        this.addressMapper = addressMapper;
        this.emailAddressMapper = emailAddressMapper;
        this.diagnosisMapper = diagnosisMapper;
        this.phoneNumberMapper = phoneNumberMapper;

    }

	
	@Override
    PhoneNumberResponse autocompletePhone(@RequestParam String partialPhone) {
        List<PhoneNumberDTO> phoneNumbers = autocompleteService.findPhoneNumbersStartingWith(partialPhone);
        return phoneNumberMapper.toResponseList(phoneNumbers);
		
	}
	
	@Override
    EmailAddressResponse autocompleteEmail(@RequestParam String partialEmail) {
        List<EmailAddressDTO> emailAddresses = autocompleteService.findEmailAddressesStartingWith(partialEmail);
        return emailAddressMapper.toResponseList(emailAddresses);
	}


	@Override
    List<AddressResponse> autocompleteAddress(@RequestParam String partialStreet){
		List<AddressDTO> addresses = autocompleteService.findAddressesStartingWith(partialStreet);
		List<AddressResponse> responses = new ArrayList<>();
		for (AddressDTO address : addresses) {
			responses.add(addressMapper.toResponse(address));
		}
		return responses;
		
	}

	@Override
    DiagnosisResponse autocompleteDiagnosis(@RequestParam String partialDiagnosis) {
        List<DiagnosisDTO> diagnosis = autocompleteService.findDiagnosisStartingWith(partialDiagnosis);
        return diagnosisMapper.toResponseList(diagnosis);
	}

}
