package com.inf25207.tp3.services;

import com.inf25207.tp3.domain.models.Test;
import com.inf25207.tp3.repositories.interfaces.IModelRepository;
import com.inf25207.tp3.services.interfaces.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TestService implements ITestService {
    private final IModelRepository<Test> TestRepo;

    @Autowired
    public TestService(IModelRepository<Test> TestRepo) {
        this.TestRepo = TestRepo;
    }

    @Override
    @Transactional
    public List<Test> getTests() {
        return TestRepo.getAll();
    }

    @Override
    @Transactional
    public boolean addTest(Test Test) {
        return TestRepo.persist(Test);
    }

    @Override
    @Transactional
    public Test getTest(int id) {
        return TestRepo.get(id);
    }

    @Override
    @Transactional
    public void deleteTest(int id) {
        TestRepo.delete(id);
    }
}
