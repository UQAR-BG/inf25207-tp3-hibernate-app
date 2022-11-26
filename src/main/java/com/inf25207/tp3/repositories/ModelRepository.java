package com.inf25207.tp3.repositories;

import com.inf25207.tp3.repositories.interfaces.IModelRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public abstract class ModelRepository<T> implements IModelRepository<T> {
    @Autowired
    protected SessionFactory sessionfactory;

    @Override
    public boolean persist(T model) {
        Session session = sessionfactory.openSession();

        session.beginTransaction();
        session.persist(model);
        session.getTransaction().commit();

        session.close();
        return true;
    }

    @Override
    public void delete(int id) {
        Session session = sessionfactory.openSession();

        session.beginTransaction();
        session.remove(get(id));
        session.flush();
        session.getTransaction().commit();

        session.close();
    }
}
