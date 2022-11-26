package com.inf25207.tp3.services;

import com.inf25207.tp3.domain.models.Piloter;
import com.inf25207.tp3.repositories.interfaces.IModelRepository;
import com.inf25207.tp3.services.interfaces.IPiloterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PiloterService implements IPiloterService {
    private final IModelRepository<Piloter> PiloterRepo;

    @Autowired
    public PiloterService(IModelRepository<Piloter> PiloterRepo) {
        this.PiloterRepo = PiloterRepo;
    }

    @Override
    @Transactional
    public List<Piloter> getPiloters() {
        return PiloterRepo.getAll();
    }

    @Override
    @Transactional
    public boolean addPiloter(Piloter Piloter) {
        return PiloterRepo.persist(Piloter);
    }

    @Override
    @Transactional
    public Piloter getPiloter(int id) {
        return PiloterRepo.get(id);
    }

    @Override
    @Transactional
    public void deletePiloter(int id) {
        PiloterRepo.delete(id);
    }
}
