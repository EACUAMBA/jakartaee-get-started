package com.eacuamba.project.domain.model.enumeration;

import lombok.Getter;

@Getter
public enum TipoLancamento {
    RECEITA("Receita"), DESPESA("Despesa");

    TipoLancamento(String designacao){
        this.designacao = designacao;
    }

    private String designacao;
}
