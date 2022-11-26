package com.inf25207.tp3.repositories;

import com.inf25207.tp3.domain.models.Qualification;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "qualificationRepo")
public class QualificationRepository extends ModelRepository<Qualification> {
    @Override
    public List<Qualification> getAll() {
        Session session = sessionfactory.openSession();
        List<Qualification> Qualifications = session.createQuery("from Qualification", Qualification.class).list();

        session.close();
        return Qualifications;
    }

    @Override
    public Qualification get(int id) {
        Session session = sessionfactory.openSession();
        Qualification Qualification = session.get(Qualification.class, id);

        session.close();
        return Qualification;
    }
}
