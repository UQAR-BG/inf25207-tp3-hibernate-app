package com.inf25207.tp3.services;

import com.inf25207.tp3.domain.models.Employe;
import com.inf25207.tp3.repositories.interfaces.IModelRepository;
import com.inf25207.tp3.services.interfaces.IEmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeService implements IEmployeService {
    private final IModelRepository<Employe> EmployeRepo;

    @Autowired
    public EmployeService(IModelRepository<Employe> EmployeRepo) {
        this.EmployeRepo = EmployeRepo;
    }

    @Override
    @Transactional
    public List<Employe> getEmployes() {
        return EmployeRepo.getAll();
    }

    @Override
    @Transactional
    public boolean addEmploye(Employe Employe) {
        return EmployeRepo.persist(Employe);
    }

    @Override
    @Transactional
    public Employe getEmploye(int id) {
        return EmployeRepo.get(id);
    }

    @Override
    @Transactional
    public void deleteEmploye(int id) {
        EmployeRepo.delete(id);
    }
}
