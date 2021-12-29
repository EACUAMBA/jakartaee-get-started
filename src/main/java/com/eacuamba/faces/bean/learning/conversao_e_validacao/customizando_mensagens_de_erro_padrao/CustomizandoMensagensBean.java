package com.eacuamba.faces.bean.learning.conversao_e_validacao.customizando_mensagens_de_erro_padrao;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Locale;

@Named
@RequestScoped
public class CustomizandoMensagensBean implements Serializable {
    private String nome;
    private LocalDate data_nascimento;

    public CustomizandoMensagensBean() {
        Locale.setDefault(new Locale("pt"));
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.getViewRoot().setLocale(Locale.getDefault());

    }

    public void salvar(){
        FacesContext facesContext = FacesContext.getCurrentInstance();

        if(this.nome.isEmpty() || this.nome.length() <= 2){
            FacesMessage facesMessage = new FacesMessage();
            facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
            facesMessage.setSummary("Nome extremamente curto.");
            facesMessage.setDetail("Nome deve ter no minimo 3 letras.");
            facesContext.addMessage(null, facesMessage);
        }

        if(data_nascimento.isAfter(LocalDate.now().minusYears(14))){
            FacesMessage facesMessage = new FacesMessage();
            facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
            facesMessage.setSummary("Problema com a data de nascimento");
            facesMessage.setDetail("O usuario deve ter no minimo 14 anos");
            facesContext.addMessage(null, facesMessage);
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(LocalDate data_nascimento) {
        this.data_nascimento = data_nascimento;
    }
}
