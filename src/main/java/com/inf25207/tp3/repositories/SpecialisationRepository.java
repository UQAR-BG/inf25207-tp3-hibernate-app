package com.inf25207.tp3.repositories;

import com.inf25207.tp3.domain.models.Specialisation;
import com.inf25207.tp3.repositories.interfaces.IUniqueRelationRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Bastien Goulet
 * */

@Repository(value = "specialisationRepo")
public class SpecialisationRepository extends ModelRepository<Specialisation> implements IUniqueRelationRepository<Specialisation> {
    @Override
    public List<Specialisation> getAll() {
        Session session = sessionfactory.openSession();
        List<Specialisation> Specialisations = session.createQuery("from Specialisation", Specialisation.class).list();

        session.close();
        return Specialisations;
    }

    @Override
    public Specialisation get(int id) {
        return new Specialisation();
    }

    @Override
    public boolean persist(Specialisation model) {
        Specialisation specialisation = get(model.getTechnicien().getMatricule(), model.getType().getId());
        if (specialisation == null)
            return super.persist(model);
        else {
            return false;
        }
    }

    @Override
    public Specialisation get(int leftId, int rightId) {
        Session session = sessionfactory.openSession();
        Query<Specialisation> query = session.createQuery("from Specialisation s where s.technicien.matricule=:matricule and s.type.id=:id", Specialisation.class);
        query.setParameter("matricule", leftId);
        query.setParameter("id", rightId);
        Specialisation specialisation = query.uniqueResult();

        session.close();
        return specialisation;
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
