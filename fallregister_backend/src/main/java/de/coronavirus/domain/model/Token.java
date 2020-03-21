package de.coronavirus.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Data
@EqualsAndHashCode
@Entity
@Table(name = "tokens")
public class Token {

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "valid_until")
    private Date validUntil;

    @Column(name = "value")
    private String value;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_name")
    private User user;
}
