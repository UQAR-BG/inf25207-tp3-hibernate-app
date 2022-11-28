package com.inf25207.tp3.repositories;

import com.inf25207.tp3.domain.models.Avion;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "avionRepo")
public class AvionRepository extends ModelRepository<Avion> {
    @Override
    public List<Avion> getAll() {
        Session session = sessionfactory.openSession();
        List<Avion> Avions = session.createQuery("from Avion", Avion.class).list();

        session.close();
        return Avions;
    }

    @Override
    public Avion get(int id) {
        Session session = sessionfactory.openSession();
        Avion Avion = session.get(Avion.class, id);

        session.close();
        return Avion;
    }

    @Override
    public Avion getWithRelations(int id) {
        Session session = sessionfactory.openSession();
        Avion avion = session.get(Avion.class, id);

        Hibernate.initialize(avion.getAvionTests());
        Hibernate.initialize(avion.getReparations());
        Hibernate.initialize(avion.getExperiences());

        session.close();
        return avion;
    }
}
