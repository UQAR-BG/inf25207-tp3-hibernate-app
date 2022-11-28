package com.inf25207.tp3.domain.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "Examen")
public class Examen {
    @Id
    @GeneratedValue
    @Column(name = "identifiant")
    private Integer idExamen;

    @Size(min = 1, max = 45, message = "Vous devez fournir une description entre 1 et 45 caractères.")
    @NotNull(message = "La description ne peut pas être vide.")
    @Column(length = 45, nullable = false)
    private String description;

    @Column(name = "Examencol", columnDefinition = "TEXT")
    private String examenCol;

    @OneToMany(mappedBy = "examen", cascade = CascadeType.MERGE)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Collection<Examination> examinations = new ArrayList<>();

    public Integer getIdExamen() {
        return idExamen;
    }

    public void setIdExamen(Integer idExamen) {
        this.idExamen = idExamen;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExamenCol() {
        return examenCol;
    }

    public void setExamenCol(String examenCol) {
        this.examenCol = examenCol;
    }

    public Collection<Examination> getExaminations() {
        return examinations;
    }

    public void setExaminations(Collection<Examination> examinations) {
        this.examinations = examinations;
    }
    
    @Transient
    public Collection<Pilote> getPilotes() {
        Collection<Pilote> pilotes = new ArrayList<>();
        for (Examination examination : examinations) {
            if (examination.getPilote() != null && !pilotes.contains(examination.getPilote()))
                pilotes.add(examination.getPilote());
        }
        return pilotes;
    }
}
