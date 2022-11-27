package com.inf25207.tp3.services;

import com.inf25207.tp3.domain.models.Employe;
import com.inf25207.tp3.repositories.interfaces.IModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "employeService")
public class EmployeService extends ModelService<Employe> {
    @Autowired
    public EmployeService(IModelRepository<Employe> employeRepo) {
        this.repository = employeRepo;
    }
}
