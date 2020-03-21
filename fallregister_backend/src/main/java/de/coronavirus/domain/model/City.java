package de.coronavirus.domain.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import java.util.List;

@Table(name = "cities")
public class City {

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cities", orphanRemoval = true, fetch = FetchType.LAZY)
    @OrderBy("code asc")
    private List<Long> postCodes;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cities", orphanRemoval = true, fetch = FetchType.LAZY)
    @OrderBy("name asc")
    private List<Street> streets;
}
