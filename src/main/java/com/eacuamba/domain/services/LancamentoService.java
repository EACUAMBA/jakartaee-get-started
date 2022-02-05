package com.eacuamba.domain.services;

import com.eacuamba.domain.exceptions.NegocioException;
import com.eacuamba.domain.model.Lancamento;
import com.eacuamba.domain.repository.LancamentoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.time.LocalDateTime;
import java.util.Optional;


@ApplicationScoped
public class LancamentoService {

    @Inject
    private LancamentoRepository lancamentoRepository;

    public Lancamento salvar(Lancamento lancamento) throws NegocioException{
        if(lancamento != null && lancamento.getDataPagamento()!= null && lancamento.getDataPagamento().isAfter(LocalDateTime.now())) {
            throw new NegocioException("A data de pagamento não pode ser uma data futura.");
        }
        Optional<Lancamento> lancamentoOptional = this.lancamentoRepository.save(lancamento);

        return lancamentoOptional.orElse(null);
    }
}
