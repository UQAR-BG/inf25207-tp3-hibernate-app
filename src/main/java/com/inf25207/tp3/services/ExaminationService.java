package com.inf25207.tp3.services;

import com.inf25207.tp3.domain.models.Examination;
import com.inf25207.tp3.repositories.interfaces.IModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "examinationService")
public class ExaminationService extends ModelService<Examination> {
    @Autowired
    public ExaminationService(IModelRepository<Examination> examinationRepo) {
        this.repository = examinationRepo;
    }
}
