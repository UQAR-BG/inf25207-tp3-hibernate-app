package com.inf25207.tp3.repositories;

import com.inf25207.tp3.domain.models.Employe;
import com.inf25207.tp3.repositories.interfaces.IEmployeRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeRepository implements IEmployeRepository {
    private final SessionFactory sessionfactory;

    @Autowired
    public EmployeRepository(SessionFactory sessionfactory) {
        this.sessionfactory = sessionfactory;
    }

    @Override
    public List<Employe> getEmployes() {
        Session session = sessionfactory.getCurrentSession();
        return session.createQuery("from Employe", Employe.class).list();
    }

    @Override
    public boolean addEmploye(Employe Employe) {
        try {
            Session session = sessionfactory.getCurrentSession();

            session.beginTransaction();
            session.persist(Employe);
            session.getTransaction().commit();
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    @Override
    public Employe getEmploye(int id) {
        Session session = sessionfactory.getCurrentSession();
        return session.get(Employe.class, id);
    }

    @Override
    public void deleteEmploye(int id) {
        Session session = sessionfactory.getCurrentSession();
        session.remove(getEmploye(id));
    }
}
