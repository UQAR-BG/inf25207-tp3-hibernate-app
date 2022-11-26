package com.inf25207.tp3.repositories;

import com.inf25207.tp3.domain.models.Piloter;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "piloterRepo")
public class PiloterRepository extends ModelRepository<Piloter> {
    @Override
    public List<Piloter> getAll() {
        Session session = sessionfactory.openSession();
        List<Piloter> Piloters = session.createQuery("from Piloter", Piloter.class).list();

        session.close();
        return Piloters;
    }

    @Override
    public Piloter get(int id) {
        Session session = sessionfactory.openSession();
        Piloter Piloter = session.get(Piloter.class, id);

        session.close();
        return Piloter;
    }
}
