package com.inf25207.tp3.domain.models;

import jakarta.validation.constraints.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(
    name = "Type",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "nom")
    })
public class Type {
    @Id
    @GeneratedValue
    private Integer id;

    @Size(min = 1, max = 255, message = "Vous devez fournir un nom entre 1 et 255 caractères.")
    @NotNull(message = "Le nom ne peut pas être vide.")
    @Column(length = 255, nullable = false, unique = true)
    private String nom;

    @Min(value = 1, message = "La capacité ne peut pas être vide.")
    @Max(value = 999, message = "La capacité doit faire entre 1 et 3 caractères")
    @NotNull(message = "La capacité ne peut pas être vide.")
    @Column(length = 3, nullable = false)
    private Integer capacite;

    @Positive(message = "Le poids ne peut pas être négatif.")
    @Digits(integer = 10, fraction = 2, message = "Le poids ne peut pas dépasser 10 caractères.")
    @NotNull(message = "Le poids ne peut pas être vide.")
    @Column(columnDefinition = "DECIMAL(10,2)", nullable = false)
    private Double poids;

    @Positive(message = "Le rayon d'action ne peut pas être négatif.")
    @Digits(integer = 10, fraction = 2, message = "Le rayon d'action ne peut pas dépasser 10 caractères.")
    @NotNull(message = "Le rayon d'action ne peut pas être vide.")
    @Column(columnDefinition = "DECIMAL(10,2)", nullable = false)
    private Double rayonAction;

    @OneToMany(mappedBy = "type", cascade = CascadeType.MERGE)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Collection<Avion> avions = new ArrayList<>();

    @OneToMany(mappedBy = "type", cascade = CascadeType.MERGE)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Collection<Qualification> qualifications = new ArrayList<>();

    @OneToMany(mappedBy = "type", cascade = CascadeType.MERGE)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Collection<Specialisation> specialisations = new ArrayList<>();

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

    public Collection<Specialisation> getSpecialisations() {
        return specialisations;
    }

    public void setSpecialisations(Collection<Specialisation> specialisations) {
        this.specialisations = specialisations;
    }

    public Collection<Qualification> getQualifications() {
        return qualifications;
    }

    public void setQualifications(Collection<Qualification> qualifications) {
        this.qualifications = qualifications;
    }

    @Transient
    public Collection<Pilote> getPilotes() {
        Collection<Pilote> pilotes = new ArrayList<>();
        for (Qualification qualification : qualifications) {
            if (qualification.getPilote() != null && !pilotes.contains(qualification.getPilote()))
                pilotes.add(qualification.getPilote());
        }
        return pilotes;
    }

    @Transient
    public Collection<Technicien> getTechniciens() {
        Collection<Technicien> techniciens = new ArrayList<>();
        for (Specialisation specialisation : specialisations) {
            if (specialisation.getTechnicien() != null && !techniciens.contains(specialisation.getTechnicien()))
                techniciens.add(specialisation.getTechnicien());
        }
        return techniciens;
    }

    @Transient
    @Override
    public String toString() {
        return this.nom;
    }
}
