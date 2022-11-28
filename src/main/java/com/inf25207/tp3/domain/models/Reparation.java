package com.inf25207.tp3.domain.models;

import com.inf25207.tp3.domain.utils.CurrencyUtils;
import com.inf25207.tp3.domain.utils.DateUtils;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "Reparation")
public class Reparation {
    @Id
    @GeneratedValue
    private Integer id;

    @NotNull(message = "Vous devez associer un avion")
    @ManyToOne(cascade = CascadeType.MERGE)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "Avion_matricule", nullable = false)
    private Avion avion;

    @NotNull(message = "Vous devez associer un technicien")
    @ManyToOne(cascade = CascadeType.MERGE)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "Technicien_matricule", nullable = false)
    private Technicien technicien;

    @PositiveOrZero(message = "Le coût ne peut pas être négatif.")
    @Digits(integer = 12, fraction = 2, message = "Le coût ne peut pas dépasser 12 caractères.")
    @NotNull(message = "Le coût ne peut pas être vide.")
    @Column(name = "CoutTotal", columnDefinition = "DECIMAL(12,2)", nullable = false)
    private Double coutTotal;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "La date d'examination ne peut pas être vide.")
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

    @Transient
    public LocalDate getLocalDate() {
        if (this.date == null)
            return null;

        return DateUtils.getLocalDate(this.date);
    }

    @Transient
    public String getCoutTotalFormatted() {
        return CurrencyUtils.getCurrency(this.coutTotal);
    }
}
