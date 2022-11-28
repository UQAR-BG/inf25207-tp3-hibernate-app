package com.inf25207.tp3.repositories;

import com.inf25207.tp3.domain.models.Examen;
import com.inf25207.tp3.domain.models.Technicien;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "technicienRepo")
public class TechnicienRepository extends ModelRepository<Technicien> {
    @Override
    public List<Technicien> getAll() {
        Session session = sessionfactory.openSession();
        List<Technicien> Techniciens = session.createQuery("from Technicien", Technicien.class).list();

        session.close();
        return Techniciens;
    }

    @Override
    public Technicien get(int id) {
        Session session = sessionfactory.openSession();
        Technicien Technicien = session.get(Technicien.class, id);

        session.close();
        return Technicien;
    }

    @Override
    public Technicien getWithRelations(int id) {
        Session session = sessionfactory.openSession();
        Technicien technicien = session.get(Technicien.class, id);

        // On charge les entités liées
        Hibernate.initialize(technicien.getSpecialisations());
        Hibernate.initialize(technicien.getReparations());

        session.close();
        return technicien;
    }
}
