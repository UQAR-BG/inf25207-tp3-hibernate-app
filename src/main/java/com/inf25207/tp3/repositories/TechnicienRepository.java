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
        Session session = sessionfactory.openSession();
        List<Technicien> Techniciens = session.createQuery("from Technicien", Technicien.class).list();

        session.close();
        return Techniciens;
    }

    @Override
    public boolean addTechnicien(Technicien Technicien) {
        try {
            Session session = sessionfactory.openSession();

            session.beginTransaction();
            session.persist(Technicien);
            session.getTransaction().commit();

            session.close();
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    @Override
    public Technicien getTechnicien(int id) {
        Session session = sessionfactory.openSession();
        Technicien Technicien = session.get(Technicien.class, id);

        session.close();
        return Technicien;
    }

    @Override
    public void deleteTechnicien(int id) {
        Session session = sessionfactory.openSession();
        session.remove(getTechnicien(id));

        session.close();
    }
}
