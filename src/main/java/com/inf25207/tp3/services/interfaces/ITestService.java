package com.inf25207.tp3.services.interfaces;

import com.inf25207.tp3.domain.models.Test;

import java.util.List;

public interface ITestService {
    List<Test> getTests();
    boolean addTest(Test Test);
    Test getTest(int id);
    void deleteTest(int id);
}
