package de.coronavirus.domain.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "diagnoses")
public class Diagnosis {

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "diagnosticResult")
    private String diagnosticResult;

    @Column(name = "date")
    private Date date;

    @Column(name = "suspicion")
    private boolean suspicion;

    @Column(name = "clinical_diagnosis")
    private boolean clinicalDiagnosis;

    @Column(name = "death")
    private boolean death;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "detector_id")
    private Detector detector;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "detectionOffice_id")
    private Detector detectionOffice;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "laboratory_id")
    private Laboratory laboratory;

    @Column(name = "confirmed")
    private boolean confirmed;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "infected_id")
    private Infected infected;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDiagnosticResult() {
        return diagnosticResult;
    }

    public void setDiagnosticResult(String diagnosticResult) {
        this.diagnosticResult = diagnosticResult;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isSuspicion() {
        return suspicion;
    }

    public void setSuspicion(boolean suspicion) {
        this.suspicion = suspicion;
    }

    public boolean isClinicalDiagnosis() {
        return clinicalDiagnosis;
    }

    public void setClinicalDiagnosis(boolean clinicalDiagnosis) {
        this.clinicalDiagnosis = clinicalDiagnosis;
    }

    public boolean isDeath() {
        return death;
    }

    public void setDeath(boolean death) {
        this.death = death;
    }

    public Detector getDetector() {
        return detector;
    }

    public void setDetector(Detector detector) {
        this.detector = detector;
    }

    public Detector getDetectionOffice() {
        return detectionOffice;
    }

    public void setDetectionOffice(Detector detectionOffice) {
        this.detectionOffice = detectionOffice;
    }

    public Laboratory getLaboratory() {
        return laboratory;
    }

    public void setLaboratory(Laboratory laboratory) {
        this.laboratory = laboratory;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public Infected getInfected() {
        return infected;
    }

    public void setInfected(Infected infected) {
        this.infected = infected;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Diagnosis diagnosis = (Diagnosis) o;

        if (id != diagnosis.id) return false;
        if (suspicion != diagnosis.suspicion) return false;
        if (clinicalDiagnosis != diagnosis.clinicalDiagnosis) return false;
        if (death != diagnosis.death) return false;
        if (confirmed != diagnosis.confirmed) return false;
        if (!Objects.equals(diagnosticResult, diagnosis.diagnosticResult)) return false;
        if (!Objects.equals(date, diagnosis.date)) return false;
        if (!Objects.equals(detector, diagnosis.detector)) return false;
        if (!Objects.equals(detectionOffice, diagnosis.detectionOffice)) return false;
        if (!Objects.equals(laboratory, diagnosis.laboratory)) return false;
        return Objects.equals(infected, diagnosis.infected);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (diagnosticResult != null ? diagnosticResult.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (suspicion ? 1 : 0);
        result = 31 * result + (clinicalDiagnosis ? 1 : 0);
        result = 31 * result + (death ? 1 : 0);
        result = 31 * result + (detector != null ? detector.hashCode() : 0);
        result = 31 * result + (detectionOffice != null ? detectionOffice.hashCode() : 0);
        result = 31 * result + (laboratory != null ? laboratory.hashCode() : 0);
        result = 31 * result + (confirmed ? 1 : 0);
        result = 31 * result + (infected != null ? infected.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Diagnosis{" +
                "id=" + id +
                ", diagnosticResult='" + diagnosticResult + '\'' +
                ", date=" + date +
                ", suspicion=" + suspicion +
                ", clinicalDiagnosis=" + clinicalDiagnosis +
                ", death=" + death +
                ", detector=" + detector +
                ", detectionOffice=" + detectionOffice +
                ", laboratory=" + laboratory +
                ", confirmed=" + confirmed +
                ", infected=" + infected +
                '}';
    }
}
