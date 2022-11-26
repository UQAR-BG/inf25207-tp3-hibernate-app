package com.inf25207.tp3.repositories;

import com.inf25207.tp3.domain.models.AvionTest;
import com.inf25207.tp3.repositories.interfaces.IAvionTestRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AvionTestRepository implements IAvionTestRepository {
    private final SessionFactory sessionfactory;

    @Autowired
    public AvionTestRepository(SessionFactory sessionfactory) {
        this.sessionfactory = sessionfactory;
    }

    @Override
    public List<AvionTest> getAvionTests() {
        Session session = sessionfactory.openSession();
        List<AvionTest> AvionTests = session.createQuery("from AvionTest", AvionTest.class).list();

        session.close();
        return AvionTests;
    }

    @Override
    public boolean addAvionTest(AvionTest AvionTest) {
        try {
            Session session = sessionfactory.openSession();

            session.beginTransaction();
            session.persist(AvionTest);
            session.getTransaction().commit();

            session.close();
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    @Override
    public AvionTest getAvionTest(int id) {
        Session session = sessionfactory.openSession();
        AvionTest AvionTest = session.get(AvionTest.class, id);

        session.close();
        return AvionTest;
    }

    @Override
    public void deleteAvionTest(int id) {
        Session session = sessionfactory.openSession();
        session.remove(getAvionTest(id));

        session.close();
    }
}
