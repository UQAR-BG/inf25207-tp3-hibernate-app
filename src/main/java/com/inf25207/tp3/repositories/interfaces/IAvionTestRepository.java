package com.inf25207.tp3.repositories.interfaces;

import com.inf25207.tp3.domain.models.AvionTest;

import java.util.List;

public interface IAvionTestRepository {
    List<AvionTest> getAvionTests();
    boolean addAvionTest(AvionTest svion);
    AvionTest getAvionTest(int id);
    void deleteAvionTest(int id);
}
