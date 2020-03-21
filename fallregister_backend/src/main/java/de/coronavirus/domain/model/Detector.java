package de.coronavirus.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "detectors")
public class Detector extends Entity {

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;
}
