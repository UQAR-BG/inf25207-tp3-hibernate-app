package com.inf25207.tp3.services;

import com.inf25207.tp3.domain.models.Qualification;
import com.inf25207.tp3.repositories.interfaces.IModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "qualificationService")
public class QualificationService extends ModelService<Qualification> {
    @Autowired
    public QualificationService(IModelRepository<Qualification> qualificationRepo) {
        this.repository = qualificationRepo;
    }
}
