package de.coronavirus.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@EqualsAndHashCode
@Table(name = "email_addresses")
public class EmailAddress {

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "email")
    private String email;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "email_addresses", fetch = FetchType.LAZY)
    @JoinColumn(name = "entities")
    private List<Entity> entities;
}
