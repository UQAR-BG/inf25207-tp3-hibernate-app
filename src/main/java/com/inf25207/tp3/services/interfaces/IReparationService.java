package com.inf25207.tp3.services.interfaces;

import com.inf25207.tp3.domain.models.Reparation;

import java.util.List;

public interface IReparationService {
    List<Reparation> getReparations();
    boolean addReparation(Reparation Reparation);
    Reparation getReparation(int id);
    void deleteReparation(int id);
}
