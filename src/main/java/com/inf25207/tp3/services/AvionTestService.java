package com.inf25207.tp3.services;

import com.inf25207.tp3.domain.models.AvionTest;
import com.inf25207.tp3.repositories.interfaces.IAvionTestRepository;
import com.inf25207.tp3.services.interfaces.IAvionTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AvionTestService implements IAvionTestService {
    private final IAvionTestRepository avionTestRepo;

    @Autowired
    public AvionTestService(IAvionTestRepository avionTestRepo) {
        this.avionTestRepo = avionTestRepo;
    }

    @Override
    @Transactional
    public List<AvionTest> getAvionTests() {
        return avionTestRepo.getAvionTests();
    }

    @Override
    @Transactional
    public boolean addAvionTest(AvionTest avionTest) {
        return avionTestRepo.addAvionTest(avionTest);
    }

    @Override
    @Transactional
    public AvionTest getAvionTest(int id) {
        return avionTestRepo.getAvionTest(id);
    }

    @Override
    @Transactional
    public void deleteAvionTest(int id) {
        avionTestRepo.deleteAvionTest(id);
    }
}
