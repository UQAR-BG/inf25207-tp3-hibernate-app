package com.inf25207.tp3.domain.models;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "Type")
public class Type {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(length = 255, unique = true)
    private String nom;

    @Column(length = 3)
    private Integer capacite;

    @Column(columnDefinition = "DECIMAL(6,2)")
    private Double poids;

    @Column(columnDefinition = "DECIMAL(6,2)")
    private Double rayonAction;

    @OneToMany(mappedBy = "type", cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Collection<Avion> avions = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getCapacite() {
        return capacite;
    }

    public void setCapacite(Integer capacite) {
        this.capacite = capacite;
    }

    public Double getPoids() {
        return poids;
    }

    public void setPoids(Double poids) {
        this.poids = poids;
    }

    public Double getRayonAction() {
        return rayonAction;
    }

    public void setRayonAction(Double rayonAction) {
        this.rayonAction = rayonAction;
    }

    public Collection<Avion> getAvions() {
        return avions;
    }

    public void setAvions(Collection<Avion> avions) {
        this.avions = avions;
    }
}
