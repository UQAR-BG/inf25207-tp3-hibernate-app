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
        Session session = sessionfactory.getCurrentSession();
        return session.createQuery("from AvionTest", AvionTest.class).list();
    }

    @Override
    public boolean addAvionTest(AvionTest avionTest) {
        try {
            Session session = sessionfactory.getCurrentSession();

            session.beginTransaction();
            session.persist(avionTest);
            session.getTransaction().commit();
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    @Override
    public AvionTest getAvionTest(int id) {
        Session session = sessionfactory.getCurrentSession();
        return session.get(AvionTest.class, id);
    }

    @Override
    public void deleteAvionTest(int id) {
        Session session = sessionfactory.getCurrentSession();
        session.remove(getAvionTest(id));
    }
}
