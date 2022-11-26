package com.inf25207.tp3.services;

import com.inf25207.tp3.domain.models.Examen;
import com.inf25207.tp3.repositories.interfaces.IModelRepository;
import com.inf25207.tp3.services.interfaces.IExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ExamenService implements IExamenService {
    private final IModelRepository<Examen> ExamenRepo;

    @Autowired
    public ExamenService(IModelRepository<Examen> ExamenRepo) {
        this.ExamenRepo = ExamenRepo;
    }

    @Override
    @Transactional
    public List<Examen> getExamens() {
        return ExamenRepo.getAll();
    }

    @Override
    @Transactional
    public boolean addExamen(Examen Examen) {
        return ExamenRepo.persist(Examen);
    }

    @Override
    @Transactional
    public Examen getExamen(int id) {
        return ExamenRepo.get(id);
    }

    @Override
    @Transactional
    public void deleteExamen(int id) {
        ExamenRepo.delete(id);
    }
}
