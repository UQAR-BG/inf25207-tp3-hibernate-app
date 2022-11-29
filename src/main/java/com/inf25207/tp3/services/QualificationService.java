package com.inf25207.tp3.services;

import com.inf25207.tp3.domain.models.Qualification;
import com.inf25207.tp3.repositories.interfaces.IModelRepository;
import com.inf25207.tp3.repositories.interfaces.IUniqueRelationRepository;
import com.inf25207.tp3.services.interfaces.IUniqueRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "qualificationService")
public class QualificationService extends ModelService<Qualification> implements IUniqueRelationService<Qualification> {
    @Autowired
    public QualificationService(IModelRepository<Qualification> qualificationRepo) {
        this.repository = qualificationRepo;
    }

    @Override
    public Qualification get(int leftId, int rightId) {
        return ((IUniqueRelationRepository<Qualification>)repository).get(leftId, rightId);
    }

    @Override
    public void delete(int leftId, int rightId) {
        ((IUniqueRelationRepository<Qualification>)repository).delete(leftId, rightId);
    }
}
