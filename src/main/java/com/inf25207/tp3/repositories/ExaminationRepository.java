package com.inf25207.tp3.repositories;

import com.inf25207.tp3.domain.models.Examination;
import com.inf25207.tp3.repositories.interfaces.IExaminationRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ExaminationRepository implements IExaminationRepository {
    private final SessionFactory sessionfactory;

    @Autowired
    public ExaminationRepository(SessionFactory sessionfactory) {
        this.sessionfactory = sessionfactory;
    }

    @Override
    public List<Examination> getExaminations() {
        Session session = sessionfactory.openSession();
        List<Examination> Examinations = session.createQuery("from Examination", Examination.class).list();

        session.close();
        return Examinations;
    }

    @Override
    public boolean addExamination(Examination Examination) {
        try {
            Session session = sessionfactory.openSession();

            session.beginTransaction();
            session.persist(Examination);
            session.getTransaction().commit();

            session.close();
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    @Override
    public Examination getExamination(int id) {
        Session session = sessionfactory.openSession();
        Examination Examination = session.get(Examination.class, id);

        session.close();
        return Examination;
    }

    @Override
    public void deleteExamination(int id) {
        Session session = sessionfactory.openSession();
        session.remove(getExamination(id));

        session.close();
    }
}