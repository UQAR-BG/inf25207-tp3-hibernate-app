package com.inf25207.tp3.services;

import com.inf25207.tp3.domain.models.Type;
import com.inf25207.tp3.repositories.interfaces.IModelRepository;
import com.inf25207.tp3.services.interfaces.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TypeService implements ITypeService {
    private final IModelRepository<Type> TypeRepo;

    @Autowired
    public TypeService(IModelRepository<Type> TypeRepo) {
        this.TypeRepo = TypeRepo;
    }

    @Override
    @Transactional
    public List<Type> getTypes() {
        return TypeRepo.getAll();
    }

    @Override
    @Transactional
    public boolean addType(Type Type) {
        return TypeRepo.persist(Type);
    }

    @Override
    @Transactional
    public Type getType(int id) {
        return TypeRepo.get(id);
    }

    @Override
    @Transactional
    public void deleteType(int id) {
        TypeRepo.delete(id);
    }
}
