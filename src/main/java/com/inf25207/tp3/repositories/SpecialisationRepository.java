package com.inf25207.tp3.repositories;

import com.inf25207.tp3.domain.models.Specialisation;
import com.inf25207.tp3.domain.models.Technicien;
import com.inf25207.tp3.repositories.interfaces.IModelRepository;
import com.inf25207.tp3.repositories.interfaces.IUniqueRelationRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository(value = "specialisationRepo")
public class SpecialisationRepository extends ModelRepository<Specialisation> implements IUniqueRelationRepository<Specialisation> {
    @Autowired
    private IModelRepository<Technicien> technicienRepo;

    @Override
    public List<Specialisation> getAll() {
        Session session = sessionfactory.openSession();
        List<Specialisation> Specialisations = session.createQuery("from Specialisation", Specialisation.class).list();

        session.close();
        return Specialisations;
    }

    @Override
    public Specialisation get(int id) {
        Session session = sessionfactory.openSession();
        Specialisation Specialisation = session.get(Specialisation.class, id);

        session.close();
        return Specialisation;
    }

    @Override
    public boolean persist(Specialisation model) {
        Specialisation specialisationExistante = this.relationAlreadyExists(model);
        if (specialisationExistante == null)
            return super.persist(model);

        model.setId(specialisationExistante.getId());
        return true;
    }

    @Override
    public Specialisation relationAlreadyExists(Specialisation specialisation) {
        int techId = specialisation.getTechnicien().getMatricule();
        Technicien tech = technicienRepo.getWithRelations(techId);

        return tech.getSpecialisations()
                .stream()
                .filter(s -> Objects.equals(s.getType().getId(), specialisation.getType().getId()))
                .findFirst()
                .orElse(null);
    }
}
