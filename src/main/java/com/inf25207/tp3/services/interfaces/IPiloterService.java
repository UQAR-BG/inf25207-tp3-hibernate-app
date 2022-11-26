package com.inf25207.tp3.services.interfaces;

import com.inf25207.tp3.domain.models.Piloter;

import java.util.List;

public interface IPiloterService {
    List<Piloter> getPiloters();
    boolean addPiloter(Piloter Piloter);
    Piloter getPiloter(int id);
    void deletePiloter(int id);
}
