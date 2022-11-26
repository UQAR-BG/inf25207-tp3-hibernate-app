package com.inf25207.tp3.repositories.interfaces;

import java.util.List;

public interface IModelRepository<T> {
    List<T> getAll();
    boolean persist(T model);
    T get(int id);
    void delete(int id);
}
