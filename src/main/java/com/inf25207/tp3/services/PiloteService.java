package com.inf25207.tp3.services;

import com.inf25207.tp3.domain.models.Pilote;
import com.inf25207.tp3.repositories.interfaces.IModelRepository;
import com.inf25207.tp3.services.interfaces.IPiloteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PiloteService implements IPiloteService {
    private final IModelRepository<Pilote> PiloteRepo;

    @Autowired
    public PiloteService(IModelRepository<Pilote> PiloteRepo) {
        this.PiloteRepo = PiloteRepo;
    }

    @Override
    @Transactional
    public List<Pilote> getPilotes() {
        return PiloteRepo.getAll();
    }

    @Override
    @Transactional
    public boolean addPilote(Pilote Pilote) {
        return PiloteRepo.persist(Pilote);
    }

    @Override
    @Transactional
    public Pilote getPilote(int id) {
        return PiloteRepo.get(id);
    }

    @Override
    @Transactional
    public void deletePilote(int id) {
        PiloteRepo.delete(id);
    }
}
