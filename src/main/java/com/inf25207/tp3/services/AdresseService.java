package com.inf25207.tp3.services;

import com.inf25207.tp3.domain.models.Adresse;
import com.inf25207.tp3.repositories.interfaces.IModelRepository;
import com.inf25207.tp3.services.interfaces.IAdresseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdresseService implements IAdresseService {
    private final IModelRepository<Adresse> adresseRepo;

    @Autowired
    public AdresseService(IModelRepository<Adresse> adresseRepo) {
        this.adresseRepo = adresseRepo;
    }

    @Override
    @Transactional
    public List<Adresse> getAdresses() {
        return adresseRepo.getAll();
    }

    @Override
    @Transactional
    public boolean addAdresse(Adresse adresse) {
        return adresseRepo.persist(adresse);
    }

    @Override
    @Transactional
    public Adresse getAdresse(int id) {
        return adresseRepo.get(id);
    }

    @Override
    @Transactional
    public void deleteAdresse(int id) {
        adresseRepo.delete(id);
    }
}
