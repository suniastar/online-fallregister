package de.coronavirus.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@EqualsAndHashCode
@Entity
@Table(name = "phone_numbers")
public class PhoneNumber {

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "number")
    private String number;
}
