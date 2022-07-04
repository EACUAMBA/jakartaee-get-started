package com.eacuamba.studying.capitulo_13._13_4_a_propriedade_listener;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.event.AjaxBehaviorEvent;
import jakarta.inject.Named;

@Named(value = "_13_4_a_propriedade_listener") //Defini o nome que será usado para termos a instância deste bean, neste caso será meuBean.
@RequestScoped //Será criada uma instância deste bean para cada request que o utilizador fizer ao nosso servidor, se tivermos milhares de utilizadores, cada um que fizer o request terá uma instância deste bean disponível.
public class MeuBean {
    private String nome;

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void transformar(AjaxBehaviorEvent event){
        System.out.println(event);
        this.nome = this.nome.toUpperCase();
    }
}
