package com.inf25207.tp3.repositories.interfaces;

import com.inf25207.tp3.domain.models.Employe;

import java.util.List;

public interface IEmployeRepository {
    List<Employe> getEmployes();
    boolean addEmploye(Employe employe);
    Employe getEmploye(int id);
    void deleteEmploye(int id);
}
