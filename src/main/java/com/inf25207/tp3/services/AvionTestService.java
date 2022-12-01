package com.inf25207.tp3.services;

import com.inf25207.tp3.domain.models.AvionTest;
import com.inf25207.tp3.repositories.interfaces.IModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Bastien Goulet
 * */

@Service(value = "avionTestService")
public class AvionTestService extends ModelService<AvionTest> {
    @Autowired
    public AvionTestService(IModelRepository<AvionTest> avionTestRepo) {
        this.repository = avionTestRepo;
    }
}
