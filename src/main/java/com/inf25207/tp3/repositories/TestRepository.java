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
        Session session = sessionfactory.getCurrentSession();
        return session.createQuery("from Test", Test.class).list();
    }

    @Override
    public boolean addTest(Test Test) {
        try {
            Session session = sessionfactory.getCurrentSession();

            session.beginTransaction();
            session.persist(Test);
            session.getTransaction().commit();
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    @Override
    public Test getTest(int id) {
        Session session = sessionfactory.getCurrentSession();
        return session.get(Test.class, id);
    }

    @Override
    public void deleteTest(int id) {
        Session session = sessionfactory.getCurrentSession();
        session.remove(getTest(id));
    }
}
