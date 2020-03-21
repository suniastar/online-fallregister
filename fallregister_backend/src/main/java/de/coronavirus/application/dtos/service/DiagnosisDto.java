package de.coronavirus.application.dtos.service;

import java.util.Date;

public interface DiagnosisDto {

    long getId();
    String getDiagnosticResult();
    Date getDate();
    DetectorDto getDetector();
    LaboratoryDto getLaboratory();
    boolean getConfirmed();
    InfectedDto getInfected();
}
