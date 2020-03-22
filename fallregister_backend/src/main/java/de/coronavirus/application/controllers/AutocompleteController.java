package de.coronavirus.application.controllers;

import de.coronavirus.application.controllers.api.AutocompleteApi;
import de.coronavirus.application.dtos.mapper.*;
import de.coronavirus.application.dtos.response.autocomplete.*;
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

    @Autowired
    public AutocompleteController(AutocompleteService autocompleteService) {

        this.autocompleteService = autocompleteService;
    }

    @Override
    public ACDiagnosisNameResponse autocompleteDiagnosisName(String partialDiagnosisName) {
        List<DiagnosisDto> diagnosisDtos = autocompleteService.findDiagnosisNamesStartingWith(partialDiagnosisName);
        return DiagnosisMapper.toNameResponse(diagnosisDtos);
    }

    @Override
    public ACLaboratoryNameResponse autocompleteLaboratoryName(String partialLaboratoryName) {
        List<LaboratoryDto> laboratoryDtos = autocompleteService.findLaboratoryNamesStartingWith(partialLaboratoryName);
        return LaboratoryMapper.toNameResponse(laboratoryDtos);
    }

    @Override
    public ACStreetNameResponse autocompleteStreet(@PathVariable String partialStreet){
		List<StreetDto> streets = autocompleteService.findStreetsStartingWith(partialStreet);
		return StreetMapper.toResponse(streets);
	}

    @Override
    public List<ACAddressResponse> autocompletePostalCode(String partialPostCode) {
        List<PostCodeDto> postCodes = autocompleteService.findPostCodesStartingWith(partialPostCode);
        return AddressMapper.PostCodeDtoToResponseList(postCodes);
    }

    @Override
    public List<ACAddressResponse> autocompleteCity(String partialCity) {
        List<CityDto> cities = autocompleteService.findCitiesStartingWith(partialCity);
        return AddressMapper.CityDtoToResponseList(cities);
    }

    @Override
    public List<ACAddressResponse> autocompleteCountry(String partialCountry) {
        List<CountryDto> countries = autocompleteService.findCountriesStartingWith(partialCountry);
        return AddressMapper.CountryDtoToResponseList(countries);
    }

}
