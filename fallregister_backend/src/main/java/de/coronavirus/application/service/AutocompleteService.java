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
	private final DiagnosisRepository diagnosisRepository;
	private final LaboratoryRepository laboratoryRepository;


    @Autowired
    public AutocompleteService(CountryRepository countryRepository,
            CityRepository cityRepository,
    		PostCodeRepository postCodeRepository,
    		StreetRepository streetRepository,
    		DiagnosisRepository diagnosisRepository,
           LaboratoryRepository laboratoryRepository) {

        this.countryRepository = countryRepository;
    	this.cityRepository = cityRepository;
    	this.postCodeRepository = postCodeRepository;
    	this.streetRepository = streetRepository;
    	this.diagnosisRepository = diagnosisRepository;
    	this.laboratoryRepository = laboratoryRepository;

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

    public List<LaboratoryDto> findLaboratoryNamesStartingWith(String partialLaboratory) {
        return laboratoryRepository.findTop10ByNameStartsWith(partialLaboratory);
    }
    
    public List<DiagnosisDto> findDiagnosisNamesStartingWith(String partialDiagnosis) {
    	return diagnosisRepository.findTop10ByDiagnosticResultStartsWith(partialDiagnosis);
    }

    
}
