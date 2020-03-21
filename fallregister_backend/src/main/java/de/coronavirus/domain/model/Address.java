package de.coronavirus.domain.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

@Table(name = "addresses")
public class Address {

    @Id
    @Column(name = "id")
    private long id;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "address", orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id")
    private Street street;

    @Column(name = "house_number")
    private Integer houseNumber;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "addresses", fetch = FetchType.LAZY)
    @JoinColumn(name = "entities")
    private List<Entity> entities;
}
