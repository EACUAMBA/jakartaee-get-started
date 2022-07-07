package com.eacuamba.project.jsf.beans;

import com.eacuamba.project.domain.exceptions.NegocioException;
import com.eacuamba.project.domain.model.Lancamento;
import com.eacuamba.project.domain.repository.LancamentoRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang.exception.NestableException;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@RequestScoped
@Named
public class LancamentoBean implements Serializable {

    @Inject
    private LancamentoRepository lancamentoRepository;

    @Getter
    @Setter
    private Lancamento lancamentoSelecionado;

    public List<Lancamento> getLancamentos(){
       return this.lancamentoRepository.findAll();
    }

    @Transactional
    public void delete(Lancamento lancamento)throws NegocioException{
        lancamento = this.lancamentoRepository.findById(lancamento.getId()).orElseThrow(()-> new NegocioException(""));

        if(Objects.nonNull(lancamento.getDataPagamento())){
            throw new NegocioException("Não é possível excluir um lançamento pago!");
        }

        this.lancamentoRepository.delete(lancamento.getId());
    }
}
