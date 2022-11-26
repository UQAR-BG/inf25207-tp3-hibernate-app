package com.inf25207.tp3.domain.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

@Entity
@Table(name = "Examination")
public class Examination {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer idExamination;

    @NotNull(message = "La date d'examination ne peut pas être vide.")
    @Column(columnDefinition = "DATE", nullable = false)
    private Date date;

    @NotNull(message = "Le rapport ne peut pas être vide.")
    @Column(columnDefinition="TEXT", nullable = false)
    private String rapport;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "Pilote_matricule")
    private Pilote pilote;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "Examen_identifiant")
    private Examen examen;

    public Integer getIdExamination() {
        return idExamination;
    }

    public void setIdExamination(Integer idExamination) {
        this.idExamination = idExamination;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getRapport() {
        return rapport;
    }

    public void setRapport(String rapport) {
        this.rapport = rapport;
    }

    public Examen getExamen() {
        return examen;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }

    public Pilote getPilote() {
        return pilote;
    }

    public void setPilote(Pilote pilote) {
        this.pilote = pilote;
    }
}
