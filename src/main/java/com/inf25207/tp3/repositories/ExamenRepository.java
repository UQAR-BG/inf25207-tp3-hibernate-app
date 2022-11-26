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
        Session session = sessionfactory.openSession();
        List<Examen> Examens = session.createQuery("from Examen", Examen.class).list();

        session.close();
        return Examens;
    }

    @Override
    public boolean addExamen(Examen Examen) {
        try {
            Session session = sessionfactory.openSession();

            session.beginTransaction();
            session.persist(Examen);
            session.getTransaction().commit();

            session.close();
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    @Override
    public Examen getExamen(int id) {
        Session session = sessionfactory.openSession();
        Examen Examen = session.get(Examen.class, id);

        session.close();
        return Examen;
    }

    @Override
    public void deleteExamen(int id) {
        Session session = sessionfactory.openSession();
        session.remove(getExamen(id));

        session.close();
    }
}
