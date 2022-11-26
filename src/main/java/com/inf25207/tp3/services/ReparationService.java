package com.inf25207.tp3.services;

import com.inf25207.tp3.domain.models.Reparation;
import com.inf25207.tp3.repositories.interfaces.IModelRepository;
import com.inf25207.tp3.services.interfaces.IReparationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReparationService implements IReparationService {
    private final IModelRepository<Reparation> ReparationRepo;

    @Autowired
    public ReparationService(IModelRepository<Reparation> ReparationRepo) {
        this.ReparationRepo = ReparationRepo;
    }

    @Override
    @Transactional
    public List<Reparation> getReparations() {
        return ReparationRepo.getAll();
    }

    @Override
    @Transactional
    public boolean addReparation(Reparation Reparation) {
        return ReparationRepo.persist(Reparation);
    }

    @Override
    @Transactional
    public Reparation getReparation(int id) {
        return ReparationRepo.get(id);
    }

    @Override
    @Transactional
    public void deleteReparation(int id) {
        ReparationRepo.delete(id);
    }
}
