package com.inf25207.tp3.services;

import com.inf25207.tp3.domain.models.Avion;
import com.inf25207.tp3.repositories.interfaces.IModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "avionService")
public class AvionService extends ModelService<Avion> {
    @Autowired
    public AvionService(IModelRepository<Avion> avionRepo) {
        this.repository = avionRepo;
    }
}
