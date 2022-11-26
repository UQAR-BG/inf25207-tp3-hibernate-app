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

    public List<Avion> getAvions() {
        Session session = sessionfactory.getCurrentSession();
        return session.createQuery("from Avion", Avion.class).list();
    }

    public boolean addAvion(Avion avion) {
        try {
            Session session = sessionfactory.getCurrentSession();

            session.beginTransaction();
            session.persist(avion);
            session.getTransaction().commit();
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    public Avion getAvion(int id) {
        Session session = sessionfactory.getCurrentSession();
        return session.get(Avion.class, id);
    }

    public void deleteAvion(int id) {
        Session session = sessionfactory.getCurrentSession();
        session.remove(getAvion(id));
    }
}
