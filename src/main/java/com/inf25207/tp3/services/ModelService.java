package com.inf25207.tp3.services;

import com.inf25207.tp3.repositories.interfaces.IModelRepository;
import com.inf25207.tp3.services.interfaces.IModelService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Bastien Goulet
 * */

@Service
public abstract class ModelService<T> implements IModelService<T> {
    protected IModelRepository<T> repository;

    @Override
    @Transactional
    public List<T> getAll() {
        return repository.getAll();
    }

    @Override
    @Transactional
    public boolean persist(T model) {
        return repository.persist(model);
    }

    @Override
    @Transactional
    public T get(int id) {
        return repository.get(id);
    }

    @Override
    @Transactional
    public T getWithRelations(int id) {
        return repository.getWithRelations(id);
    }

    @Override
    @Transactional
    public T update(T model) {
        return repository.update(model);
    }

    @Override
    @Transactional
    public void delete(int id) {
        repository.delete(id);
    }
}
