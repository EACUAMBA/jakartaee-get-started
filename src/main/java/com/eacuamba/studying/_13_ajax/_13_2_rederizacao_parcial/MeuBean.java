package com.eacuamba.studying._13_ajax._13_2_rederizacao_parcial;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named //Defini o nome que será usado para termos a instância deste bean, neste caso será meuBean.
@RequestScoped //Será criada uma instância deste bean para cada request que o utilizador fizer ao nosso servidor, se tivermos milhares de utilizadores, cada um que fizer o request terá uma instância deste bean disponível.
public class MeuBean {
    private String nome;

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
