package com.inf25207.tp3.services;

import com.inf25207.tp3.domain.models.AvionTest;
import com.inf25207.tp3.repositories.interfaces.IModelRepository;
import com.inf25207.tp3.services.interfaces.IAvionTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AvionTestService implements IAvionTestService {
    private final IModelRepository<AvionTest> avionTestRepo;

    @Autowired
    public AvionTestService(IModelRepository<AvionTest> avionTestRepo) {
        this.avionTestRepo = avionTestRepo;
    }

    @Override
    @Transactional
    public List<AvionTest> getAvionTests() {
        return avionTestRepo.getAll();
    }

    @Override
    @Transactional
    public boolean addAvionTest(AvionTest avionTest) {
        return avionTestRepo.persist(avionTest);
    }

    @Override
    @Transactional
    public AvionTest getAvionTest(int id) {
        return avionTestRepo.get(id);
    }

    @Override
    @Transactional
    public void deleteAvionTest(int id) {
        avionTestRepo.delete(id);
    }
}
