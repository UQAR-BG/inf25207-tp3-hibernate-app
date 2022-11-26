package com.inf25207.tp3.repositories;

import com.inf25207.tp3.domain.models.Technicien;
import com.inf25207.tp3.repositories.interfaces.ITechnicienRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TechnicienRepository implements ITechnicienRepository {
    private final SessionFactory sessionfactory;

    @Autowired
    public TechnicienRepository(SessionFactory sessionfactory) {
        this.sessionfactory = sessionfactory;
    }

    @Override
    public List<Technicien> getTechniciens() {
        Session session = sessionfactory.getCurrentSession();
        return session.createQuery("from Technicien", Technicien.class).list();
    }

    @Override
    public boolean addTechnicien(Technicien Technicien) {
        try {
            Session session = sessionfactory.getCurrentSession();

            session.beginTransaction();
            session.persist(Technicien);
            session.getTransaction().commit();
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    @Override
    public Technicien getTechnicien(int id) {
        Session session = sessionfactory.getCurrentSession();
        return session.get(Technicien.class, id);
    }

    @Override
    public void deleteTechnicien(int id) {
        Session session = sessionfactory.getCurrentSession();
        session.remove(getTechnicien(id));
    }
}
