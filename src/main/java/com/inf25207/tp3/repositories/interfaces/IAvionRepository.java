package com.inf25207.tp3.repositories.interfaces;

import com.inf25207.tp3.domain.models.Avion;

import java.util.List;

public interface IAvionRepository {
    List<Avion> getAvions();
    boolean addAvion(Avion svion);
    Avion getAvion(int id);
    void deleteAvion(int id);
}
