package com.inf25207.tp3.repositories;

import com.inf25207.tp3.domain.models.Pilote;
import com.inf25207.tp3.domain.models.Piloter;
import com.inf25207.tp3.repositories.interfaces.IModelRepository;
import com.inf25207.tp3.repositories.interfaces.IUniqueRelationRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository(value = "piloterRepo")
public class PiloterRepository extends ModelRepository<Piloter> implements IUniqueRelationRepository<Piloter> {
    @Autowired
    private IModelRepository<Pilote> piloteRepo;

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
        Piloter experienceExistante = this.relationAlreadyExists(model);
        if (experienceExistante == null)
            return super.persist(model);

        model.setId(experienceExistante.getId());
        return true;
    }

    @Override
    public Piloter relationAlreadyExists(Piloter experience) {
        int piloteId = experience.getPilote().getMatricule();
        Pilote pilote = piloteRepo.getWithRelations(piloteId);

        return pilote.getExperiences()
                .stream()
                .filter(e -> Objects.equals(e.getAvion().getMatricule(), experience.getAvion().getMatricule()))
                .findFirst()
                .orElse(null);
    }
}
