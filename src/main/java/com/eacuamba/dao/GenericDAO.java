/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eacuamba.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 *
 * @author EACUAMBA
 * @param <T>
 * @param <R>
 */
public abstract class GenericDAO <T, R> {
    
    @PersistenceContext(unitName = "JakartaEE_DevPU")
    private EntityManager entityManager;
    
    private Class _class;
    
    public void setClass(Class _class){
    this._class = _class;
}
    
    public T save(T t){
        this.entityManager.persist(t);
        return t;
    }
    public T update(T t){
        return this.entityManager.merge(t);
    }
    public T findById( R r){
        return (T)this.entityManager.find(_class, r);
    }
    public List<T> findAll(){
        String sql = "SELECT t FROM T t";
        TypedQuery<T> typedQuery = this.entityManager.createQuery(sql, _class);
        List<T> resultList = typedQuery.getResultList();
        
        return resultList;
    }
    
}
