package com.inf25207.tp3.domain.models;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "AvionTest")
public class AvionTest {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Avion_matricule")
    private Avion avion;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Test_numero")
    private Test test;

    @Column(columnDefinition = "DATE")
    private Date date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }
}
