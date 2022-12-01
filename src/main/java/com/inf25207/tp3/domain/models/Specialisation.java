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
@Table(name = "Specialisation")
public class Specialisation implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @NotNull(message = "Vous devez associer un technicien")
    @ManyToOne(cascade = CascadeType.MERGE)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "Technicien_matricule", nullable = false)
    private Technicien technicien;

    @Id
    @NotNull(message = "Vous devez associer un type")
    @ManyToOne(cascade = CascadeType.MERGE)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "Type_id", nullable = false)
    private Type type;

    public Technicien getTechnicien() {
        return technicien;
    }

    public void setTechnicien(Technicien technicien) {
        this.technicien = technicien;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
