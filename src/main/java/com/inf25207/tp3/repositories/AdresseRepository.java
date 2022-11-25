package com.inf25207.tp3.repositories;

import com.inf25207.tp3.domain.models.Adresse;
import com.inf25207.tp3.repositories.interfaces.IAdresseRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AdresseRepository implements IAdresseRepository {
    @Autowired
    private SessionFactory sessionfactory;

    @Override
    public List<Adresse> getAdresses() {
        Session session = sessionfactory.openSession();

        List<Adresse> adresses = session.createQuery("from Adresse", Adresse.class).list();

        session.close();
		return adresses;
    }

    @Override
    public boolean addAdresse(Adresse adresse) {
        try {
            Session session = sessionfactory.openSession();

            session.beginTransaction();
            session.persist(adresse);
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
        Adresse adresse = session.get(Adresse.class, id);

        session.close();
        return adresse;
    }

    @Override
    public void deleteAdresse(int id) {
        Session session = sessionfactory.openSession();
        session.remove(getAdresse(id));
        session.close();
    }
}
