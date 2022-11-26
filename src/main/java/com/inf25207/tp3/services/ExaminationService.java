package com.inf25207.tp3.services;

import com.inf25207.tp3.domain.models.Examination;
import com.inf25207.tp3.repositories.interfaces.IModelRepository;
import com.inf25207.tp3.services.interfaces.IExaminationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ExaminationService implements IExaminationService {
    private final IModelRepository<Examination> ExaminationRepo;

    @Autowired
    public ExaminationService(IModelRepository<Examination> ExaminationRepo) {
        this.ExaminationRepo = ExaminationRepo;
    }

    @Override
    @Transactional
    public List<Examination> getExaminations() {
        return ExaminationRepo.getAll();
    }

    @Override
    @Transactional
    public boolean addExamination(Examination Examination) {
        return ExaminationRepo.persist(Examination);
    }

    @Override
    @Transactional
    public Examination getExamination(int id) {
        return ExaminationRepo.get(id);
    }

    @Override
    @Transactional
    public void deleteExamination(int id) {
        ExaminationRepo.delete(id);
    }
}
