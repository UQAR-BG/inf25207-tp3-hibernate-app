package com.inf25207.tp3.services.interfaces;

import java.util.List;

public interface IModelService<T> {
    List<T> getAll();
    boolean persist(T model);
    T get(int id);
    T getWithRelations(int id);
    void delete(int id);
}
