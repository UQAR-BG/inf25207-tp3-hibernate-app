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
@Table(name = "Qualification")
public class Qualification implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @NotNull(message = "Vous devez associer un pilote")
    @ManyToOne(cascade = CascadeType.MERGE)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "Pilote_matricule", nullable = false)
    private Pilote pilote;

    @Id
    @NotNull(message = "Vous devez associer un type")
    @ManyToOne(cascade = CascadeType.MERGE)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "Type_id", nullable = false)
    private Type type;

    public Pilote getPilote() {
        return pilote;
    }

    public void setPilote(Pilote pilote) {
        this.pilote = pilote;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
