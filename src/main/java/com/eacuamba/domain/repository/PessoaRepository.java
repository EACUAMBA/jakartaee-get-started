package com.eacuamba.domain.repository;

import com.eacuamba.domain.model.Pessoa;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class PessoaRepository {

    @PersistenceContext(unitName = "jakartaee_get_started")
    private EntityManager entityManager;

    @Transactional(Transactional.TxType.REQUIRED)
    public void create(Pessoa pessoa){
        this.entityManager.persist(pessoa);
    }

    public Optional<List<Pessoa>> findAll(){
        return Optional.of(this.entityManager.createQuery("SELECT p FROM Pessoa p", Pessoa.class).getResultList());
    }

    public Optional<Pessoa> findById(Long id){
        return Optional.of(this.entityManager.find(Pessoa.class, id));
    }


}
