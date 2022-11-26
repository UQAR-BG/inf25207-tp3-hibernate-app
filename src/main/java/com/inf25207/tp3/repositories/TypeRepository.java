package com.inf25207.tp3.repositories;

import com.inf25207.tp3.domain.models.Type;
import com.inf25207.tp3.repositories.interfaces.ITypeRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TypeRepository implements ITypeRepository {
    private final SessionFactory sessionfactory;

    @Autowired
    public TypeRepository(SessionFactory sessionfactory) {
        this.sessionfactory = sessionfactory;
    }

    @Override
    public List<Type> getTypes() {
        Session session = sessionfactory.getCurrentSession();
        return session.createQuery("from Type", Type.class).list();
    }

    @Override
    public boolean addType(Type Type) {
        try {
            Session session = sessionfactory.getCurrentSession();

            session.beginTransaction();
            session.persist(Type);
            session.getTransaction().commit();
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    @Override
    public Type getType(int id) {
        Session session = sessionfactory.getCurrentSession();
        return session.get(Type.class, id);
    }

    @Override
    public void deleteType(int id) {
        Session session = sessionfactory.getCurrentSession();
        session.remove(getType(id));
    }
}
