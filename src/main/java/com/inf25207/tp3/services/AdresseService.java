package com.inf25207.tp3.services;

import com.inf25207.tp3.domain.models.Adresse;
import com.inf25207.tp3.repositories.interfaces.IAdresseRepository;
import com.inf25207.tp3.services.interfaces.IAdresseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdresseService implements IAdresseService {
    private final IAdresseRepository adresseRepo;

    @Autowired
    public AdresseService(IAdresseRepository adresseRepo) {
        this.adresseRepo = adresseRepo;
    }

    @Override
    @Transactional
    public List<Adresse> getAdresses() {
        return adresseRepo.getAdresses();
    }

    @Override
    @Transactional
    public boolean addAdresse(Adresse adresse) {
        return adresseRepo.addAdresse(adresse);
    }

    @Override
    @Transactional
    public Adresse getAdresse(int id) {
        return adresseRepo.getAdresse(id);
    }

    @Override
    @Transactional
    public void deleteAdresse(int id) {
        adresseRepo.deleteAdresse(id);
    }
}
