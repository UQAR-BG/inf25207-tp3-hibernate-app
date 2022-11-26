package com.inf25207.tp3.services.interfaces;

import com.inf25207.tp3.domain.models.Qualification;

import java.util.List;

public interface IQualificationService {
    List<Qualification> getQualifications();
    boolean addQualification(Qualification Qualification);
    Qualification getQualification(int id);
    void deleteQualification(int id);
}
