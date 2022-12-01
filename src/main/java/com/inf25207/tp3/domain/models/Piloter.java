package com.inf25207.tp3.domain.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;

/**
 * @author Bastien Goulet
 * */

@Entity
@Table(name = "Piloter")
public class Piloter implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @NotNull(message = "Vous devez associer un avion")
    @ManyToOne(cascade = CascadeType.MERGE)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "Avion_matricule", nullable = false)
    private Avion avion;

    @Id
    @NotNull(message = "Vous devez associer un pilote")
    @ManyToOne(cascade = CascadeType.MERGE)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "Pilote_matricule", nullable = false)
    private Pilote pilote;

    public Pilote getPilote() {
        return pilote;
    }

    public void setPilote(Pilote pilote) {
        this.pilote = pilote;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }
}
