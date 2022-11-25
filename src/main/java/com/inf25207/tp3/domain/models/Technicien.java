package com.inf25207.tp3.domain.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Technicien")
public class Technicien {
    @Id
    @GeneratedValue
    private Integer matricule;

    @OneToOne
    @JoinColumn(name = "Employe_matricule")
    private Employe employe;

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
}
