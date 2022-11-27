package com.inf25207.tp3.services;

import com.inf25207.tp3.domain.models.Piloter;
import com.inf25207.tp3.repositories.interfaces.IModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "piloterService")
public class PiloterService extends ModelService<Piloter> {
    @Autowired
    public PiloterService(IModelRepository<Piloter> piloterRepo) {
        this.repository = piloterRepo;
    }
}
