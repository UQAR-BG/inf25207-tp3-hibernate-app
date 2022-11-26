package com.inf25207.tp3.repositories;

import com.inf25207.tp3.domain.models.Qualification;
import com.inf25207.tp3.repositories.interfaces.IQualificationRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QualificationRepository implements IQualificationRepository {
    private final SessionFactory sessionfactory;

    @Autowired
    public QualificationRepository(SessionFactory sessionfactory) {
        this.sessionfactory = sessionfactory;
    }

    @Override
    public List<Qualification> getQualifications() {
        Session session = sessionfactory.getCurrentSession();
        return session.createQuery("from Qualification", Qualification.class).list();
    }

    @Override
    public boolean addQualification(Qualification Qualification) {
        try {
            Session session = sessionfactory.getCurrentSession();

            session.beginTransaction();
            session.persist(Qualification);
            session.getTransaction().commit();
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    @Override
    public Qualification getQualification(int id) {
        Session session = sessionfactory.getCurrentSession();
        return session.get(Qualification.class, id);
    }

    @Override
    public void deleteQualification(int id) {
        Session session = sessionfactory.getCurrentSession();
        session.remove(getQualification(id));
    }
}
