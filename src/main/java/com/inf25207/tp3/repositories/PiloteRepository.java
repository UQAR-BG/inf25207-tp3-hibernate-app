package com.inf25207.tp3.repositories;

import com.inf25207.tp3.domain.models.Pilote;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "piloteRepo")
public class PiloteRepository extends ModelRepository<Pilote> {
    @Override
    public List<Pilote> getAll() {
        Session session = sessionfactory.openSession();
        List<Pilote> Pilotes = session.createQuery("from Pilote", Pilote.class).list();

        session.close();
        return Pilotes;
    }

    @Override
    public Pilote get(int id) {
        Session session = sessionfactory.openSession();
        Pilote Pilote = session.get(Pilote.class, id);

        session.close();
        return Pilote;
    }
}
