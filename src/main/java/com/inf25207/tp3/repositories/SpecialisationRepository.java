package com.inf25207.tp3.repositories;

import com.inf25207.tp3.domain.models.Specialisation;
import com.inf25207.tp3.repositories.interfaces.ISpecialisationRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SpecialisationRepository implements ISpecialisationRepository {
    private final SessionFactory sessionfactory;

    @Autowired
    public SpecialisationRepository(SessionFactory sessionfactory) {
        this.sessionfactory = sessionfactory;
    }

    @Override
    public List<Specialisation> getSpecialisations() {
        Session session = sessionfactory.openSession();
        List<Specialisation> Specialisations = session.createQuery("from Specialisation", Specialisation.class).list();

        session.close();
        return Specialisations;
    }

    @Override
    public boolean addSpecialisation(Specialisation Specialisation) {
        try {
            Session session = sessionfactory.openSession();

            session.beginTransaction();
            session.persist(Specialisation);
            session.getTransaction().commit();

            session.close();
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    @Override
    public Specialisation getSpecialisation(int id) {
        Session session = sessionfactory.openSession();
        Specialisation Specialisation = session.get(Specialisation.class, id);

        session.close();
        return Specialisation;
    }

    @Override
    public void deleteSpecialisation(int id) {
        Session session = sessionfactory.openSession();
        session.remove(getSpecialisation(id));

        session.close();
    }
}
