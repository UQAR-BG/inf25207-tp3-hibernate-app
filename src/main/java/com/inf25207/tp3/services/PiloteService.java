package com.inf25207.tp3.services;

import com.inf25207.tp3.domain.models.Pilote;
import com.inf25207.tp3.repositories.interfaces.IModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "piloteService")
public class PiloteService extends ModelService<Pilote> {
    @Autowired
    public PiloteService(IModelRepository<Pilote> piloteRepo) {
        this.repository = piloteRepo;
    }
}
