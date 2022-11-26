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
        Session session = sessionfactory.openSession();
        List<Employe> Employes = session.createQuery("from Employe", Employe.class).list();

        session.close();
        return Employes;
    }

    @Override
    public boolean addEmploye(Employe Employe) {
        try {
            Session session = sessionfactory.openSession();

            session.beginTransaction();
            session.persist(Employe);
            session.getTransaction().commit();

            session.close();
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    @Override
    public Employe getEmploye(int id) {
        Session session = sessionfactory.openSession();
        Employe Employe = session.get(Employe.class, id);

        session.close();
        return Employe;
    }

    @Override
    public void deleteEmploye(int id) {
        Session session = sessionfactory.openSession();
        session.remove(getEmploye(id));

        session.close();
    }
}
