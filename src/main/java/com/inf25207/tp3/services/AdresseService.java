package com.inf25207.tp3.services;

import com.inf25207.tp3.domain.models.Adresse;
import com.inf25207.tp3.repositories.interfaces.IModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "adresseService")
public class AdresseService extends ModelService<Adresse> {
    @Autowired
    public AdresseService(IModelRepository<Adresse> adresseRepo) {
        this.repository = adresseRepo;
    }
}
