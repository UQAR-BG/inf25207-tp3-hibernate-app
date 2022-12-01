package com.inf25207.tp3.services;

import com.inf25207.tp3.domain.models.Specialisation;
import com.inf25207.tp3.repositories.interfaces.IModelRepository;
import com.inf25207.tp3.repositories.interfaces.IUniqueRelationRepository;
import com.inf25207.tp3.services.interfaces.IUniqueRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Bastien Goulet
 * */

@Service(value = "specialisationService")
public class SpecialisationService extends ModelService<Specialisation> implements IUniqueRelationService<Specialisation> {
    @Autowired
    public SpecialisationService(IModelRepository<Specialisation> specialisationRepo) {
        this.repository = specialisationRepo;
    }

    @Override
    public Specialisation get(int leftId, int rightId) {
        return ((IUniqueRelationRepository<Specialisation>)repository).get(leftId, rightId);
    }

    @Override
    public void delete(int leftId, int rightId) {
        ((IUniqueRelationRepository<Specialisation>)repository).delete(leftId, rightId);
    }
}
