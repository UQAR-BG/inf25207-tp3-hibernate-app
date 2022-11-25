package com.inf25207.tp3.repositories.interfaces;

import com.inf25207.tp3.domain.models.Adresse;

import java.util.List;

public interface IAdresseRepository {
    List<Adresse> getAdresses();
    boolean addAdresse(Adresse adresse);
    Adresse getAdresse(int id);
    void deleteAdresse(int id);
}
