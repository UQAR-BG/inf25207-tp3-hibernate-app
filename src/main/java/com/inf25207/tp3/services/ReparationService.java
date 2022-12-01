package com.inf25207.tp3.services;

import com.inf25207.tp3.domain.models.Reparation;
import com.inf25207.tp3.repositories.interfaces.IModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Bastien Goulet
 * */

@Service(value = "reparationService")
public class ReparationService extends ModelService<Reparation> {
    @Autowired
    public ReparationService(IModelRepository<Reparation> reparationRepo) {
        this.repository = reparationRepo;
    }
}
