package com.inf25207.tp3.services;

import com.inf25207.tp3.domain.models.Avion;
import com.inf25207.tp3.repositories.interfaces.IModelRepository;
import com.inf25207.tp3.services.interfaces.IAvionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AvionService implements IAvionService {
    private final IModelRepository<Avion> avionRepo;

    @Autowired
    public AvionService(IModelRepository<Avion>  avionRepo) {
        this.avionRepo = avionRepo;
    }

    @Override
    @Transactional
    public List<Avion> getAvions() {
        return avionRepo.getAll();
    }

    @Override
    @Transactional
    public Boolean addAvion(Avion avion) {
        return avionRepo.persist(avion);
    }

    @Override
    @Transactional
    public Avion getAvion(int id) {
        return avionRepo.get(id);
    }

    @Override
    @Transactional
    public void deleteAvion(int id) {
        avionRepo.delete(id);
    }
}
