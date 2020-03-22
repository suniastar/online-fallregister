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
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Table(name = "post_codes")
@javax.persistence.Entity
public class PostCode {

    @Id
    @Column(name = "code")
    private long code;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id")
    private City city;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @OrderBy("name asc")
    private List<Street> streets;

    public PostCode() {
        this.streets = new LinkedList<>();
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<Street> getStreets() {
        return streets;
    }

    public void setStreets(List<Street> streets) {
        this.streets = streets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PostCode postCode = (PostCode) o;

        if (code != postCode.code) return false;
        if (!Objects.equals(city, postCode.city)) return false;
        return Objects.equals(streets, postCode.streets);
    }

    @Override
    public int hashCode() {
        int result = (int) (code ^ (code >>> 32));
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (streets != null ? streets.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PostCode{" +
                "code=" + code +
                ", city=" + city +
                ", streets=" + streets +
                '}';
    }
}
