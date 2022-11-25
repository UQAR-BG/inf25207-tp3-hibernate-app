package com.inf25207.tp3.domain.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Examen")
public class Examen {
    @Id
    @GeneratedValue
    @Column(name = "identifiant")
    private Integer idExamen;

    @Column(length = 45)
    private String description;

    @Column(name = "Examencol", columnDefinition = "TEXT")
    private String examenCol;

    public Integer getIdExamen() {
        return idExamen;
    }

    public void setIdExamen(Integer idExamen) {
        this.idExamen = idExamen;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExamenCol() {
        return examenCol;
    }

    public void setExamenCol(String examenCol) {
        this.examenCol = examenCol;
    }
}
