package com.inf25207.tp3.repositories;

import com.inf25207.tp3.domain.models.Type;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "typeRepo")
public class TypeRepository extends ModelRepository<Type> {
    @Override
    public List<Type> getAll() {
        Session session = sessionfactory.openSession();
        List<Type> Types = session.createQuery("from Type", Type.class).list();

        session.close();
        return Types;
    }

    @Override
    public Type get(int id) {
        Session session = sessionfactory.openSession();
        Type Type = session.get(Type.class, id);

        session.close();
        return Type;
    }
}
