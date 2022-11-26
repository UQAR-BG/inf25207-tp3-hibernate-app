package com.inf25207.tp3.repositories;

import com.inf25207.tp3.domain.models.Specialisation;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "specialisationRepo")
public class SpecialisationRepository extends ModelRepository<Specialisation> {
    @Override
    public List<Specialisation> getAll() {
        Session session = sessionfactory.openSession();
        List<Specialisation> Specialisations = session.createQuery("from Specialisation", Specialisation.class).list();

        session.close();
        return Specialisations;
    }

    @Override
    public Specialisation get(int id) {
        Session session = sessionfactory.openSession();
        Specialisation Specialisation = session.get(Specialisation.class, id);

        session.close();
        return Specialisation;
    }
}
