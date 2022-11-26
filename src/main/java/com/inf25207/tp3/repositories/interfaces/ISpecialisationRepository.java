package com.inf25207.tp3.repositories.interfaces;

import com.inf25207.tp3.domain.models.Specialisation;

import java.util.List;

public interface ISpecialisationRepository {
    List<Specialisation> getSpecialisations();
    boolean addSpecialisation(Specialisation svion);
    Specialisation getSpecialisation(int id);
    void deleteSpecialisation(int id);
}
