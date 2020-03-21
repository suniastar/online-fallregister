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
import java.util.List;

@Data
@EqualsAndHashCode
@Entity
@Table(name = "jobs")
public class Job {

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "medicalField")
    private boolean medicalField;

    @Column(name = "foodField")
    private boolean foodFiled;

    @Column(name = "CommunityField")
    private boolean communityField;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "infected_id")
    private List<Infected> infected;
}
