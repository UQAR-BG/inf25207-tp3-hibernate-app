package com.inf25207.tp3.repositories;

import com.inf25207.tp3.domain.models.Type;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "typeRepo")
public class TypeRepository extends ModelRepository<Type> {
    @Override
    public List<Type> getAll() {
        Session session = sessionfactory.openSession();
        List<Type> types = session.createQuery("from Type", Type.class).list();

        session.close();
        return types;
    }

    @Override
    public Type get(int id) {
        Session session = sessionfactory.openSession();
        Type type = session.get(Type.class, id);

        session.close();
        return type;
    }

    @Override
    public Type getWithRelations(int id) {
        Session session = sessionfactory.openSession();
        Type type = session.get(Type.class, id);

        Hibernate.initialize(type.getSpecialisations());
        Hibernate.initialize(type.getQualifications());

        session.close();
        return type;
    }
}
