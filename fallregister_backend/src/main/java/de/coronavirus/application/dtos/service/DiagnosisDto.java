package de.coronavirus.application.dtos.service;

import de.coronavirus.domain.model.Detector;
import de.coronavirus.domain.model.Infected;
import de.coronavirus.domain.model.Laboratory;

import java.util.Date;

public interface DiagnosisDto {

    long getId();
    String getDiagnosticResult();
    Date getDate();
    boolean isSuspicion();
    boolean isClinicalDiagnosis();
    boolean isDead();
    Detector getDetector();
    Detector getDetectionOffice();
    Laboratory getLaboratory();
    boolean isConfirmed();
    Infected getInfected();
}
