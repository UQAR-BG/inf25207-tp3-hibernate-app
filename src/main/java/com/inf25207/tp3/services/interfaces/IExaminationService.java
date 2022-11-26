package com.inf25207.tp3.services.interfaces;

import com.inf25207.tp3.domain.models.Examination;

import java.util.List;

public interface IExaminationService {
    List<Examination> getExaminations();
    boolean addExamination(Examination Examination);
    Examination getExamination(int id);
    void deleteExamination(int id);
}
