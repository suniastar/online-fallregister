package de.coronavirus.domain.model;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import java.util.List;

public abstract class Entity {

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "phone_numbers")
    private List<PhoneNumber> phoneNumber;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "addresses")
    private Address address;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "email_addresses")
    private EmailAddress emailAddress;
}
