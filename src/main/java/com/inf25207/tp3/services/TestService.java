package com.inf25207.tp3.services;

import com.inf25207.tp3.domain.models.Test;
import com.inf25207.tp3.repositories.interfaces.ITestRepository;
import com.inf25207.tp3.services.interfaces.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TestService implements ITestService {
    private final ITestRepository TestRepo;

    @Autowired
    public TestService(ITestRepository TestRepo) {
        this.TestRepo = TestRepo;
    }

    @Override
    @Transactional
    public List<Test> getTests() {
        return TestRepo.getTests();
    }

    @Override
    @Transactional
    public boolean addTest(Test Test) {
        return TestRepo.addTest(Test);
    }

    @Override
    @Transactional
    public Test getTest(int id) {
        return TestRepo.getTest(id);
    }

    @Override
    @Transactional
    public void deleteTest(int id) {
        TestRepo.deleteTest(id);
    }
}
