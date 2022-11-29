package com.inf25207.tp3.repositories;

import com.inf25207.tp3.domain.models.Pilote;
import com.inf25207.tp3.domain.models.Qualification;
import com.inf25207.tp3.repositories.interfaces.IModelRepository;
import com.inf25207.tp3.repositories.interfaces.IUniqueRelationRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository(value = "qualificationRepo")
public class QualificationRepository extends ModelRepository<Qualification> implements IUniqueRelationRepository<Qualification> {
    @Autowired
    private IModelRepository<Pilote> piloteRepo;

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
        Qualification qualifExistante = this.relationAlreadyExists(model);
        if (qualifExistante == null)
            return super.persist(model);

        model.setId(qualifExistante.getId());
        return true;
    }

    @Override
    public Qualification relationAlreadyExists(Qualification qualification) {
        int piloteId = qualification.getPilote().getMatricule();
        Pilote pilote = piloteRepo.getWithRelations(piloteId);

        return pilote.getQualifications()
                .stream()
                .filter(q -> Objects.equals(q.getType().getId(), qualification.getType().getId()))
                .findFirst()
                .orElse(null);
    }
}
