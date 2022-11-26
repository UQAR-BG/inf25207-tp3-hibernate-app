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
        Session session = sessionfactory.openSession();
        List<Reparation> Reparations = session.createQuery("from Reparation", Reparation.class).list();

        session.close();
        return Reparations;
    }

    @Override
    public boolean addReparation(Reparation Reparation) {
        try {
            Session session = sessionfactory.openSession();

            session.beginTransaction();
            session.persist(Reparation);
            session.getTransaction().commit();

            session.close();
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    @Override
    public Reparation getReparation(int id) {
        Session session = sessionfactory.openSession();
        Reparation Reparation = session.get(Reparation.class, id);

        session.close();
        return Reparation;
    }

    @Override
    public void deleteReparation(int id) {
        Session session = sessionfactory.openSession();
        session.remove(getReparation(id));

        session.close();
    }
}
