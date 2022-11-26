package com.inf25207.tp3.services;

import com.inf25207.tp3.domain.models.Examen;
import com.inf25207.tp3.repositories.interfaces.IExamenRepository;
import com.inf25207.tp3.services.interfaces.IExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ExamenService implements IExamenService {
    private final IExamenRepository ExamenRepo;

    @Autowired
    public ExamenService(IExamenRepository ExamenRepo) {
        this.ExamenRepo = ExamenRepo;
    }

    @Override
    @Transactional
    public List<Examen> getExamens() {
        return ExamenRepo.getExamens();
    }

    @Override
    @Transactional
    public boolean addExamen(Examen Examen) {
        return ExamenRepo.addExamen(Examen);
    }

    @Override
    @Transactional
    public Examen getExamen(int id) {
        return ExamenRepo.getExamen(id);
    }

    @Override
    @Transactional
    public void deleteExamen(int id) {
        ExamenRepo.deleteExamen(id);
    }
}
