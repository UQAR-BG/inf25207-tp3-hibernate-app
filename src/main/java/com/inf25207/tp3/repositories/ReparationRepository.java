package com.inf25207.tp3.repositories;

import com.inf25207.tp3.domain.models.Reparation;
import com.inf25207.tp3.repositories.interfaces.IReparationRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReparationRepository implements IReparationRepository {
    private final SessionFactory sessionfactory;

    @Autowired
    public ReparationRepository(SessionFactory sessionfactory) {
        this.sessionfactory = sessionfactory;
    }

    @Override
    public List<Reparation> getReparations() {
        Session session = sessionfactory.getCurrentSession();
        return session.createQuery("from Reparation", Reparation.class).list();
    }

    @Override
    public boolean addReparation(Reparation Reparation) {
        try {
            Session session = sessionfactory.getCurrentSession();

            session.beginTransaction();
            session.persist(Reparation);
            session.getTransaction().commit();
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    @Override
    public Reparation getReparation(int id) {
        Session session = sessionfactory.getCurrentSession();
        return session.get(Reparation.class, id);
    }

    @Override
    public void deleteReparation(int id) {
        Session session = sessionfactory.getCurrentSession();
        session.remove(getReparation(id));
    }
}
