package com.inf25207.tp3.repositories;

import com.inf25207.tp3.domain.models.Reparation;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "reparationRepo")
public class ReparationRepository extends ModelRepository<Reparation> {
    @Override
    public List<Reparation> getAll() {
        Session session = sessionfactory.openSession();
        List<Reparation> Reparations = session.createQuery("from Reparation", Reparation.class).list();

        session.close();
        return Reparations;
    }

    @Override
    public Reparation get(int id) {
        Session session = sessionfactory.openSession();
        Reparation Reparation = session.get(Reparation.class, id);

        session.close();
        return Reparation;
    }
}
