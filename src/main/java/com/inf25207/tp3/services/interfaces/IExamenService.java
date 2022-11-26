package com.inf25207.tp3.services.interfaces;

import com.inf25207.tp3.domain.models.Examen;

import java.util.List;

public interface IExamenService {
    List<Examen> getExamens();
    boolean addExamen(Examen Examen);
    Examen getExamen(int id);
    void deleteExamen(int id);
}
