package com.inf25207.tp3.services;

import com.inf25207.tp3.domain.models.Technicien;
import com.inf25207.tp3.repositories.interfaces.IModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Bastien Goulet
 * */

@Service(value = "technicienService")
public class TechnicienService extends ModelService<Technicien> {
    @Autowired
    public TechnicienService(IModelRepository<Technicien> technicienRepo) {
        this.repository = technicienRepo;
    }
}
