package com.inf25207.tp3.services.interfaces;

import com.inf25207.tp3.domain.models.Type;

import java.util.List;

public interface ITypeService {
    List<Type> getTypes();
    boolean addType(Type Type);
    Type getType(int id);
    void deleteType(int id);
}
