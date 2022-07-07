package com.eacuamba.project.jsf.beans;

import com.eacuamba.project.domain.model.Utilizador;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Named
@RequestScoped
public class LoginBean implements Serializable {
    @Inject
    private Utilizador utilizador;

    @Getter
    @Setter
    private String username;

    @Getter
    @Setter
    private String senha;

    public String login(){
        FacesContext facesContext = FacesContext.getCurrentInstance();

        if(Objects.equals("admin", username) && Objects.equals("admin", senha)){
            this.utilizador.setUsername(this.username);
            this.utilizador.setSenha(this.senha);
            return "/project/lancamento/lancamentos?faces-redirect=true";
        }else{
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Credenciais ínvalidas.", "");
            facesContext.addMessage(null, message);
        }

        return null;
    }
}
