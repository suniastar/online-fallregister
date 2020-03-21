package de.coronavirus.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "laboratories")
public class Laboratory extends Entity {

    @Column(name = "name")
    public String name;
    @Id
    @Column(name = "id")
    private long id;
}
