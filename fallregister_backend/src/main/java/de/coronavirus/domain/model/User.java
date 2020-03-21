package de.coronavirus.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import java.util.List;

@Data
@EqualsAndHashCode
@Table(name = "users")
public class User {

    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "users", fetch = FetchType.LAZY)
    @OrderBy("valid_until desc")
    private List<Token> tokens;
}
