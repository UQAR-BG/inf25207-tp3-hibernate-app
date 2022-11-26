package com.inf25207.tp3.repositories;

import com.inf25207.tp3.domain.models.Examen;
import com.inf25207.tp3.repositories.interfaces.IExamenRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ExamenRepository implements IExamenRepository {
    private final SessionFactory sessionfactory;

    @Autowired
    public ExamenRepository(SessionFactory sessionfactory) {
        this.sessionfactory = sessionfactory;
    }

    @Override
    public List<Examen> getExamens() {
        Session session = sessionfactory.getCurrentSession();
        return session.createQuery("from Examen", Examen.class).list();
    }

    @Override
    public boolean addExamen(Examen Examen) {
        try {
            Session session = sessionfactory.getCurrentSession();

            session.beginTransaction();
            session.persist(Examen);
            session.getTransaction().commit();
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    @Override
    public Examen getExamen(int id) {
        Session session = sessionfactory.getCurrentSession();
        return session.get(Examen.class, id);
    }

    @Override
    public void deleteExamen(int id) {
        Session session = sessionfactory.getCurrentSession();
        session.remove(getExamen(id));
    }
}
