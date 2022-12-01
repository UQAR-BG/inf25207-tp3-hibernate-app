package com.inf25207.tp3.domain.models;

import com.inf25207.tp3.domain.utils.DateUtils;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

/**
 * @author Bastien Goulet
 * */

@Entity
@Table(name = "AvionTest")
public class AvionTest {
    @Id
    @GeneratedValue
    private Integer id;

    @NotNull(message = "Vous devez associer un avion")
    @ManyToOne(cascade = CascadeType.MERGE)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "Avion_matricule", nullable = false)
    private Avion avion;

    @NotNull(message = "Vous devez associer un test")
    @ManyToOne(cascade = CascadeType.MERGE)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "Test_numero", nullable = false)
    private Test test;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "La date ne peut pas être vide.")
    @Column(columnDefinition = "DATE", nullable = false)
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

    @Transient
    public LocalDate getLocalDate() {
        if (this.date == null)
            return null;

        return DateUtils.getLocalDate(this.date);
    }
}
