package com.inf25207.tp3.domain.models;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Employe")
public class Employe {
    @Id
    @GeneratedValue
    private Integer matricule;

    @Column(length = 45, nullable = false)
    private String nom;

    @Column(length = 45, nullable = false)
    private String prenom;

    @ManyToOne
    @JoinColumn(name = "Adresse_id")
    private Adresse adresse;

    @Column(name = "tel", length = 45)
    private String telephone;

    @Column(columnDefinition = "DATE")
    private Date dateEngagement;

    @Column(name = "Salaire", columnDefinition = "DECIMAL(12,2)")
    private Double salaire;

    @OneToOne(mappedBy = "employe")
    private Pilote pilote;

    @OneToOne(mappedBy = "employe")
    private Technicien technicien;

    public Integer getMatricule() {
        return matricule;
    }

    public void setMatricule(Integer matricule) {
        this.matricule = matricule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Date getDateEngagement() {
        return dateEngagement;
    }

    public void setDateEngagement(Date dateEngagement) {
        this.dateEngagement = dateEngagement;
    }

    public Double getSalaire() {
        return salaire;
    }

    public void setSalaire(Double salaire) {
        this.salaire = salaire;
    }

    public Pilote getPilote() {
        return pilote;
    }

    public void setPilote(Pilote pilote) {
        this.pilote = pilote;
    }

    public Technicien getTechnicien() {
        return technicien;
    }

    public void setTechnicien(Technicien technicien) {
        this.technicien = technicien;
    }
}
