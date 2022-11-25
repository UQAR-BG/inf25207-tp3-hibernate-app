package com.inf25207.tp3.domain.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Avion")
public class Avion {
    @Id
    @GeneratedValue
    private Integer matricule;

    @ManyToOne
    @JoinColumn(name = "Type_id")
    private Type type;

    public Integer getMatricule() {
        return matricule;
    }

    public void setMatricule(Integer matricule) {
        this.matricule = matricule;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
