package com.inf25207.tp3.services;

import com.inf25207.tp3.domain.models.Avion;
import com.inf25207.tp3.repositories.interfaces.IAvionRepository;
import com.inf25207.tp3.services.interfaces.IAvionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AvionService implements IAvionService {
    private final IAvionRepository avionRepo;

    @Autowired
    public AvionService(IAvionRepository avionRepo) {
        this.avionRepo = avionRepo;
    }

    @Override
    @Transactional
    public List<Avion> getAvions() {
        return avionRepo.getAvions();
    }

    @Override
    @Transactional
    public boolean addAvion(Avion avion) {
        return avionRepo.addAvion(avion);
    }

    @Override
    @Transactional
    public Avion getAvion(int id) {
        return avionRepo.getAvion(id);
    }

    @Override
    @Transactional
    public void deleteAvion(int id) {
        avionRepo.deleteAvion(id);
    }
}
