package com.inf25207.tp3.services.interfaces;

import com.inf25207.tp3.domain.models.Employe;

import java.util.List;

public interface IEmployeService {
    List<Employe> getEmployes();
    boolean addEmploye(Employe Employe);
    Employe getEmploye(int id);
    void deleteEmploye(int id);
}
