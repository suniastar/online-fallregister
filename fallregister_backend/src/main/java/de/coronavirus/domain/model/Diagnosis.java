package de.coronavirus.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Data
@EqualsAndHashCode
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

}
