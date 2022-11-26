package com.inf25207.tp3.repositories;

import com.inf25207.tp3.domain.models.Piloter;
import com.inf25207.tp3.repositories.interfaces.IPiloterRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PiloterRepository implements IPiloterRepository {
    private final SessionFactory sessionfactory;

    @Autowired
    public PiloterRepository(SessionFactory sessionfactory) {
        this.sessionfactory = sessionfactory;
    }

    @Override
    public List<Piloter> getPiloters() {
        Session session = sessionfactory.openSession();
        List<Piloter> Piloters = session.createQuery("from Piloter", Piloter.class).list();

        session.close();
        return Piloters;
    }

    @Override
    public boolean addPiloter(Piloter Piloter) {
        try {
            Session session = sessionfactory.openSession();

            session.beginTransaction();
            session.persist(Piloter);
            session.getTransaction().commit();

            session.close();
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    @Override
    public Piloter getPiloter(int id) {
        Session session = sessionfactory.openSession();
        Piloter Piloter = session.get(Piloter.class, id);

        session.close();
        return Piloter;
    }

    @Override
    public void deletePiloter(int id) {
        Session session = sessionfactory.openSession();
        session.remove(getPiloter(id));

        session.close();
    }
}