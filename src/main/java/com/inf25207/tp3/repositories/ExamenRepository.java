package com.inf25207.tp3.repositories;

import com.inf25207.tp3.domain.models.Examen;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Bastien Goulet
 * */

@Repository(value = "examenRepo")
public class ExamenRepository extends ModelRepository<Examen> {
    @Override
    public List<Examen> getAll() {
        Session session = sessionfactory.openSession();
        List<Examen> Examens = session.createQuery("from Examen", Examen.class).list();

        session.close();
        return Examens;
    }

    @Override
    public Examen get(int id) {
        Session session = sessionfactory.openSession();
        Examen examen = session.get(Examen.class, id);

        session.close();
        return examen;
    }

    @Override
    public Examen getWithRelations(int id) {
        Session session = sessionfactory.openSession();
        Examen examen = session.get(Examen.class, id);

        // On charge les entités liées
        Hibernate.initialize(examen.getExaminations());

        session.close();
        return examen;
    }
}
