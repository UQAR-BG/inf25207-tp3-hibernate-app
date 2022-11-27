package com.inf25207.tp3.domain.models;

import com.inf25207.tp3.domain.utils.CurrencyUtils;
import com.inf25207.tp3.domain.utils.DateUtils;
import com.inf25207.tp3.domain.validators.telephone.Telephone;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "Employe")
public class Employe {
    @Id
    @GeneratedValue
    private Integer matricule;

    @Size(min = 1, max = 45, message = "Vous devez fournir un nom entre 1 et 45 caractères.")
    @NotNull(message = "Le nom ne peut pas être vide.")
    @Column(length = 45, nullable = false)
    private String nom;

    @Size(min = 1, max = 45, message = "Vous devez fournir un prénom entre 1 et 45 caractères.")
    @NotNull(message = "Le prénom ne peut pas être vide.")
    @Column(length = 45, nullable = false)
    private String prenom;

    @ManyToOne
    @JoinColumn(name = "Adresse_id")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Adresse adresse;

    @Telephone
    @Size(min = 10, max = 45, message = "Le numéro de téléphone ne peut pas faire plus de 45 caractères.")
    @Column(name = "tel", length = 45)
    private String telephone;

    @Column(columnDefinition = "DATE")
    private Date dateEngagement;

    @PositiveOrZero(message = "Le salaire ne peut pas être négatif.")
    @Digits(integer = 12, fraction = 2, message = "Le salaire ne peut pas dépasser 12 caractères.")
    @NotNull(message = "Le salaire ne peut pas être vide.")
    @Column(name = "Salaire", columnDefinition = "DECIMAL(12,2)", nullable = false)
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

    @Transient
    public LocalDate getLocalDate() {
        return DateUtils.getLocalDate(this.dateEngagement);
    }

    @Transient
    public String getSalaireFormatted() {
        return CurrencyUtils.getCurrency(this.salaire);
    }
}
