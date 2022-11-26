package com.inf25207.tp3.services;

import com.inf25207.tp3.domain.models.Examination;
import com.inf25207.tp3.repositories.interfaces.IExaminationRepository;
import com.inf25207.tp3.services.interfaces.IExaminationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ExaminationService implements IExaminationService {
    private final IExaminationRepository ExaminationRepo;

    @Autowired
    public ExaminationService(IExaminationRepository ExaminationRepo) {
        this.ExaminationRepo = ExaminationRepo;
    }

    @Override
    @Transactional
    public List<Examination> getExaminations() {
        return ExaminationRepo.getExaminations();
    }

    @Override
    @Transactional
    public boolean addExamination(Examination Examination) {
        return ExaminationRepo.addExamination(Examination);
    }

    @Override
    @Transactional
    public Examination getExamination(int id) {
        return ExaminationRepo.getExamination(id);
    }

    @Override
    @Transactional
    public void deleteExamination(int id) {
        ExaminationRepo.deleteExamination(id);
    }
}
