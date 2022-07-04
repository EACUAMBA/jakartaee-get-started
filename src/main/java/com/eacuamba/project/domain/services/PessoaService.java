package com.eacuamba.project.domain.services;


import com.eacuamba.project.domain.exceptions.NegocioException;
import com.eacuamba.project.domain.model.Pessoa;
import com.eacuamba.project.domain.repository.PessoaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class PessoaService implements Serializable {
    @Inject
    private PessoaRepository pessoaRepository;

    public List<Pessoa> buscarTodasPessoas(){
        return this.pessoaRepository.findAll();
    }

    public Pessoa buscarPessoaPeloID(Long pessoaId) throws NegocioException {
        Optional<Pessoa> pessoaOptional = this.pessoaRepository.findById(pessoaId);
        if(pessoaOptional.isPresent())
        return pessoaOptional.get();
        else
            throw new NegocioException("Pessoa não existe!");
    }
}
