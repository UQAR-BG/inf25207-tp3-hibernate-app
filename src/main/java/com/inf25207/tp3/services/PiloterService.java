package com.inf25207.tp3.services;

import com.inf25207.tp3.domain.models.Piloter;
import com.inf25207.tp3.repositories.interfaces.IModelRepository;
import com.inf25207.tp3.repositories.interfaces.IUniqueRelationRepository;
import com.inf25207.tp3.services.interfaces.IUniqueRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Bastien Goulet
 * */

@Service(value = "piloterService")
public class PiloterService extends ModelService<Piloter> implements IUniqueRelationService<Piloter> {
    @Autowired
    public PiloterService(IModelRepository<Piloter> piloterRepo) {
        this.repository = piloterRepo;
    }

    @Override
    public Piloter get(int leftId, int rightId) {
        return ((IUniqueRelationRepository<Piloter>)repository).get(leftId, rightId);
    }

    @Override
    public void delete(int leftId, int rightId) {
        ((IUniqueRelationRepository<Piloter>)repository).delete(leftId, rightId);
    }
}
