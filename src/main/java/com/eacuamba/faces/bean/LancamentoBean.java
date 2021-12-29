package com.eacuamba.faces.bean;

import com.eacuamba.domain.model.Lancamento;
import com.eacuamba.domain.repository.LancamentoRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@RequestScoped
@Named
public class LancamentoBean implements Serializable {

    @Inject
    private LancamentoRepository lancamentoRepository;

    public List<Lancamento> getLancamentos(){
       return this.lancamentoRepository.findAll();

    }
}
