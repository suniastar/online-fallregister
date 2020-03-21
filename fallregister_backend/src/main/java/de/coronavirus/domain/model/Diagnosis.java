package de.coronavirus.domain.model;

import javax.persistence.*;
import java.util.Date;

@Table(name = "diagnosis")
public class Diagnosis {

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "diagnosticResult")
    private String diagnosticResult;

    @Column(name = "date")
    private Date date;

    @Column(name = "detector")
    private Detector detector;

    @Column(name = "laboratory")
    private Laboratory laboratory;

    @Column(name = "confirmed")
    private boolean confirmed;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Infected infected;

}
