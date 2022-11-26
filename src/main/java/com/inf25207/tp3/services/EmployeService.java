package com.inf25207.tp3.services;

import com.inf25207.tp3.domain.models.Employe;
import com.inf25207.tp3.repositories.interfaces.IEmployeRepository;
import com.inf25207.tp3.services.interfaces.IEmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeService implements IEmployeService {
    private final IEmployeRepository EmployeRepo;

    @Autowired
    public EmployeService(IEmployeRepository EmployeRepo) {
        this.EmployeRepo = EmployeRepo;
    }

    @Override
    @Transactional
    public List<Employe> getEmployes() {
        return EmployeRepo.getEmployes();
    }

    @Override
    @Transactional
    public boolean addEmploye(Employe Employe) {
        return EmployeRepo.addEmploye(Employe);
    }

    @Override
    @Transactional
    public Employe getEmploye(int id) {
        return EmployeRepo.getEmploye(id);
    }

    @Override
    @Transactional
    public void deleteEmploye(int id) {
        EmployeRepo.deleteEmploye(id);
    }
}
