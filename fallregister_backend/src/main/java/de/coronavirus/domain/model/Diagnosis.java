package de.coronavirus.domain.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "diagnoses")
public class Diagnosis {

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;
}
