package com.inf25207.tp3.repositories.interfaces;

/**
 * @author Bastien Goulet
 * */

public interface IUniqueRelationRepository<T> {
    T get(int leftId, int rightId);
    void delete(int leftId, int rightId);
}
