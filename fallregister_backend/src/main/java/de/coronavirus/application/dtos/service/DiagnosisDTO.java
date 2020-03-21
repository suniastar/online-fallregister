package de.coronavirus.application.dtos.service;

import java.util.Date;

public interface DiagnosisDTO {

    long getId();
    String getDiagnosticResult();
    Date getDate();
    DetectorDTO getDetector();
    LaboratoryDTO getLaboratory();
    boolean getConfirmed();
    InfectedDTO getInfected();
}
