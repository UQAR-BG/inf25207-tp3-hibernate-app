package com.inf25207.tp3.services;

import com.inf25207.tp3.domain.models.Specialisation;
import com.inf25207.tp3.repositories.interfaces.IModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "specialisationService")
public class SpecialisationService extends ModelService<Specialisation> {
    @Autowired
    public SpecialisationService(IModelRepository<Specialisation> specialisationRepo) {
        this.repository = specialisationRepo;
    }
}
