package com.inf25207.tp3.domain.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.util.Date;

@Entity
@Table(name = "Reparation")
public class Reparation {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "Avion_matricule")
    private Avion avion;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "Technicien_matricule")
    private Technicien technicien;

    @PositiveOrZero(message = "Le coût ne peut pas être négatif.")
    @Digits(integer = 12, fraction = 2, message = "Le coût ne peut pas dépasser 12 caractères.")
    @NotNull(message = "Le coût ne peut pas être vide.")
    @Column(name = "CoutTotal", columnDefinition = "DECIMAL(12,2)", nullable = false)
    private Double coutTotal;

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

    public Double getCoutTotal() {
        return coutTotal;
    }

    public void setCoutTotal(Double coutTotal) {
        this.coutTotal = coutTotal;
    }

    public Technicien getTechnicien() {
        return technicien;
    }

    public void setTechnicien(Technicien technicien) {
        this.technicien = technicien;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }
}
