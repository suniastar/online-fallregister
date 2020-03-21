package de.coronavirus.application.dtos.service;

import de.coronavirus.domain.model.Detector;
import de.coronavirus.domain.model.Infected;
import de.coronavirus.domain.model.Laboratory;

import java.util.Date;

public interface DiagnosisDTO {

    long getId();
    String getDiagnosticResult();
    Date getDate();
    Detector getDetector();
    Laboratory getLaboratory();
    boolean getConfirmed();
    Infected getInfected();
}
