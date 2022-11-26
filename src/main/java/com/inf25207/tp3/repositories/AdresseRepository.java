package com.inf25207.tp3.repositories;

import com.inf25207.tp3.domain.models.Adresse;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "adresseRepo")
public class AdresseRepository extends ModelRepository<Adresse> {
    @Override
    public List<Adresse> getAll() {
        Session session = sessionfactory.openSession();
        List<Adresse> Adresses = session.createQuery("from Adresse", Adresse.class).list();

        session.close();
        return Adresses;
    }

    @Override
    public Adresse get(int id) {
        Session session = sessionfactory.openSession();
        Adresse Adresse = session.get(Adresse.class, id);

        session.close();
        return Adresse;
    }
}
