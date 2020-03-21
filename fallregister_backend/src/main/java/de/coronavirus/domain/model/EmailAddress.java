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
@Table(name = "email_addresses")
public class EmailAddress {

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "email")
    private String email;
}
