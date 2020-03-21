package de.coronavirus.application.service;

import de.coronavirus.application.dtos.mapper.InfectedMapper;
import de.coronavirus.application.dtos.mapper.StringsToModelConverter;
import de.coronavirus.application.dtos.request.CreateInfectedRequest;
import de.coronavirus.application.dtos.request.UpdateInfectedRequest;
import de.coronavirus.application.dtos.service.InfectedDto;
import de.coronavirus.domain.model.Infected;
import de.coronavirus.domain.infrastructure.repositories.InfectedRepository;
import de.coronavirus.domain.model.Accommodation;
import de.coronavirus.domain.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class InfectedService {

    private final InfectedRepository infectedRepository;
    private final InfectedMapper infectedMapper;

    @Autowired
    public InfectedService(InfectedRepository infectedRepository, InfectedMapper infectedMapper) {
        this.infectedRepository = infectedRepository;
        this.infectedMapper = infectedMapper;
    }

    public List<InfectedDto> findAll() {
        return infectedRepository.findAllDtoBy();
    }

    public Optional<InfectedDto> findInfected(long id) {
        return infectedRepository.findDtoById(id).orElseThrow(new NotFoundException("Error: Infected Person not found!",
                                                            "The infected Person could not been found!"));
    }

    public List<InfectedDto> saveAndFlush(InfectedDto ... infectedDTOS) {
        List<InfectedDto> resultInfected = new LinkedList<InfectedDto>;
        for(InfectedDto thisInfectedDto : infectedDTOS) {
            resultInfected.add(infectedRepository.saveAndFlush(thisInfectedDto));
        }
        return resultInfected;
    }

    public InfectedDto createInfected(CreateInfectedRequest createRequest) {
        Infected infected = new Infected();
        StringsToModelConverter.stringToGender(createRequest.getGender());
        infected.setGender(genderOfInfected);
        infected.setFirstName(createRequest.getFirstName());
        infected.setLastName(createRequest.getLastName());
        infected.setDateOfBirth(createRequest.getDateOfBirth());

        if(createRequest.getJobs() != null && !createRequest.getJobs().isEmpty()) {
            infected.setJobs(createRequest.getJobs());
        }

        if(createRequest.getPhoneNumber() != null && !createRequest.getPhoneNumber().isEmpty()) {
            List<PhoneNumber> numbers = StringsToModelConverter.stringsToPhoneNumber(createRequest.getPhoneNumber());
            infected.setPhoneNumber(numbers);
        }

        if(createRequest.getAccommodationName() != null && !createRequest.getAccommodationName().isEmpty()) {
            Accommodation accommodation = new Accommodation();
            accommodation.setName(createRequest.getAccommodation());
            infected.setAccomodation(accommodation);
        }

        // TODO: Model wants list of diagnoses but request delivers only one String
        List<Diagnosis> diagnoses = new ArrayList<Diagnosis>();
        diagnoses.add(createRequest.getDiagnosisResult();
        infected.setDiagnoses(diagnoses);

        if(createRequest.getDateOfIllness() != null) {
            infected.setDateOfIllness(createRequest.getDateOfIllness());
        }

        if(createRequest.getDateOfDeath() != null) {
            infected.setDateOfDeath(createRequest.getDateOfDeath());
        }

        if(!createRequest.getinfectionSource().isEmpty()) {
            infected.setInfectedSource(createRequest.getinfectionSource());
        }
        infected.setIntensiveCareTreatment(createRequest.isIntensiveCareTreatment());
        infectedRepository.saveAndFlush(infected);
        return infectedRepository.findDtoById(infected.getId());
    }

    public InfectedDto updateInfected(UpdateInfectedRequest updateRequest, long id) {
        Infected infected = findInfected(id);
    }

    public void delete(long id) {
        // ToDo: Throw Exception if the infected with this id is not found in the database
        infectedRepository.deleteById(id);
    }
}
