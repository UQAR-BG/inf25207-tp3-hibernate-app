package com.inf25207.tp3.services;

import com.inf25207.tp3.domain.models.Specialisation;
import com.inf25207.tp3.repositories.interfaces.IModelRepository;
import com.inf25207.tp3.services.interfaces.ISpecialisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SpecialisationService implements ISpecialisationService {
    private final IModelRepository<Specialisation> SpecialisationRepo;

    @Autowired
    public SpecialisationService(IModelRepository<Specialisation> SpecialisationRepo) {
        this.SpecialisationRepo = SpecialisationRepo;
    }

    @Override
    @Transactional
    public List<Specialisation> getSpecialisations() {
        return SpecialisationRepo.getAll();
    }

    @Override
    @Transactional
    public boolean addSpecialisation(Specialisation Specialisation) {
        return SpecialisationRepo.persist(Specialisation);
    }

    @Override
    @Transactional
    public Specialisation getSpecialisation(int id) {
        return SpecialisationRepo.get(id);
    }

    @Override
    @Transactional
    public void deleteSpecialisation(int id) {
        SpecialisationRepo.delete(id);
    }
}
