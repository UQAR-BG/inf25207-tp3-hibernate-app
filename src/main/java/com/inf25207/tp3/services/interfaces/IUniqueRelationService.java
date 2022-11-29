package com.inf25207.tp3.services.interfaces;

public interface IUniqueRelationService<T> {
    T get(int leftId, int rightId);
    void delete(int leftId, int rightId);
}
