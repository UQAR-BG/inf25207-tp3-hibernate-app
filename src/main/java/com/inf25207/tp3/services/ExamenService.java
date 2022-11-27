package com.inf25207.tp3.services;

import com.inf25207.tp3.domain.models.Examen;
import com.inf25207.tp3.repositories.interfaces.IModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "examenService")
public class ExamenService extends ModelService<Examen> {
    @Autowired
    public ExamenService(IModelRepository<Examen> examenRepo) {
        this.repository = examenRepo;
    }
}
