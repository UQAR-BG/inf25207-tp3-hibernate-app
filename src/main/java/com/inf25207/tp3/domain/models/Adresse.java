package com.inf25207.tp3.domain.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "Adresse")
public class Adresse {
    @Id
    @GeneratedValue
    @Column(length = 6)
    private Integer id;

    @Min(value = 1, message = "Le code civique ne peut pas être vide.")
    @Max(value = 9999, message = "Le code civique doit faire entre 1 et 4 caractères")
    @NotNull(message = "Le code civique ne peut pas être vide.")
    @Column(length = 4, nullable = false)
    private Integer numeroRue;

    @Size(min = 1, max = 255, message = "Vous devez fournir un nom de rue entre 1 et 255 caractères.")
    @NotNull(message = "Le nom de rue ne peut pas être vide.")
    @Column(length = 255, nullable = false)
    private String nomRue;

    @Size(min = 1, max = 255, message = "Vous devez fournir une ville entre 1 et 255 caractères.")
    @NotNull(message = "La ville ne peut pas être vide.")
    @Column(length = 255, nullable = false)
    private String ville;

    @Size(min = 6, max = 45, message = "Vous devez fournir un code postal valide.")
    @NotNull(message = "Le code postal ne peut pas être vide.")
    @Column(length = 45, nullable = false)
    private String codePostal;

    @Size(min = 1, max = 255, message = "Vous devez fournir une province entre 1 et 255 caractères.")
    @NotNull(message = "La province ne peut pas être vide.")
    @Column(length = 255, nullable = false)
    private String province;

    @Size(min = 1, max = 255, message = "Vous devez fournir un pays entre 1 et 255 caractères.")
    @NotNull(message = "Le pays ne peut pas être vide.")
    @Column(length = 255, nullable = false)
    private String pays;

    @OneToMany(mappedBy = "adresse", cascade = CascadeType.MERGE)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Collection<Employe> employes = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumeroRue() {
        return numeroRue;
    }

    public void setNumeroRue(Integer numeroRue) {
        this.numeroRue = numeroRue;
    }

    public String getNomRue() {
        return nomRue;
    }

    public void setNomRue(String nomRue) {
        this.nomRue = nomRue;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public Collection<Employe> getEmployes() {
        return employes;
    }

    public void setEmployes(Collection<Employe> employes) {
        this.employes = employes;
    }
}
