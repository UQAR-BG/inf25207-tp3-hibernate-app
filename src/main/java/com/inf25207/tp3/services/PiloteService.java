package com.inf25207.tp3.services;

import com.inf25207.tp3.domain.models.Pilote;
import com.inf25207.tp3.repositories.interfaces.IPiloteRepository;
import com.inf25207.tp3.services.interfaces.IPiloteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PiloteService implements IPiloteService {
    private final IPiloteRepository PiloteRepo;

    @Autowired
    public PiloteService(IPiloteRepository PiloteRepo) {
        this.PiloteRepo = PiloteRepo;
    }

    @Override
    @Transactional
    public List<Pilote> getPilotes() {
        return PiloteRepo.getPilotes();
    }

    @Override
    @Transactional
    public boolean addPilote(Pilote Pilote) {
        return PiloteRepo.addPilote(Pilote);
    }

    @Override
    @Transactional
    public Pilote getPilote(int id) {
        return PiloteRepo.getPilote(id);
    }

    @Override
    @Transactional
    public void deletePilote(int id) {
        PiloteRepo.deletePilote(id);
    }
}
