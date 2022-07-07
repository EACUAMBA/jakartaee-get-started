package com.eacuamba.project.domain.repository;

import com.eacuamba.project.domain.model.Lancamento;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.TypedQuery;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class LancamentoRepository extends BaseRepository<com.eacuamba.project.domain.model.Lancamento, Long> implements Serializable {
    public LancamentoRepository(){
        this._class = com.eacuamba.project.domain.model.Lancamento.class;
}

    public List<Lancamento> findAll(){
        return this.entityManager.createQuery("SELECT l FROM Lancamento l join fetch l.pessoa", com.eacuamba.project.domain.model.Lancamento.class).getResultList();
    }

    public Optional<Lancamento> findById(Long id){
        return Optional.of(this.entityManager.find(com.eacuamba.project.domain.model.Lancamento.class, id));
    }

    public List<String> findAllDescricaoLIKE(String text){
        TypedQuery<String> descricaoTypedQuery = this.entityManager.createQuery("SELECT DISTINCT l.descricao FROM Lancamento l WHERE UPPER(l.descricao) LIKE UPPER(:descricao) ", String.class);
        descricaoTypedQuery.setParameter("descricao", text);
        return descricaoTypedQuery.getResultList();
    }

    public void delete(Long id){
        this.findById(id).ifPresent((l)->this.entityManager.remove(l));

    }

}
