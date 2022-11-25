package com.inf25207.tp3.domain.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Specialisation")
public class Specialisation {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Technicien_matricule")
    private Technicien technicien;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Type_id")
    private Type type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
