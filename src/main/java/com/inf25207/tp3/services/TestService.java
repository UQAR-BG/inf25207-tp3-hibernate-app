package com.inf25207.tp3.services;

import com.inf25207.tp3.domain.models.Test;
import com.inf25207.tp3.repositories.interfaces.IModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "testService")
public class TestService extends ModelService<Test> {
    @Autowired
    public TestService(IModelRepository<Test> testRepo) {
        this.repository = testRepo;
    }
}
