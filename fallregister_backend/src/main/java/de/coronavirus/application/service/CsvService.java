package de.coronavirus.application.service;

import de.coronavirus.application.dtos.request.CreateInfectedRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

@Service
@Transactional
public class CsvService {

    public final InfectedService infectedService;

    @Autowired
    public CsvService(InfectedService infectedService){
        this.infectedService = infectedService;
    }

    public void createInfectedFromCsv(String csv){
        String[] lines = csv.split("\n");
        String[] header = lines[0].split(",");
        ArrayList<String[]> infectedList = new ArrayList<>();
        for(int i = 1; i<lines.length; i++){
            infectedList.add(lines[i].split(","));
        }

        ArrayList<CreateInfectedRequest> createInfectedRequestList = new ArrayList<>();
        for(int i = 0; i < header.length; i++){
            createInfectedRequestList.add(new CreateInfectedRequest());
        }

        for(int j = 0; j < infectedList.size(); j++){
            CreateInfectedRequest createInfectedRequest =  createInfectedRequestList.get(j);
            for(int i = 0; i < header.length; i++){
                String infectedAttr = (infectedList.get(j))[i];
                switch(header[i]){
                    case "patientFirstName":
                        createInfectedRequest.setPatientFirstName(infectedAttr);
                        break;
                    case "patientLastName":
                        createInfectedRequest.setPatientLastName(infectedAttr);
                        break;
                    case "patientAddressHousenumber":
                        createInfectedRequest.setPatientAddressHousenumber(infectedAttr);
                        break;
                    case "patientAddressStreet":
                        createInfectedRequest.setPatientAddressStreet(infectedAttr);
                        break;
                    case "patientAddressZipcode":
                        createInfectedRequest.setPatientAddressZipcode(Integer.valueOf(infectedAttr));
                        break;
                    case "patientAddressCity":
                        createInfectedRequest.setPatientAddressCity(infectedAttr);
                        break;
                    case "patientAddressCountry":
                        createInfectedRequest.setPatientAddressCountry(infectedAttr);
                        break;
                    case "patientBirthday":
                        createInfectedRequest.setPatientBirthday(Date.from(Instant.parse(infectedAttr)));
                        break;
                    case "patientSex":
                        createInfectedRequest.setPatientSex(infectedAttr);
                        break;
                    case "patientPhone":
                        createInfectedRequest.setPatientPhone(infectedAttr);
                        break;
                    case "patientEmail":
                        createInfectedRequest.setPatientEmail(infectedAttr);
                        break;
                    case "detectorFirstName":
                        createInfectedRequest.setDetectorFirstName(infectedAttr);
                        break;
                    case "detectorLastName":
                        createInfectedRequest.setDetectorLastName(infectedAttr);
                        break;
                    case "detectorAddressHousenumber":
                        createInfectedRequest.setDetectorAddressHousenumber(infectedAttr);
                        break;
                    case "detectorAddressStreet":
                        createInfectedRequest.setDetectorAddressStreet(infectedAttr);
                        break;
                    case "detectorAddressZipcode":
                        createInfectedRequest.setDetectorAddressZipcode(Integer.valueOf(infectedAttr));
                        break;
                    case "detectorAddressCity":
                        createInfectedRequest.setDetectorAddressCity(infectedAttr);
                        break;
                    case "detectorAddressCountry":
                        createInfectedRequest.setDetectorAddressCountry(infectedAttr);
                        break;
                    case "datectorPhone":
                        createInfectedRequest.setDatectorPhone(infectedAttr);
                        break;
                    case "detectorEmail":
                        createInfectedRequest.setDetectorEmail(infectedAttr);
                        break;
                    case "diagnosisName":
                        createInfectedRequest.setDiagnosisName(infectedAttr);
                        break;
                    case "diagnosisSuspected":
                        createInfectedRequest.setDiagnosisSuspected(Boolean.valueOf(infectedAttr));
                        break;
                    case "diagnosisDiagnosed":
                        createInfectedRequest.setDiagnosisDiagnosed(Boolean.valueOf(infectedAttr));
                        break;
                    case "diagnosisDead":
                        createInfectedRequest.setDiagnosisDead(Boolean.valueOf(infectedAttr));
                        break;
                    case "diagnosisDateOfSickness":
                        createInfectedRequest.setDiagnosisDateOfSickness(Date.from(Instant.parse(infectedAttr)));
                        break;
                    case "diagnosisDateOfDiagnosis":
                        createInfectedRequest.setDiagnosisDateOfDiagnosis(Date.from(Instant.parse(infectedAttr)));
                        break;
                    case "dateOfDeath":
                        createInfectedRequest.setDateOfDeath(Date.from(Instant.parse(infectedAttr)));
                        break;
                    case "jobMedical":
                        createInfectedRequest.setJobMedical(Boolean.valueOf(infectedAttr));
                        break;
                    case "jobFood":
                        createInfectedRequest.setJobFood(Boolean.valueOf(infectedAttr));
                        break;
                    case "jobCommunal":
                        createInfectedRequest.setJobCommunal(Boolean.valueOf(infectedAttr));
                        break;
                    case "infectionPlace":
                        createInfectedRequest.setInfectionPlace(infectedAttr);
                        break;
                    case "infectionSource":
                        createInfectedRequest.setInfectionSource(infectedAttr);
                        break;
                    case "infectionEpidemi":
                        createInfectedRequest.setInfectionEpidemi(Boolean.valueOf(infectedAttr));
                        break;
                    case "infectionEpidemiSource":
                        createInfectedRequest.setInfectionEpidemiSource(infectedAttr);
                        break;
                    case "accommodationCommunal":
                        createInfectedRequest.setAccommodationCommunal(Boolean.valueOf(infectedAttr));
                        break;
                    case "accommodationHospital":
                        createInfectedRequest.setAccommodationHospital(Boolean.valueOf(infectedAttr));
                        break;
                    case "accommodationDateOfHospitalisation":
                        createInfectedRequest.setAccommodationDateOfHospitalisation(Date.from(Instant.parse(infectedAttr)));
                        break;
                    case "accommodationIcu":
                        createInfectedRequest.setAccommodationIcu(Boolean.valueOf(infectedAttr));
                        break;
                    case "accommodationDateOfIcu":
                        createInfectedRequest.setAccommodationDateOfIcu(Date.from(Instant.parse(infectedAttr)));
                        break;
                    case "accommodationNameAndAddress":
                        createInfectedRequest.setAccommodationNameAndAddress(infectedAttr);
                        break;
                    case "detectionOfficeName":
                        createInfectedRequest.setDetectionOfficeName(infectedAttr);
                        break;
                    case "detectionOfficeAddressStreet":
                        createInfectedRequest.setDetectionOfficeAddressStreet(infectedAttr);
                        break;
                    case "detectionOfficeAddressHousenumber":
                        createInfectedRequest.setDetectionOfficeAddressHousenumber(infectedAttr);
                        break;
                    case "detectionOfficeAddressZipcode":
                        createInfectedRequest.setDetectionOfficeAddressZipcode(Integer.valueOf(infectedAttr));
                        break;
                    case "detectionOfficeAddressCity":
                        createInfectedRequest.setDetectionOfficeAddressCity(infectedAttr);
                        break;
                    case "detectionOfficeAddressCountry":
                        createInfectedRequest.setDetectionOfficeAddressCountry(infectedAttr);
                        break;
                    case "detectionOfficePhone":
                        createInfectedRequest.setDetectionOfficePhone(infectedAttr);
                        break;
                    case "detectionOfficeEmail":
                        createInfectedRequest.setDetectionOfficeEmail(infectedAttr);
                        break;
                    case "detectionOfficeUntersuchungsstelle":
                        createInfectedRequest.setDetectionOfficeUntersuchungsstelle(infectedAttr);
                        break;
                    case "laboratoryCommission":
                        createInfectedRequest.setLaboratoryCommission(infectedAttr);
                        break;
                    case "laboratoryName":
                        createInfectedRequest.setLaboratoryName(infectedAttr);
                        break;
                    case "laboratoryLocation":
                        createInfectedRequest.setLaboratoryLocation(infectedAttr);
                        break;
                    case "laboratoryPhone":
                        createInfectedRequest.setLaboratoryPhone(infectedAttr);
                        break;
                    case "laboratoryDateOfBiopsy":
                        createInfectedRequest.setLaboratoryDateOfBiopsy(infectedAttr);
                        break;
                }
            }
            infectedService.createInfected(createInfectedRequest);
        }
    }

}
