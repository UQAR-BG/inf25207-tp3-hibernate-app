package com.inf25207.tp3.repositories.interfaces;

import com.inf25207.tp3.domain.models.Type;

import java.util.List;

public interface ITypeRepository {
    List<Type> getTypes();
    boolean addType(Type svion);
    Type getType(int id);
    void deleteType(int id);
}
