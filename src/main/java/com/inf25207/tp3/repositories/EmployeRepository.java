package com.inf25207.tp3.repositories;

import com.inf25207.tp3.domain.models.Employe;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Bastien Goulet
 * */

@Repository(value = "employeRepo")
public class EmployeRepository extends ModelRepository<Employe> {
    @Override
    public List<Employe> getAll() {
        Session session = sessionfactory.openSession();
        List<Employe> Employes = session.createQuery("from Employe", Employe.class).list();

        session.close();
        return Employes;
    }

    @Override
    public Employe get(int id) {
        Session session = sessionfactory.openSession();
        Employe employe = session.get(Employe.class, id);

        session.close();
        return employe;
    }

    @Override
    public Employe getWithRelations(int id) {
        Session session = sessionfactory.openSession();
        Employe employe = session.get(Employe.class, id);

        Hibernate.initialize(employe.getAdresse());

        session.close();
        return employe;
    }
}
