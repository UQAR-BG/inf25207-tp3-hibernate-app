package com.inf25207.tp3.repositories;

import com.inf25207.tp3.domain.models.Pilote;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Bastien Goulet
 * */

@Repository(value = "piloteRepo")
public class PiloteRepository extends ModelRepository<Pilote> {
    @Override
    public List<Pilote> getAll() {
        Session session = sessionfactory.openSession();
        List<Pilote> pilotes = session.createQuery("from Pilote", Pilote.class).list();

        session.close();
        return pilotes;
    }

    @Override
    public Pilote get(int id) {
        Session session = sessionfactory.openSession();
        Pilote pilote = session.get(Pilote.class, id);

        session.close();
        return pilote;
    }

    @Override
    public Pilote getWithRelations(int id) {
        Session session = sessionfactory.openSession();
        Pilote pilote = session.get(Pilote.class, id);

        Hibernate.initialize(pilote.getExaminations());
        Hibernate.initialize(pilote.getQualifications());
        Hibernate.initialize(pilote.getExperiences());

        session.close();
        return pilote;
    }
}
