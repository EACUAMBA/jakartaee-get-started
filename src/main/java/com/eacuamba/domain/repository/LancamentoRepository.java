package com.eacuamba.domain.repository;

import com.eacuamba.domain.model.Lancamento;
import com.eacuamba.domain.model.Pessoa;
import jakarta.enterprise.context.ApplicationScoped;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class LancamentoRepository extends BaseRepository<Lancamento, Long> implements Serializable {
    public LancamentoRepository(){
        this._class = Lancamento.class;
}

    public List<Lancamento> findAll(){
        return this.entityManager.createQuery("SELECT l FROM Lancamento l join fetch l.pessoa", Lancamento.class).getResultList();
    }

    public Optional<Lancamento> findById(Long id){
        return Optional.of(this.entityManager.find(Lancamento.class, id));
    }
}
