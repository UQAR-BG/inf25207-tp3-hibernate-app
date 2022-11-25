package com.inf25207.tp3.domain.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Test")
public class Test {
    @Id
    @GeneratedValue
    @Column(length = 6)
    private Integer numero;

    @Column(length = 255)
    private String nom;

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
