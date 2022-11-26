package com.inf25207.tp3.services.interfaces;

import com.inf25207.tp3.domain.models.Avion;

import java.util.List;

public interface IAvionService {
    List<Avion> getAvions();
    boolean addAvion(Avion avion);
    Avion getAvion(int id);
    void deleteAvion(int id);
}
