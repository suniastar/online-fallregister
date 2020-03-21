package de.coronavirus.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Data
@EqualsAndHashCode
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
    @JoinColumn(name = "infected_id")
    private Infected infected;

}
