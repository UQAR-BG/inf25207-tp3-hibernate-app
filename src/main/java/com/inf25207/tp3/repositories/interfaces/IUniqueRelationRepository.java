package com.inf25207.tp3.repositories.interfaces;

public interface IUniqueRelationRepository<T> {
    T relationAlreadyExists(T model);
}
