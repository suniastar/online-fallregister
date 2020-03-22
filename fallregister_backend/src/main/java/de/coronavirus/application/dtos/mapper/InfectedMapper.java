package de.coronavirus.application.dtos.mapper;

import de.coronavirus.application.dtos.response.InfectedResponse;
import de.coronavirus.application.dtos.service.DiagnosisDto;
import de.coronavirus.application.dtos.service.EmailAddressDto;
import de.coronavirus.application.dtos.service.InfectedDto;
import de.coronavirus.application.dtos.service.PhoneNumberDto;
import de.coronavirus.domain.model.Diagnosis;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class InfectedMapper {

    public static InfectedResponse toResponse(InfectedDto infectedDto) {
        InfectedResponse infectedResponse = new InfectedResponse();
        infectedResponse.setId(infectedDto.getId());
        infectedResponse.setFirstName(infectedDto.getFirstName());
        infectedResponse.setLastName(infectedDto.getLastName());
        infectedResponse.setGender(infectedDto.getGender().toString());
        infectedResponse.setDateOfBirth(infectedDto.getDateOfBirth());
        if(infectedDto.getPhoneNumbers() != null) {
            for (PhoneNumberDto phoneNumberDto : infectedDto.getPhoneNumbers()) {
                infectedResponse.getPhoneNumbers().add(phoneNumberDto.getNumber());
            }
        }
        if(infectedDto.getEmailAddresses() != null){
            for (EmailAddressDto emailAddressDto : infectedDto.getEmailAddresses()) {
                infectedResponse.getEmailAddresses().add(emailAddressDto.getEmail());
            }
        }
        if(infectedDto.getDiagnoses() != null) {
            for (DiagnosisDto diagnosisDto : infectedDto.getDiagnoses()) {
                Diagnosis diagnosis = new Diagnosis();

                diagnosis.setDate(diagnosisDto.getDate());
                diagnosis.setDiagnosticResult(diagnosisDto.getDiagnosticResult());
                diagnosis.setClinicalDiagnosis(diagnosisDto.isClinicalDiagnosis());
                diagnosis.setConfirmed(diagnosisDto.isConfirmed());
                diagnosis.setDetectionOffice(diagnosisDto.getDetectionOffice());
                diagnosis.setId(diagnosisDto.getId());
                diagnosis.setDetector(diagnosisDto.getDetector());
                diagnosis.setInfected(diagnosisDto.getInfected());
                diagnosis.setLaboratory(diagnosisDto.getLaboratory());
                diagnosis.setSuspicion(diagnosisDto.isSuspicion());
                diagnosis.setDead(diagnosisDto.isDead());

                infectedResponse.getDiagnoses().add(diagnosis);
            }
        }

        if(infectedDto.getAddress() != null) {
            infectedResponse.setHouseNumber(infectedDto.getAddress().getHouseNumber());
            if(infectedDto.getAddress().getStreet() != null) {
                infectedResponse.setStreetName(infectedDto.getAddress().getStreet().getName());
                if(infectedDto.getAddress().getStreet().getPostCode() != null) {
                    infectedResponse.setPostCode(infectedDto.getAddress().getStreet().getPostCode().getCode());
                    if(infectedDto.getAddress().getStreet().getPostCode().getCity() != null) {
                        infectedResponse.setCityName(infectedDto.getAddress().getStreet().getPostCode().getCity().getName());
                        if (infectedDto.getAddress().getStreet().getPostCode().getCity().getCountry() != null) {
                            infectedResponse.setCountry(infectedDto.getAddress().getStreet().getPostCode().getCity().getCountry().getName());
                        }
                    }
                }
            }
        }
        if(infectedDto.getAccommodation() != null) {
            infectedResponse.setAccommodationName(infectedDto.getAccommodation().getName());
        }
        if(infectedDto.getDateOfIllness() != null) {
            infectedResponse.setDateOfIllness(infectedDto.getDateOfIllness());
        }
        if(infectedDto.getDateOfDeath() != null) {
            infectedResponse.setDateOfDeath(infectedDto.getDateOfDeath());
        }
        if(infectedDto.getInfectionSource() != null) {
            infectedResponse.setInfectionSource(infectedDto.getInfectionSource());
        }
        infectedResponse.setIntensiveCareTreatment(infectedDto.getIntensiveCareTreatment());
        infectedResponse.setJobInCommunityField(infectedDto.isJobInCommunityField());
        infectedResponse.setJobInFoodField(infectedDto.isJobInFoodFiled());
        infectedResponse.setJobInMedicalField(infectedDto.isJobInMedicalField());

        return infectedResponse;
    }

    public static List<InfectedResponse> toResponseList(List<InfectedDto> infectedDtoList) {
        List<InfectedResponse> infectedResponseList = new ArrayList<>();
        for (InfectedDto infectedDto : infectedDtoList) {
            infectedResponseList.add(toResponse(infectedDto));
        }
        return infectedResponseList;
    }

}