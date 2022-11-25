package com.inf25207.tp3.domain.models;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Examination")
public class Examination {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer idExamination;

    @Column(columnDefinition = "DATE")
    private Date date;

    @Column(columnDefinition="TEXT")
    private String rapport;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Pilote_matricule")
    private Pilote pilote;

    @ManyToOne(cascade = CascadeType.ALL)
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
