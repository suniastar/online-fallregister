package de.coronavirus.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import de.coronavirus.domain.infrastructure.repositories.AddressRepository;
import de.coronavirus.domain.infrastructure.repositories.EmailAddressRepository;
import de.coronavirus.domain.infrastructure.repositories.PhoneNumberRepository;
import de.coronavirus.domain.infrastructure.repositories.DiagnosisRepository;

import de.coronavirus.application.dtos.service.AddressDTO;
import de.coronavirus.application.dtos.service.EmailAddressDTO;
import de.coronavirus.application.dtos.service.PhoneNumberDTO;
import de.coronavirus.application.dtos.service.DiagnosisDTO;

import java.util.List;

@Service
@Transactional
public class AutocompleteService {
	
	private final AddressRepository addressRepository;
	private final EmailAddressRepository emailAddressRepository;
	private final PhoneNumberRepository phoneNumberRepository;
	private final DiagnosisRepository diagnosisRepository;


    @Autowired
    public AutocompleteService(AddressRepository addressRepository, 
    		EmailAddressRepository emailAddressRepository, 
    		PhoneNumberRepository phoneNumberRepository,
    		DiagnosisRepository diagnosisRepository) {
    	
    	this.addressRepository = addressRepository;
    	this.emailAddressRepository = emailAddressRepository;
    	this.phoneNumberRepository = phoneNumberRepository;
    	this.diagnosisRepository = diagnosisRepository;

    }
    
    public List<PhoneNumberDTO> findPhoneNumbersStartingWith(String partialNumber){
    	return phoneNumberRepository.findTop10DtoByNumberStartsWithOrderByNumberAsc(partialNumber);
    }
    
    
    public List<AddressDTO> findAddressesStartingWith(String partialAddress){

    }
    
    
    public List<EmailAddressDTO> findEmailAddressesStartingWith(String partialEmailAddress){
    	
    }
    
    
    public List<DiagnosisDTO> findDiagnosisStartingWith(String partialDiagnosis){
    	
    }

    
}
