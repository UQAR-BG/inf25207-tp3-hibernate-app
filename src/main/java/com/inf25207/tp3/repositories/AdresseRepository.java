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
        Session session = sessionfactory.getCurrentSession();
        return session.createQuery("from Adresse", Adresse.class).list();
    }

    @Override
    public boolean addAdresse(Adresse adresse) {
        try {
            Session session = sessionfactory.getCurrentSession();

            session.beginTransaction();
            session.persist(adresse);
            session.getTransaction().commit();
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    @Override
    public Adresse getAdresse(int id) {
        Session session = sessionfactory.getCurrentSession();
        return session.get(Adresse.class, id);
    }

    @Override
    public void deleteAdresse(int id) {
        Session session = sessionfactory.getCurrentSession();
        session.remove(getAdresse(id));
    }
}
