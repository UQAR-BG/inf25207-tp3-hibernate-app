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
        Session session = sessionfactory.openSession();
        List<Qualification> Qualifications = session.createQuery("from Qualification", Qualification.class).list();

        session.close();
        return Qualifications;
    }

    @Override
    public boolean addQualification(Qualification Qualification) {
        try {
            Session session = sessionfactory.openSession();

            session.beginTransaction();
            session.persist(Qualification);
            session.getTransaction().commit();

            session.close();
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    @Override
    public Qualification getQualification(int id) {
        Session session = sessionfactory.openSession();
        Qualification Qualification = session.get(Qualification.class, id);

        session.close();
        return Qualification;
    }

    @Override
    public void deleteQualification(int id) {
        Session session = sessionfactory.openSession();
        session.remove(getQualification(id));

        session.close();
    }
}
