package com.eacuamba.faces.bean.learning.componentes_interfaces.propriedades_comums;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.component.html.HtmlInputText;
import jakarta.inject.Named;

import java.io.Serializable;

@Named
@SessionScoped
public class Propriedade_ID_Bean implements Serializable {
    private String valor;
    private boolean rederizar;
    private HtmlInputText inputTextValor;

    public void processar(){
        this.valor = (String)this.inputTextValor.getValue();
        this.rederizar = this.valor.trim().startsWith("render");

    }

    public String getValor(){
        return this.valor;
    }

     public boolean getRender(){
         return this.rederizar;
     }

     public void setInputTextValor(HtmlInputText inputTextValor){
        this.inputTextValor = inputTextValor;
     }

    public HtmlInputText getInputTextValor() {
        return inputTextValor;
    }
}
