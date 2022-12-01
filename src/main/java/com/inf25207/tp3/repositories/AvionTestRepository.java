package com.inf25207.tp3.repositories;

import com.inf25207.tp3.domain.models.AvionTest;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Bastien Goulet
 * */

@Repository(value = "avionTestRepo")
public class AvionTestRepository extends ModelRepository<AvionTest> {
    @Override
    public List<AvionTest> getAll() {
        Session session = sessionfactory.openSession();
        List<AvionTest> AvionTests = session.createQuery("from AvionTest", AvionTest.class).list();

        session.close();
        return AvionTests;
    }

    @Override
    public AvionTest get(int id) {
        Session session = sessionfactory.openSession();
        AvionTest AvionTest = session.get(AvionTest.class, id);

        session.close();
        return AvionTest;
    }
}
