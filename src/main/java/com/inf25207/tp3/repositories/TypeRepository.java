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
        Session session = sessionfactory.openSession();
        List<Type> types = session.createQuery("from Type", Type.class).list();

        session.close();
        return types;
    }

    @Override
    public boolean addType(Type Type) {
        try {
            Session session = sessionfactory.openSession();

            session.beginTransaction();
            session.persist(Type);
            session.getTransaction().commit();

            session.close();
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    @Override
    public Type getType(int id) {
        Session session = sessionfactory.openSession();
        Type type = session.get(Type.class, id);

        session.close();
        return type;
    }

    @Override
    public void deleteType(int id) {
        Session session = sessionfactory.openSession();
        session.remove(getType(id));

        session.close();
    }
}
