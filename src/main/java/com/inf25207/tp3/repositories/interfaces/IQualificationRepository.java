package com.inf25207.tp3.repositories.interfaces;

import com.inf25207.tp3.domain.models.Qualification;

import java.util.List;

public interface IQualificationRepository {
    List<Qualification> getQualifications();
    boolean addQualification(Qualification svion);
    Qualification getQualification(int id);
    void deleteQualification(int id);
}
