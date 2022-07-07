package com.eacuamba.project.domain.services;

import com.eacuamba.project.domain.exceptions.NegocioException;
import com.eacuamba.project.domain.model.Lancamento;
import com.eacuamba.project.domain.repository.LancamentoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@ApplicationScoped
public class LancamentoService {

    @Inject
    private LancamentoRepository lancamentoRepository;

    @Transactional
    public Lancamento salvar(Lancamento lancamento) throws NegocioException {
        if (lancamento != null && lancamento.getDataPagamento() != null && lancamento.getDataPagamento().isAfter(LocalDateTime.now())) {
            throw new NegocioException("A data de pagamento não pode ser uma data futura.");
        }
        Optional<Lancamento> lancamentoOptional = this.lancamentoRepository.save(lancamento);

        return lancamentoOptional.orElse(null);
    }

    public List<String> findAllDescricaoLIKE(String descricao) {
        return this.lancamentoRepository.findAllDescricaoLIKE(descricao);
    }

    public Optional<Lancamento> findById(Long id) {
        return this.lancamentoRepository.findById(id);
    }

    public void delete(Long id) throws NegocioException {
        Optional<Lancamento> optionalLancamento = this.findById(id);
        if(optionalLancamento.isEmpty()) return;
        if (Objects.nonNull(optionalLancamento.get().getDataPagamento())) {
            throw new NegocioException("Não é possível excluir um lançamento pago!");
        }
        this.lancamentoRepository.delete(id);
    }
}
