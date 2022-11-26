package com.inf25207.tp3.services.interfaces;

import com.inf25207.tp3.domain.models.AvionTest;

import java.util.List;

public interface IAvionTestService {
    List<AvionTest> getAvionTests();
    boolean addAvionTest(AvionTest avion);
    AvionTest getAvionTest(int id);
    void deleteAvionTest(int id);
}
