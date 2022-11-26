package com.inf25207.tp3.repositories.interfaces;

import com.inf25207.tp3.domain.models.Test;

import java.util.List;

public interface ITestRepository {
    List<Test> getTests();
    boolean addTest(Test svion);
    Test getTest(int id);
    void deleteTest(int id);
}
