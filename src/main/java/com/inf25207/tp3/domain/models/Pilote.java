package com.inf25207.tp3.domain.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "Pilote", indexes = { @Index(columnList = "matricule") })
public class Pilote {
    @Id
    @GeneratedValue
    private Integer matricule;

    @NotNull(message = "Vous devez associer le pilote à un employé")
    @OneToOne
    @JoinColumn(name = "Employe_matricule", nullable = false)
    private Employe employe;

    @OneToMany(mappedBy = "pilote", cascade = CascadeType.MERGE)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Collection<Examination> examinations = new ArrayList<>();

    @OneToMany(mappedBy = "pilote", cascade = CascadeType.MERGE)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Collection<Qualification> qualifications = new ArrayList<>();

    @OneToMany(mappedBy = "pilote", cascade = CascadeType.MERGE)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Collection<Piloter> experiences = new ArrayList<>();

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

    public Collection<Examination> getExaminations() {
        return examinations;
    }

    public void setExaminations(Collection<Examination> examinations) {
        this.examinations = examinations;
    }

    public Collection<Piloter> getExperiences() {
        return experiences;
    }

    public void setExperiences(Collection<Piloter> experiences) {
        this.experiences = experiences;
    }

    public Collection<Qualification> getQualifications() {
        return qualifications;
    }

    public void setQualifications(Collection<Qualification> qualifications) {
        this.qualifications = qualifications;
    }

    @Transient
    public Collection<Examen> getExamens() {
        Collection<Examen> examens = new ArrayList<>();
        for (Examination examination : examinations) {
            if (examination.getExamen() != null)
                examens.add(examination.getExamen());
        }
        return examens;
    }

    @Transient
    @Override
    public String toString() {
        return this.employe.toString();
    }
}
