package de.coronavirus.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import de.coronavirus.domain.infrastructure.repositories.AddressRepository;
import de.coronavirus.domain.infrastructure.repositories.EmailAddressRepository;
import de.coronavirus.domain.infrastructure.repositories.PhoneNumberRepository;
import de.coronavirus.domain.infrastructure.repositories.DiagnosisRepository;

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
    
    public List<PhoneNumber> findPhoneNumbersStartingWith(String partialNumber){
    	
    }
    
    
    public List<Address> findAddressesStartingWith(String partialAddress){
    	
    }
    
    
    public List<EmailAddress> findEmailAddressesStartingWith(String partialEmailAddress){
    	
    }
    
    
    public List<Diagnosis> findDiagnosisStartingWith(String partialDiagnosis){
    	
    }

    
}
