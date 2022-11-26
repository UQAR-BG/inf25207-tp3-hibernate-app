package com.inf25207.tp3.domain.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Examen")
public class Examen {
    @Id
    @GeneratedValue
    @Column(name = "identifiant")
    private Integer idExamen;

    @Size(min = 1, max = 45, message = "Vous devez fournir une description entre 1 et 45 caractères.")
    @NotNull(message = "La description ne peut pas être vide.")
    @Column(length = 45, nullable = false)
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
