package de.coronavirus.application.dtos.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@ApiModel("Create Infected Entry")
public class CreateInfectedRequest {

    @NotEmpty
    @ApiModelProperty(required = true)
    String patientFirstName;

    @NotEmpty
    @ApiModelProperty(required = true)
    String patientLastName;

    @ApiModelProperty
    String patientAddressHousenumber;

    @ApiModelProperty
    String patientAddressStreet;

    @ApiModelProperty
    long patientAddressZipcode;

    @ApiModelProperty
    String patientAddressCity;

    @ApiModelProperty
    String patientAddressCountry;

    @NotNull
    @ApiModelProperty(required = true)
    Date patientBirthday;

    @NotNull
    @ApiModelProperty(required = true)
    String patientSex;

    @ApiModelProperty
    String patientPhone;

    @ApiModelProperty
    String patientEmail;

    @NotEmpty
    @ApiModelProperty(required = true)
    String detectorFirstName;

    @NotEmpty
    @ApiModelProperty(required = true)
    String detectorLastName;

    @ApiModelProperty
    String detectorAddressHousenumber;

    @ApiModelProperty
    String detectorAddressStreet;

    @ApiModelProperty
    long detectorAddressZipcode;

    @ApiModelProperty
    String detectorAddressCity;

    @ApiModelProperty
    String detectorAddressCountry;

    @ApiModelProperty
    String datectorPhone;

    @ApiModelProperty
    String detectorEmail;

    @NotEmpty
    @ApiModelProperty(required = true)
    String diagnosisName;

    @ApiModelProperty
    boolean diagnosisSuspected;

    @ApiModelProperty
    boolean diagnosisDiagnosed;

    @ApiModelProperty
    boolean diagnosisDead;

    @ApiModelProperty
    Date diagnosisDateOfSickness;

    @NotNull
    @ApiModelProperty(required = true)
    Date diagnosisDateOfDiagnosis;

    @ApiModelProperty
    Date dateOfDeath;

    @ApiModelProperty
    boolean jobMedical;

    @ApiModelProperty
    boolean jobFood;

    @ApiModelProperty
    boolean jobCommunal;

    @ApiModelProperty
    String infectionPlace;

    @ApiModelProperty
    String infectionSource;

    @ApiModelProperty
    boolean infectionEpidemi;

    @ApiModelProperty
    String infectionEpidemiSource;

    @ApiModelProperty
    boolean accommodationCommunal;

    @ApiModelProperty
    boolean accommodationHospital;

    @ApiModelProperty
    Date accommodationDateOfHospitalisation;

    @ApiModelProperty
    boolean accommodationIcu;

    @ApiModelProperty
    Date accommodationDateOfIcu;

    @ApiModelProperty
    String accommodationNameAndAddress;

    @ApiModelProperty
    String detectionOfficeName;

    @ApiModelProperty
    String detectionOfficeAddressStreet;

    @ApiModelProperty
    String detectionOfficeAddressHousenumber;

    @ApiModelProperty
    long detectionOfficeAddressZipcode;

    @ApiModelProperty
    String detectionOfficeAddressCity;

    @ApiModelProperty
    String detectionOfficeAddressCountry;

    @ApiModelProperty
    String detectionOfficePhone;

    @ApiModelProperty
    String detectionOfficeEmail;

    @ApiModelProperty
    String detectionOfficeUntersuchungsstelle;

    @ApiModelProperty
    String laboratoryCommission;

    @ApiModelProperty
    String laboratoryName;

    @ApiModelProperty
    String laboratoryLocation;

    @ApiModelProperty
    String laboratoryPhone;

    @ApiModelProperty
    String laboratoryDateOfBiopsy;

    public String getPatientFirstName() {
        return patientFirstName;
    }

    public void setPatientFirstName(String patientFirstName) {
        this.patientFirstName = patientFirstName;
    }

    public String getPatientLastName() {
        return patientLastName;
    }

    public void setPatientLastName(String patientLastName) {
        this.patientLastName = patientLastName;
    }

    public String getPatientAddressHousenumber() {
        return patientAddressHousenumber;
    }

    public void setPatientAddressHousenumber(String patientAddressHousenumber) {
        this.patientAddressHousenumber = patientAddressHousenumber;
    }

    public String getPatientAddressStreet() {
        return patientAddressStreet;
    }

    public void setPatientAddressStreet(String patientAddressStreet) {
        this.patientAddressStreet = patientAddressStreet;
    }

    public long getPatientAddressZipcode() {
        return patientAddressZipcode;
    }

    public void setPatientAddressZipcode(long patientAddressZipcode) {
        this.patientAddressZipcode = patientAddressZipcode;
    }

    public String getPatientAddressCity() {
        return patientAddressCity;
    }

    public void setPatientAddressCity(String patientAddressCity) {
        this.patientAddressCity = patientAddressCity;
    }

    public String getPatientAddressCountry() {
        return patientAddressCountry;
    }

    public void setPatientAddressCountry(String patientAddressCountry) {
        this.patientAddressCountry = patientAddressCountry;
    }

    public Date getPatientBirthday() {
        return patientBirthday;
    }

    public void setPatientBirthday(Date patientBirthday) {
        this.patientBirthday = patientBirthday;
    }

    public String getPatientSex() {
        return patientSex;
    }

    public void setPatientSex(String patientSex) {
        this.patientSex = patientSex;
    }

    public String getPatientPhone() {
        return patientPhone;
    }

    public void setPatientPhone(String patientPhone) {
        this.patientPhone = patientPhone;
    }

    public String getPatientEmail() {
        return patientEmail;
    }

    public void setPatientEmail(String patientEmail) {
        this.patientEmail = patientEmail;
    }

    public String getDetectorFirstName() {
        return detectorFirstName;
    }

    public void setDetectorFirstName(String detectorFirstName) {
        this.detectorFirstName = detectorFirstName;
    }

    public String getDetectorLastName() {
        return detectorLastName;
    }

    public void setDetectorLastName(String detectorLastName) {
        this.detectorLastName = detectorLastName;
    }

    public String getDetectorAddressHousenumber() {
        return detectorAddressHousenumber;
    }

    public void setDetectorAddressHousenumber(String detectorAddressHousenumber) {
        this.detectorAddressHousenumber = detectorAddressHousenumber;
    }

    public String getDetectorAddressStreet() {
        return detectorAddressStreet;
    }

    public void setDetectorAddressStreet(String detectorAddressStreet) {
        this.detectorAddressStreet = detectorAddressStreet;
    }

    public long getDetectorAddressZipcode() {
        return detectorAddressZipcode;
    }

    public void setDetectorAddressZipcode(long detectorAddressZipcode) {
        this.detectorAddressZipcode = detectorAddressZipcode;
    }

    public String getDetectorAddressCity() {
        return detectorAddressCity;
    }

    public void setDetectorAddressCity(String detectorAddressCity) {
        this.detectorAddressCity = detectorAddressCity;
    }

    public String getDetectorAddressCountry() {
        return detectorAddressCountry;
    }

    public void setDetectorAddressCountry(String detectorAddressCountry) {
        this.detectorAddressCountry = detectorAddressCountry;
    }

    public String getDatectorPhone() {
        return datectorPhone;
    }

    public void setDatectorPhone(String datectorPhone) {
        this.datectorPhone = datectorPhone;
    }

    public String getDetectorEmail() {
        return detectorEmail;
    }

    public void setDetectorEmail(String detectorEmail) {
        this.detectorEmail = detectorEmail;
    }

    public String getDiagnosisName() {
        return diagnosisName;
    }

    public void setDiagnosisName(String diagnosisName) {
        this.diagnosisName = diagnosisName;
    }

    public boolean isDiagnosisSuspected() {
        return diagnosisSuspected;
    }

    public void setDiagnosisSuspected(boolean diagnosisSuspected) {
        this.diagnosisSuspected = diagnosisSuspected;
    }

    public boolean isDiagnosisDiagnosed() {
        return diagnosisDiagnosed;
    }

    public void setDiagnosisDiagnosed(boolean diagnosisDiagnosed) {
        this.diagnosisDiagnosed = diagnosisDiagnosed;
    }

    public boolean isDiagnosisDead() {
        return diagnosisDead;
    }

    public void setDiagnosisDead(boolean diagnosisDead) {
        this.diagnosisDead = diagnosisDead;
    }

    public Date getDiagnosisDateOfSickness() {
        return diagnosisDateOfSickness;
    }

    public void setDiagnosisDateOfSickness(Date diagnosisDateOfSickness) {
        this.diagnosisDateOfSickness = diagnosisDateOfSickness;
    }

    public Date getDiagnosisDateOfDiagnosis() {
        return diagnosisDateOfDiagnosis;
    }

    public void setDiagnosisDateOfDiagnosis(Date diagnosisDateOfDiagnosis) {
        this.diagnosisDateOfDiagnosis = diagnosisDateOfDiagnosis;
    }

    public Date getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(Date dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public boolean isJobMedical() {
        return jobMedical;
    }

    public void setJobMedical(boolean jobMedical) {
        this.jobMedical = jobMedical;
    }

    public boolean isJobFood() {
        return jobFood;
    }

    public void setJobFood(boolean jobFood) {
        this.jobFood = jobFood;
    }

    public boolean isJobCommunal() {
        return jobCommunal;
    }

    public void setJobCommunal(boolean jobCommunal) {
        this.jobCommunal = jobCommunal;
    }

    public String getInfectionPlace() {
        return infectionPlace;
    }

    public void setInfectionPlace(String infectionPlace) {
        this.infectionPlace = infectionPlace;
    }

    public String getInfectionSource() {
        return infectionSource;
    }

    public void setInfectionSource(String infectionSource) {
        this.infectionSource = infectionSource;
    }

    public boolean isInfectionEpidemi() {
        return infectionEpidemi;
    }

    public void setInfectionEpidemi(boolean infectionEpidemi) {
        this.infectionEpidemi = infectionEpidemi;
    }

    public String getInfectionEpidemiSource() {
        return infectionEpidemiSource;
    }

    public void setInfectionEpidemiSource(String infectionEpidemiSource) {
        this.infectionEpidemiSource = infectionEpidemiSource;
    }

    public boolean isAccommodationCommunal() {
        return accommodationCommunal;
    }

    public void setAccommodationCommunal(boolean accommodationCommunal) {
        this.accommodationCommunal = accommodationCommunal;
    }

    public boolean isAccommodationHospital() {
        return accommodationHospital;
    }

    public void setAccommodationHospital(boolean accommodationHospital) {
        this.accommodationHospital = accommodationHospital;
    }

    public Date getAccommodationDateOfHospitalisation() {
        return accommodationDateOfHospitalisation;
    }

    public void setAccommodationDateOfHospitalisation(Date accommodationDateOfHospitalisation) {
        this.accommodationDateOfHospitalisation = accommodationDateOfHospitalisation;
    }

    public boolean isAccommodationIcu() {
        return accommodationIcu;
    }

    public void setAccommodationIcu(boolean accommodationIcu) {
        this.accommodationIcu = accommodationIcu;
    }

    public Date getAccommodationDateOfIcu() {
        return accommodationDateOfIcu;
    }

    public void setAccommodationDateOfIcu(Date accommodationDateOfIcu) {
        this.accommodationDateOfIcu = accommodationDateOfIcu;
    }

    public String getAccommodationNameAndAddress() {
        return accommodationNameAndAddress;
    }

    public void setAccommodationNameAndAddress(String accommodationNameAndAddress) {
        this.accommodationNameAndAddress = accommodationNameAndAddress;
    }

    public String getDetectionOfficeName() {
        return detectionOfficeName;
    }

    public void setDetectionOfficeName(String detectionOfficeName) {
        this.detectionOfficeName = detectionOfficeName;
    }

    public String getDetectionOfficeAddressStreet() {
        return detectionOfficeAddressStreet;
    }

    public void setDetectionOfficeAddressStreet(String detectionOfficeAddressStreet) {
        this.detectionOfficeAddressStreet = detectionOfficeAddressStreet;
    }

    public String getDetectionOfficeAddressHousenumber() {
        return detectionOfficeAddressHousenumber;
    }

    public void setDetectionOfficeAddressHousenumber(String detectionOfficeAddressHousenumber) {
        this.detectionOfficeAddressHousenumber = detectionOfficeAddressHousenumber;
    }

    public long getDetectionOfficeAddressZipcode() {
        return detectionOfficeAddressZipcode;
    }

    public void setDetectionOfficeAddressZipcode(long detectionOfficeAddressZipcode) {
        this.detectionOfficeAddressZipcode = detectionOfficeAddressZipcode;
    }

    public String getDetectionOfficeAddressCity() {
        return detectionOfficeAddressCity;
    }

    public void setDetectionOfficeAddressCity(String detectionOfficeAddressCity) {
        this.detectionOfficeAddressCity = detectionOfficeAddressCity;
    }

    public String getDetectionOfficeAddressCountry() {
        return detectionOfficeAddressCountry;
    }

    public void setDetectionOfficeAddressCountry(String detectionOfficeAddressCountry) {
        this.detectionOfficeAddressCountry = detectionOfficeAddressCountry;
    }

    public String getDetectionOfficePhone() {
        return detectionOfficePhone;
    }

    public void setDetectionOfficePhone(String detectionOfficePhone) {
        this.detectionOfficePhone = detectionOfficePhone;
    }

    public String getDetectionOfficeEmail() {
        return detectionOfficeEmail;
    }

    public void setDetectionOfficeEmail(String detectionOfficeEmail) {
        this.detectionOfficeEmail = detectionOfficeEmail;
    }

    public String getDetectionOfficeUntersuchungsstelle() {
        return detectionOfficeUntersuchungsstelle;
    }

    public void setDetectionOfficeUntersuchungsstelle(String detectionOfficeUntersuchungsstelle) {
        this.detectionOfficeUntersuchungsstelle = detectionOfficeUntersuchungsstelle;
    }

    public String getLaboratoryCommission() {
        return laboratoryCommission;
    }

    public void setLaboratoryCommission(String laboratoryCommission) {
        this.laboratoryCommission = laboratoryCommission;
    }

    public String getLaboratoryName() {
        return laboratoryName;
    }

    public void setLaboratoryName(String laboratoryName) {
        this.laboratoryName = laboratoryName;
    }

    public String getLaboratoryLocation() {
        return laboratoryLocation;
    }

    public void setLaboratoryLocation(String laboratoryLocation) {
        this.laboratoryLocation = laboratoryLocation;
    }

    public String getLaboratoryPhone() {
        return laboratoryPhone;
    }

    public void setLaboratoryPhone(String laboratoryPhone) {
        this.laboratoryPhone = laboratoryPhone;
    }

    public String getLaboratoryDateOfBiopsy() {
        return laboratoryDateOfBiopsy;
    }

    public void setLaboratoryDateOfBiopsy(String laboratoryDateOfBiopsy) {
        this.laboratoryDateOfBiopsy = laboratoryDateOfBiopsy;
    }
}