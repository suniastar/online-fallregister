package de.coronavirus.application.service;

import de.coronavirus.application.dtos.service.*;
import de.coronavirus.domain.infrastructure.repositories.*;
import de.coronavirus.domain.model.PostCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AutocompleteService {

    private final CountryRepository countryRepository;
	private final CityRepository cityRepository;
	private final PostCodeRepository postCodeRepository;
	private final StreetRepository streetRepository;
	private final EmailAddressRepository emailAddressRepository;
	private final PhoneNumberRepository phoneNumberRepository;
	private final DiagnosisRepository diagnosisRepository;


    @Autowired
    public AutocompleteService(CountryRepository countryRepository,
            CityRepository cityRepository,
    		PostCodeRepository postCodeRepository,
    		StreetRepository streetRepository,
    		EmailAddressRepository emailAddressRepository, 
    		PhoneNumberRepository phoneNumberRepository,
    		DiagnosisRepository diagnosisRepository) {

        this.countryRepository = countryRepository;
    	this.cityRepository = cityRepository;
    	this.postCodeRepository = postCodeRepository;
    	this.streetRepository = streetRepository;
    	this.emailAddressRepository = emailAddressRepository;
    	this.phoneNumberRepository = phoneNumberRepository;
    	this.diagnosisRepository = diagnosisRepository;

    }
    
    public List<PhoneNumberDto> findPhoneNumbersStartingWith(String partialNumber){
    	return phoneNumberRepository.findTop10DtoByNumberStartsWithOrderByNumberAsc(partialNumber);
    }
    
    public List<StreetDto> findStreetsStartingWith(String partialStreet){
        return streetRepository.findTop10ByNameStartsWithOrderByNameAsc(partialStreet);
    }

    public List<PostCodeDto> findPostCodesStartingWith(String partialPostCode) {
        return postCodeRepository.findTop10ByCodeStartsWith(partialPostCode);
    }

    public List<CityDto> findCitiesStartingWith(String partialCity){
        return cityRepository.findTop10ByNameStartsWith(partialCity);
    }

    public List<CountryDto> findCountriesStartingWith(String partialCountry){
        return countryRepository.findTop10ByNameStartsWith(partialCountry);
    }
    
    public List<EmailAddressDto> findEmailAddressesStartingWith(String partialEmailAddress){
    	return null;
    }
    
    public List<DiagnosisDto> findDiagnosisStartingWith(String partialDiagnosis){
    	return null;
    }

    
}
