package com.inf25207.tp3.repositories.interfaces;

import com.inf25207.tp3.domain.models.Reparation;

import java.util.List;

public interface IReparationRepository {
    List<Reparation> getReparations();
    boolean addReparation(Reparation svion);
    Reparation getReparation(int id);
    void deleteReparation(int id);
}
