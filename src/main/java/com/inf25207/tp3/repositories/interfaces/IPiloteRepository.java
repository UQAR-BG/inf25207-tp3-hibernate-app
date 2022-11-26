package com.inf25207.tp3.repositories.interfaces;

import com.inf25207.tp3.domain.models.Pilote;

import java.util.List;

public interface IPiloteRepository {
    List<Pilote> getPilotes();
    boolean addPilote(Pilote svion);
    Pilote getPilote(int id);
    void deletePilote(int id);
}
