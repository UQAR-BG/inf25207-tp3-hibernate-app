package com.inf25207.tp3.repositories;

import com.inf25207.tp3.domain.models.Test;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "testRepo")
public class TestRepository extends ModelRepository<Test> {
    @Override
    public List<Test> getAll() {
        Session session = sessionfactory.openSession();
        List<Test> Tests = session.createQuery("from Test", Test.class).list();

        session.close();
        return Tests;
    }

    @Override
    public Test get(int id) {
        Session session = sessionfactory.openSession();
        Test Test = session.get(Test.class, id);

        session.close();
        return Test;
    }
}
