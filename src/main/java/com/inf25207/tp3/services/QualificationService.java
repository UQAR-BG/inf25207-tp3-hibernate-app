package com.inf25207.tp3.services;

import com.inf25207.tp3.domain.models.Qualification;
import com.inf25207.tp3.repositories.interfaces.IQualificationRepository;
import com.inf25207.tp3.services.interfaces.IQualificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class QualificationService implements IQualificationService {
    private final IQualificationRepository QualificationRepo;

    @Autowired
    public QualificationService(IQualificationRepository QualificationRepo) {
        this.QualificationRepo = QualificationRepo;
    }

    @Override
    @Transactional
    public List<Qualification> getQualifications() {
        return QualificationRepo.getQualifications();
    }

    @Override
    @Transactional
    public boolean addQualification(Qualification Qualification) {
        return QualificationRepo.addQualification(Qualification);
    }

    @Override
    @Transactional
    public Qualification getQualification(int id) {
        return QualificationRepo.getQualification(id);
    }

    @Override
    @Transactional
    public void deleteQualification(int id) {
        QualificationRepo.deleteQualification(id);
    }
}
