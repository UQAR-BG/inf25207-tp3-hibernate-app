package com.inf25207.tp3.services.interfaces;

import com.inf25207.tp3.domain.models.Pilote;

import java.util.List;

public interface IPiloteService {
    List<Pilote> getPilotes();
    boolean addPilote(Pilote Pilote);
    Pilote getPilote(int id);
    void deletePilote(int id);
}
