package com.inf25207.tp3.services;

import com.inf25207.tp3.domain.models.Technicien;
import com.inf25207.tp3.repositories.interfaces.IModelRepository;
import com.inf25207.tp3.services.interfaces.ITechnicienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TechnicienService implements ITechnicienService {
    private final IModelRepository<Technicien> TechnicienRepo;

    @Autowired
    public TechnicienService(IModelRepository<Technicien> TechnicienRepo) {
        this.TechnicienRepo = TechnicienRepo;
    }

    @Override
    @Transactional
    public List<Technicien> getTechniciens() {
        return TechnicienRepo.getAll();
    }

    @Override
    @Transactional
    public boolean addTechnicien(Technicien Technicien) {
        return TechnicienRepo.persist(Technicien);
    }

    @Override
    @Transactional
    public Technicien getTechnicien(int id) {
        return TechnicienRepo.get(id);
    }

    @Override
    @Transactional
    public void deleteTechnicien(int id) {
        TechnicienRepo.delete(id);
    }
}
