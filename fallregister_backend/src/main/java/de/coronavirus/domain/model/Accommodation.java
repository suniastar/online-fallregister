package de.coronavirus.domain.model;

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
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

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
    private List<PhoneNumber> phoneNumbers;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @OrderBy("email asc")
    private List<EmailAddress> emailAddresses;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @OrderBy("name asc")
    private List<Infected> infected;

    public Accommodation() {
        this.phoneNumbers = new LinkedList<>();
        this.emailAddresses = new LinkedList<>();
        this.infected = new LinkedList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCommunityField() {
        return communityField;
    }

    public void setCommunityField(boolean communityField) {
        this.communityField = communityField;
    }

    public boolean isInCare() {
        return inCare;
    }

    public void setInCare(boolean inCare) {
        this.inCare = inCare;
    }

    public Date getInCareSince() {
        return inCareSince;
    }

    public void setInCareSince(Date inCareSince) {
        this.inCareSince = inCareSince;
    }

    public boolean isInIcu() {
        return inIcu;
    }

    public void setInIcu(boolean inIcu) {
        this.inIcu = inIcu;
    }

    public Date getInIcuSince() {
        return inIcuSince;
    }

    public void setInIcuSince(Date inIcuSince) {
        this.inIcuSince = inIcuSince;
    }

    public List<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<PhoneNumber> phoneNumber) {
        this.phoneNumbers = phoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<EmailAddress> getEmailAddresses() {
        return emailAddresses;
    }

    public void setEmailAddresses(List<EmailAddress> emailAddresses) {
        this.emailAddresses = emailAddresses;
    }

    public List<Infected> getInfected() {
        return infected;
    }

    public void setInfected(List<Infected> infected) {
        this.infected = infected;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Accommodation that = (Accommodation) o;

        if (id != that.id) return false;
        if (communityField != that.communityField) return false;
        if (inCare != that.inCare) return false;
        if (inIcu != that.inIcu) return false;
        if (!Objects.equals(name, that.name)) return false;
        if (!Objects.equals(inCareSince, that.inCareSince)) return false;
        if (!Objects.equals(inIcuSince, that.inIcuSince)) return false;
        if (!Objects.equals(phoneNumbers, that.phoneNumbers)) return false;
        if (!Objects.equals(address, that.address)) return false;
        if (!Objects.equals(emailAddresses, that.emailAddresses)) return false;
        return Objects.equals(infected, that.infected);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (communityField ? 1 : 0);
        result = 31 * result + (inCare ? 1 : 0);
        result = 31 * result + (inCareSince != null ? inCareSince.hashCode() : 0);
        result = 31 * result + (inIcu ? 1 : 0);
        result = 31 * result + (inIcuSince != null ? inIcuSince.hashCode() : 0);
        result = 31 * result + (phoneNumbers != null ? phoneNumbers.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (emailAddresses != null ? emailAddresses.hashCode() : 0);
        result = 31 * result + (infected != null ? infected.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Accommodation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", communityField=" + communityField +
                ", inCare=" + inCare +
                ", inCareSince=" + inCareSince +
                ", inIcu=" + inIcu +
                ", inIcuSince=" + inIcuSince +
                ", phoneNumber=" + phoneNumbers +
                ", address=" + address +
                ", emailAddresses=" + emailAddresses +
                ", infected=" + infected +
                '}';
    }
}
