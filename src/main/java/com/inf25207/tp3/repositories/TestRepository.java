package com.inf25207.tp3.repositories;

import com.inf25207.tp3.domain.models.Test;
import com.inf25207.tp3.repositories.interfaces.ITestRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TestRepository implements ITestRepository {
    private final SessionFactory sessionfactory;

    @Autowired
    public TestRepository(SessionFactory sessionfactory) {
        this.sessionfactory = sessionfactory;
    }

    @Override
    public List<Test> getTests() {
        Session session = sessionfactory.openSession();
        List<Test> Tests = session.createQuery("from Test", Test.class).list();

        session.close();
        return Tests;
    }

    @Override
    public boolean addTest(Test Test) {
        try {
            Session session = sessionfactory.openSession();

            session.beginTransaction();
            session.persist(Test);
            session.getTransaction().commit();

            session.close();
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    @Override
    public Test getTest(int id) {
        Session session = sessionfactory.openSession();
        Test Test = session.get(Test.class, id);

        session.close();
        return Test;
    }

    @Override
    public void deleteTest(int id) {
        Session session = sessionfactory.openSession();
        session.remove(getTest(id));

        session.close();
    }
}
