package de.coronavirus.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Data
@EqualsAndHashCode
@Entity
@Table(name = "accommodations")
public class Accommodation {

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "community_field")
    private boolean communityField;

    @Column(name = "in_care")
    private boolean inCare;

    @Column(name = "in_care_since")
    private Date inCareSince;

    @Column(name = "in_icu")
    private boolean inIcu;

    @Column(name = "in_icu_since")
    private Date inIcuSince;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "phone_numbers")
    private List<PhoneNumber> phoneNumber;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @OrderBy("email asc")
    private List<EmailAddress> emailAddresses;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @OrderBy("name asc")
    private List<Infected> infected;
}
