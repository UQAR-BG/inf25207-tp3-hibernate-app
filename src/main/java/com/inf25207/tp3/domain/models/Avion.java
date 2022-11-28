package com.inf25207.tp3.domain.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "Avion")
public class Avion {
    @Id
    @GeneratedValue
    private Integer matricule;

    @NotNull(message = "Vous devez associer l'avion à un type")
    @ManyToOne
    @JoinColumn(name = "Type_id", nullable = false)
    private Type type;

    @OneToMany(mappedBy = "avion", cascade = CascadeType.MERGE)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Collection<AvionTest> avionTests = new ArrayList<>();

    @OneToMany(mappedBy = "avion", cascade = CascadeType.MERGE)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Collection<Reparation> reparations = new ArrayList<>();

    @OneToMany(mappedBy = "avion", cascade = CascadeType.MERGE)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Collection<Piloter> experiences = new ArrayList<>();

    public Integer getMatricule() {
        return matricule;
    }

    public void setMatricule(Integer matricule) {
        this.matricule = matricule;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Collection<AvionTest> getAvionTests() {
        return avionTests;
    }

    public void setAvionTests(Collection<AvionTest> avionTests) {
        this.avionTests = avionTests;
    }

    public Collection<Reparation> getReparations() {
        return reparations;
    }

    public void setReparations(Collection<Reparation> reparations) {
        this.reparations = reparations;
    }

    public Collection<Piloter> getExperiences() {
        return experiences;
    }

    public void setExperiences(Collection<Piloter> experiences) {
        this.experiences = experiences;
    }

    @Transient
    public Collection<Pilote> getPilotes() {
        Collection<Pilote> pilotes = new ArrayList<>();
        for (Piloter experience : experiences) {
            if (experience.getPilote() != null && !pilotes.contains(experience.getPilote()))
                pilotes.add(experience.getPilote());
        }
        return pilotes;
    }

    @Transient
    public Collection<Test> getTests() {
        Collection<Test> tests = new ArrayList<>();
        for (AvionTest avionTest : avionTests) {
            if (avionTest.getTest() != null && !tests.contains(avionTest.getTest()))
                tests.add(avionTest.getTest());
        }
        return tests;
    }

    @Transient
    public Collection<Technicien> getTechniciens() {
        Collection<Technicien> techniciens = new ArrayList<>();
        for (Reparation reparation : reparations) {
            if (reparation.getTechnicien() != null && !techniciens.contains(reparation.getTechnicien()))
                techniciens.add(reparation.getTechnicien());
        }
        return techniciens;
    }
}
