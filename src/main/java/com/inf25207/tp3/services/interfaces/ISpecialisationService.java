package com.inf25207.tp3.services.interfaces;

import com.inf25207.tp3.domain.models.Specialisation;

import java.util.List;

public interface ISpecialisationService {
    List<Specialisation> getSpecialisations();
    boolean addSpecialisation(Specialisation Specialisation);
    Specialisation getSpecialisation(int id);
    void deleteSpecialisation(int id);
}
