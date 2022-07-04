package com.eacuamba.project.domain.repository;

import com.eacuamba.project.domain.model.Pessoa;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class PessoaRepository extends BaseRepository<Pessoa, Long> implements Serializable {

    public PessoaRepository() {
        this._class = Pessoa.class;
    }

    public List<Pessoa> findAll(){
        return this.entityManager.createQuery("SELECT p FROM Pessoa p", Pessoa.class).getResultList();
    }

    public Optional<Pessoa> findById(Long id){
        return Optional.of(this.entityManager.find(Pessoa.class, id));
    }


}
