package com.inf25207.tp3.services;

import com.inf25207.tp3.domain.models.Specialisation;
import com.inf25207.tp3.repositories.interfaces.ISpecialisationRepository;
import com.inf25207.tp3.services.interfaces.ISpecialisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SpecialisationService implements ISpecialisationService {
    private final ISpecialisationRepository SpecialisationRepo;

    @Autowired
    public SpecialisationService(ISpecialisationRepository SpecialisationRepo) {
        this.SpecialisationRepo = SpecialisationRepo;
    }

    @Override
    @Transactional
    public List<Specialisation> getSpecialisations() {
        return SpecialisationRepo.getSpecialisations();
    }

    @Override
    @Transactional
    public boolean addSpecialisation(Specialisation Specialisation) {
        return SpecialisationRepo.addSpecialisation(Specialisation);
    }

    @Override
    @Transactional
    public Specialisation getSpecialisation(int id) {
        return SpecialisationRepo.getSpecialisation(id);
    }

    @Override
    @Transactional
    public void deleteSpecialisation(int id) {
        SpecialisationRepo.deleteSpecialisation(id);
    }
}
