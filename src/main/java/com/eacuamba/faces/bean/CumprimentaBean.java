package com.eacuamba.faces.bean;

import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.component.html.HtmlInputText;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;

public class CumprimentaBean implements Serializable {
    private String nome;
    private String apelido;
    private String nomeCompleto = "";
    private HtmlInputText inputTextNome;

    public void dizerOla(){
        this.inputTextNome.setDisabled(true);
        this.nomeCompleto = this.nome.toUpperCase() + " " + this.apelido.toLowerCase();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getNomeCompleto() {
        return nomeCompleto + "teste";
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public HtmlInputText getInputTextNome() {
        return inputTextNome;
    }

    public void setInputTextNome(HtmlInputText inputTextNome) {
        this.inputTextNome = inputTextNome;
    }
}
