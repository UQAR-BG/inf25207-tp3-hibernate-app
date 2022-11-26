package com.inf25207.tp3.services.interfaces;

import com.inf25207.tp3.domain.models.Technicien;

import java.util.List;

public interface ITechnicienService {
    List<Technicien> getTechniciens();
    boolean addTechnicien(Technicien Technicien);
    Technicien getTechnicien(int id);
    void deleteTechnicien(int id);
}
