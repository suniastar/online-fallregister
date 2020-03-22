package de.coronavirus.application.service;

import de.coronavirus.application.dtos.request.CreateInfectedRequest;
import de.coronavirus.application.dtos.request.UpdateInfectedRequest;
import de.coronavirus.application.dtos.service.InfectedDto;
import de.coronavirus.domain.exception.NotFoundException;
import de.coronavirus.domain.infrastructure.repositories.*;
import de.coronavirus.domain.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class InfectedService {

    private final InfectedRepository infectedRepository;

    @Autowired
    public InfectedService(InfectedRepository infectedRepository) {
        this.infectedRepository = infectedRepository;
    }

    public List<InfectedDto> findAll() {
        return infectedRepository.findAllDtoBy();
    }

    public InfectedDto findInfected(long id) {
        return infectedRepository.findDtoById(id).orElseThrow(() -> new NotFoundException("Error: Infected Person not found!", "The infected Person could not been found!"));
    }

    public InfectedDto createInfected(CreateInfectedRequest createRequest) {
        Infected infected = new Infected();
        infected.setGender(Infected.Gender.valueOf(createRequest.getGender()));
        infected.setFirstName(createRequest.getFirstName());
        infected.setLastName(createRequest.getLastName());
        infected.setDateOfBirth(createRequest.getDateOfBirth());

        if(createRequest.getPhoneNumbers() != null && !createRequest.getPhoneNumbers().isEmpty()) {
            List<PhoneNumber> phoneNumbers = new ArrayList<>();
            for(String number : createRequest.getPhoneNumbers()){
                PhoneNumber phoneNumber = new PhoneNumber();
                phoneNumber.setNumber(number);
                phoneNumbers.add(phoneNumber);
            }
            infected.setPhoneNumbers(phoneNumbers);
        }

        Country country = new Country();
        country.setName(createRequest.getCountry());
        City city = new City();
        city.setName(createRequest.getCityName());
        city.setCountry(country);
        PostCode postCode = new PostCode();
        postCode.setCode(createRequest.getPostCode());
        postCode.setCity(city);
        Street street = new Street();
        street.setName(createRequest.getStreetName());
        street.setPostCode(postCode);
        Address address = new Address();
        address.setStreet(street);
        address.setHouseNumber(createRequest.getHouseNumber());
        infected.setAddress(address);

        infected.setJobInMedicalField(createRequest.isJobInMedicalField());
        infected.setJobInFoodFiled(createRequest.isJobInFoodField());
        infected.setJobInCommunityField(createRequest.isJobInCommunityField());

        if(createRequest.getAccommodationName() != null && !createRequest.getAccommodationName().isEmpty()) {
            Accommodation accommodation = new Accommodation();
            accommodation.setName(createRequest.getAccommodationName());
            infected.setAccommodation(accommodation);
        }

        List<Diagnosis> diagnoses = new ArrayList<>();
        Diagnosis diagnosis = new Diagnosis();
        diagnosis.setDiagnosticResult(createRequest.getDiagnosisResult());
        diagnosis.setDate(createRequest.getDate());
        diagnoses.add(diagnosis);
        infected.setDiagnoses(diagnoses);

        if(createRequest.getDateOfIllness() != null) {
            infected.setDateOfIllness(createRequest.getDateOfIllness());
        }

        if(createRequest.getDateOfDeath() != null) {
            infected.setDateOfDeath(createRequest.getDateOfDeath());
        }

        if(!createRequest.getInfectionSource().isEmpty()) {
            infected.setInfectionSource(createRequest.getInfectionSource());
        }
        infected.setIntensiveCareTreatment(createRequest.isIntensiveCareTreatment());
        infectedRepository.saveAndFlush(infected);
        return infectedRepository.findDtoById(infected.getId()).orElseThrow(() -> new NotFoundException("Error: Infected person not found!","The infected Person could not been found!"));
    }

    public InfectedDto updateInfected(UpdateInfectedRequest updateRequest, long id) {
        return findInfected(id);
    }

    public void delete(long id) {
        infectedRepository.deleteById(id);
    }
}
