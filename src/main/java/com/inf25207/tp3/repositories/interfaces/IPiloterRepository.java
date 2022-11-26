package com.inf25207.tp3.repositories.interfaces;

import com.inf25207.tp3.domain.models.Piloter;

import java.util.List;

public interface IPiloterRepository {
    List<Piloter> getPiloters();
    boolean addPiloter(Piloter svion);
    Piloter getPiloter(int id);
    void deletePiloter(int id);
}
