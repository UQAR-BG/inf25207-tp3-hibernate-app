package com.inf25207.tp3.repositories;

import com.inf25207.tp3.domain.models.Piloter;
import com.inf25207.tp3.repositories.interfaces.IUniqueRelationRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "piloterRepo")
public class PiloterRepository extends ModelRepository<Piloter> implements IUniqueRelationRepository<Piloter> {
    @Override
    public List<Piloter> getAll() {
        Session session = sessionfactory.openSession();
        List<Piloter> Piloters = session.createQuery("from Piloter", Piloter.class).list();

        session.close();
        return Piloters;
    }

    @Override
    public Piloter get(int id) {
        Session session = sessionfactory.openSession();
        Piloter Piloter = session.get(Piloter.class, id);

        session.close();
        return Piloter;
    }

    @Override
    public boolean persist(Piloter model) {
        Piloter piloter = get(model.getPilote().getMatricule(), model.getAvion().getMatricule());
        if (piloter == null)
            return super.persist(model);
        else {
            return false;
        }
    }

    @Override
    public Piloter get(int leftId, int rightId) {
        Session session = sessionfactory.openSession();
        Query<Piloter> query = session.createQuery("from Piloter s where s.pilote.matricule=:pilote_matricule and s.avion.matricule=:avion_matricule", Piloter.class);
        query.setParameter("pilote_matricule", leftId);
        query.setParameter("avion_matricule", rightId);
        Piloter piloter = query.uniqueResult();

        session.close();
        return piloter;
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
