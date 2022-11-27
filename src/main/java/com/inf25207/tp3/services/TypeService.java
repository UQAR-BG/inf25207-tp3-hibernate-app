package com.inf25207.tp3.services;

import com.inf25207.tp3.domain.models.Type;
import com.inf25207.tp3.repositories.interfaces.IModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "typeService")
public class TypeService extends ModelService<Type> {
    @Autowired
    public TypeService(IModelRepository<Type> typeRepo) {
        this.repository = typeRepo;
    }
}
