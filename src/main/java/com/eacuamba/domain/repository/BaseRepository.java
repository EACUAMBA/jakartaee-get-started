package com.eacuamba.domain.repository;

import com.eacuamba.domain.model.Pessoa;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;


public abstract class BaseRepository <R, T> implements Serializable {
    @PersistenceContext(unitName = "jakartaee_get_started")
    protected EntityManager entityManager;
    protected Class<R> _class;

    @Transactional
    public Optional<R> save(R r){
        this.entityManager.persist(r);
        return Optional.of(r);
    }

    @Transactional
    public Optional<R> update(R r){
        return Optional.of(this.entityManager.merge(r));
    }

    public abstract List<R> findAll();
    public abstract Optional<R> findById(T t);

}
