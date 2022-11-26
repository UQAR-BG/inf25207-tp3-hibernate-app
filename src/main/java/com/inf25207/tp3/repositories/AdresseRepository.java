package com.inf25207.tp3.repositories;

import com.inf25207.tp3.domain.models.Adresse;
import com.inf25207.tp3.repositories.interfaces.IAdresseRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdresseRepository implements IAdresseRepository {
    private final SessionFactory sessionfactory;

    @Autowired
    public AdresseRepository(SessionFactory sessionfactory) {
        this.sessionfactory = sessionfactory;
    }

    @Override
    public List<Adresse> getAdresses() {
        Session session = sessionfactory.openSession();
        List<Adresse> Adresses = session.createQuery("from Adresse", Adresse.class).list();

        session.close();
        return Adresses;
    }

    @Override
    public boolean addAdresse(Adresse Adresse) {
        try {
            Session session = sessionfactory.openSession();

            session.beginTransaction();
            session.persist(Adresse);
            session.getTransaction().commit();

            session.close();
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    @Override
    public Adresse getAdresse(int id) {
        Session session = sessionfactory.openSession();
        Adresse Adresse = session.get(Adresse.class, id);

        session.close();
        return Adresse;
    }

    @Override
    public void deleteAdresse(int id) {
        Session session = sessionfactory.openSession();
        session.remove(getAdresse(id));

        session.close();
    }
}
