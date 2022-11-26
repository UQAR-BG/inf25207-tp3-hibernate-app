package com.inf25207.tp3.repositories.interfaces;

import com.inf25207.tp3.domain.models.Examination;

import java.util.List;

public interface IExaminationRepository {
    List<Examination> getExaminations();
    boolean addExamination(Examination svion);
    Examination getExamination(int id);
    void deleteExamination(int id);
}
