package com.inf25207.tp3.repositories;

import com.inf25207.tp3.domain.models.Avion;
import com.inf25207.tp3.repositories.interfaces.IAvionRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AvionRepository implements IAvionRepository {
    private final SessionFactory sessionfactory;

    @Autowired
    public AvionRepository(SessionFactory sessionfactory) {
        this.sessionfactory = sessionfactory;
    }

    @Override
    public List<Avion> getAvions() {
        Session session = sessionfactory.openSession();
        List<Avion> Avions = session.createQuery("from Avion", Avion.class).list();

        session.close();
        return Avions;
    }

    @Override
    public boolean addAvion(Avion Avion) {
        try {
            Session session = sessionfactory.openSession();

            session.beginTransaction();
            session.persist(Avion);
            session.getTransaction().commit();

            session.close();
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    @Override
    public Avion getAvion(int id) {
        Session session = sessionfactory.openSession();
        Avion Avion = session.get(Avion.class, id);

        session.close();
        return Avion;
    }

    @Override
    public void deleteAvion(int id) {
        Session session = sessionfactory.openSession();
        session.remove(getAvion(id));

        session.close();
    }
}
