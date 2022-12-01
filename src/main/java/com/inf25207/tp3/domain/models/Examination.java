package com.inf25207.tp3.domain.models;

import com.inf25207.tp3.domain.utils.DateUtils;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

/**
 * @author Bastien Goulet
 * */
@Entity
@Table(name = "Examination")
public class Examination {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer idExamination;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "La date d'examination ne peut pas être vide.")
    @Column(columnDefinition = "DATE", nullable = false)
    private Date date;

    @Size(min = 1, message = "Le rapport ne peut pas être vide.")
    @NotNull(message = "Le rapport ne peut pas être vide.")
    @Column(columnDefinition="TEXT", nullable = false)
    private String rapport;

    @NotNull(message = "Vous devez associer un pilote")
    @ManyToOne(cascade = CascadeType.MERGE)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "Pilote_matricule", nullable = false)
    private Pilote pilote;

    @NotNull(message = "Vous devez associer un examen")
    @ManyToOne(cascade = CascadeType.MERGE)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "Examen_identifiant", nullable = false)
    private Examen examen;

    public Integer getIdExamination() {
        return idExamination;
    }

    public void setIdExamination(Integer idExamination) {
        this.idExamination = idExamination;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getRapport() {
        return rapport;
    }

    public void setRapport(String rapport) {
        this.rapport = rapport;
    }

    public Examen getExamen() {
        return examen;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }

    public Pilote getPilote() {
        return pilote;
    }

    public void setPilote(Pilote pilote) {
        this.pilote = pilote;
    }

    @Transient
    public LocalDate getLocalDate() {
        if (this.date == null)
            return null;

        return DateUtils.getLocalDate(this.date);
    }
}
