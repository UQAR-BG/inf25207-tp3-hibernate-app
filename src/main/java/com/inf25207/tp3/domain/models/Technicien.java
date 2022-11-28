package com.inf25207.tp3.domain.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "Technicien")
public class Technicien {
    @Id
    @GeneratedValue
    private Integer matricule;

    @NotNull(message = "Vous devez associer le technicien à un employé")
    @OneToOne
    @JoinColumn(name = "Employe_matricule", nullable = false)
    private Employe employe;

    @OneToMany(mappedBy = "technicien", cascade = CascadeType.MERGE)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Collection<Specialisation> specialisations = new ArrayList<>();

    @OneToMany(mappedBy = "technicien", cascade = CascadeType.MERGE)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Collection<Reparation> reparations = new ArrayList<>();

    public Integer getMatricule() {
        return matricule;
    }

    public void setMatricule(Integer matricule) {
        this.matricule = matricule;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public Collection<Specialisation> getSpecialisations() {
        return specialisations;
    }

    public void setSpecialisations(Collection<Specialisation> specialisations) {
        this.specialisations = specialisations;
    }

    public Collection<Reparation> getReparations() {
        return reparations;
    }

    public void setReparations(Collection<Reparation> reparations) {
        this.reparations = reparations;
    }

    @Transient
    @Override
    public String toString() {
        return this.employe.toString();
    }
}
