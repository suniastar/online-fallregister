package de.coronavirus.domain.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import java.util.List;

@Table(name = "post_codes")
public class PostCode {

    @Id
    @Column(name = "code")
    private long code;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id")
    private City city;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post_code", orphanRemoval = true, fetch = FetchType.LAZY)
    @OrderBy("name asc")
    private List<Street> streets;
}
