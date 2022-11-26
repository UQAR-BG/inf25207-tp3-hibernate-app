package com.inf25207.tp3.repositories;

import com.inf25207.tp3.domain.models.Examination;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "examinationRepo")
public class ExaminationRepository extends ModelRepository<Examination> {
    @Override
    public List<Examination> getAll() {
        Session session = sessionfactory.openSession();
        List<Examination> Examinations = session.createQuery("from Examination", Examination.class).list();

        session.close();
        return Examinations;
    }

    @Override
    public Examination get(int id) {
        Session session = sessionfactory.openSession();
        Examination Examination = session.get(Examination.class, id);

        session.close();
        return Examination;
    }
}
