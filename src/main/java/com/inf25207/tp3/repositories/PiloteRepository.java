package com.inf25207.tp3.repositories;

import com.inf25207.tp3.domain.models.Pilote;
import com.inf25207.tp3.repositories.interfaces.IPiloteRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PiloteRepository implements IPiloteRepository {
    private final SessionFactory sessionfactory;

    @Autowired
    public PiloteRepository(SessionFactory sessionfactory) {
        this.sessionfactory = sessionfactory;
    }

    @Override
    public List<Pilote> getPilotes() {
        Session session = sessionfactory.getCurrentSession();
        return session.createQuery("from Pilote", Pilote.class).list();
    }

    @Override
    public boolean addPilote(Pilote Pilote) {
        try {
            Session session = sessionfactory.getCurrentSession();

            session.beginTransaction();
            session.persist(Pilote);
            session.getTransaction().commit();
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    @Override
    public Pilote getPilote(int id) {
        Session session = sessionfactory.getCurrentSession();
        return session.get(Pilote.class, id);
    }

    @Override
    public void deletePilote(int id) {
        Session session = sessionfactory.getCurrentSession();
        session.remove(getPilote(id));
    }
}
