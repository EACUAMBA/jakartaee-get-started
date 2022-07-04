package com.eacuamba.project.domain.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;


public abstract class BaseRepository <R, T> implements Serializable {
    @PersistenceContext(unitName = "java_ee_7_com_jsf_primefaces_e_cdi_2_edicao_algaworks")
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
