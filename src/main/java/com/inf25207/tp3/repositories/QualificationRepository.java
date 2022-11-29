package com.inf25207.tp3.repositories;

import com.inf25207.tp3.domain.models.Qualification;
import com.inf25207.tp3.repositories.interfaces.IUniqueRelationRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "qualificationRepo")
public class QualificationRepository extends ModelRepository<Qualification> implements IUniqueRelationRepository<Qualification> {
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

    @Override
    public boolean persist(Qualification model) {
        Qualification qualification = get(model.getPilote().getMatricule(), model.getType().getId());
        if (qualification == null)
            return super.persist(model);
        else {
            return false;
        }
    }

    @Override
    public Qualification get(int leftId, int rightId) {
        Session session = sessionfactory.openSession();
        Query<Qualification> query = session.createQuery("from Qualification s where s.pilote.matricule=:matricule and s.type.id=:id", Qualification.class);
        query.setParameter("matricule", leftId);
        query.setParameter("id", rightId);
        Qualification qualification = query.uniqueResult();

        session.close();
        return qualification;
    }

    @Override
    public void delete(int leftId, int rightId) {
        Session session = sessionfactory.openSession();

        session.beginTransaction();
        session.remove(get(leftId, rightId));
        session.flush();
        session.getTransaction().commit();

        session.close();
    }
}
