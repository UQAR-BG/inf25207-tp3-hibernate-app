package com.inf25207.tp3.domain.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Bastien Goulet
 * */

@Entity
@Table(name = "Test")
public class Test {
    @Id
    @GeneratedValue
    @Column(length = 6)
    private Integer numero;

    @Size(min = 1, max = 255, message = "Vous devez fournir un nom entre 1 et 255 caractères.")
    @NotNull(message = "Le nom ne peut pas être vide.")
    @Column(length = 255, nullable = false)
    private String nom;

    @Positive(message = "La note seuil doit être positive.")
    @Digits(integer = 3, fraction = 2, message = "La note seuil ne peut pas dépasser 3 caractères.")
    @NotNull(message = "La note seuil ne peut pas être vide.")
    @Column(name = "seuil", columnDefinition = "DECIMAL(3,2)", nullable = false)
    private Double seuil;

    @OneToMany(mappedBy = "test", cascade = CascadeType.MERGE)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Collection<AvionTest> avionTests = new ArrayList<>();

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

    public Double getSeuil() {
        return seuil;
    }

    public void setSeuil(Double seuil) {
        this.seuil = seuil;
    }

    public Collection<AvionTest> getAvionTests() {
        return avionTests;
    }

    public void setAvionTests(Collection<AvionTest> avionTests) {
        this.avionTests = avionTests;
    }

    @Transient
    public Collection<Avion> getAvions() {
        Collection<Avion> avions = new ArrayList<>();
        for (AvionTest avionTest : avionTests) {
            if (avionTest.getAvion() != null && !avions.contains(avionTest.getAvion()))
                avions.add(avionTest.getAvion());
        }
        return avions;
    }

    @Transient
    @Override
    public String toString() {
        return this.nom;
    }
}
