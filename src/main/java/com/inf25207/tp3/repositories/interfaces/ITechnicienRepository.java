package com.inf25207.tp3.repositories.interfaces;

import com.inf25207.tp3.domain.models.Technicien;

import java.util.List;

public interface ITechnicienRepository {
    List<Technicien> getTechniciens();
    boolean addTechnicien(Technicien svion);
    Technicien getTechnicien(int id);
    void deleteTechnicien(int id);
}
