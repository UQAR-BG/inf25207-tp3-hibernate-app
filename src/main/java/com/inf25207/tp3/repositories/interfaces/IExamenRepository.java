package com.inf25207.tp3.repositories.interfaces;

import com.inf25207.tp3.domain.models.Examen;

import java.util.List;

public interface IExamenRepository {
    List<Examen> getExamens();
    boolean addExamen(Examen svion);
    Examen getExamen(int id);
    void deleteExamen(int id);
}
