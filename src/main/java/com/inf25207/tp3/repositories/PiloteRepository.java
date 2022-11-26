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
        Session session = sessionfactory.openSession();
        List<Pilote> Pilotes = session.createQuery("from Pilote", Pilote.class).list();

        session.close();
        return Pilotes;
    }

    @Override
    public boolean addPilote(Pilote Pilote) {
        try {
            Session session = sessionfactory.openSession();

            session.beginTransaction();
            session.persist(Pilote);
            session.getTransaction().commit();

            session.close();
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    @Override
    public Pilote getPilote(int id) {
        Session session = sessionfactory.openSession();
        Pilote Pilote = session.get(Pilote.class, id);

        session.close();
        return Pilote;
    }

    @Override
    public void deletePilote(int id) {
        Session session = sessionfactory.openSession();
        session.remove(getPilote(id));

        session.close();
    }
}
