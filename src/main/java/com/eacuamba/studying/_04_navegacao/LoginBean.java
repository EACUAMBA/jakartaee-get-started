package com.eacuamba.studying._04_navegacao;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang.StringUtils;

import java.io.Serializable;

@Getter
@Setter
@RequestScoped
@Named
public class LoginBean {
    private String username;
    private String password;

    public String autenticar(){
        System.out.println("Fazendo a autenticação!");
        if(StringUtils.isNotBlank(this.username) && StringUtils.isNotBlank(password)){
//            Este é o outcome que retornamos
            return "/studying/04_navegacao/4_2_navegacao_implicita/dinamica/welcome";
        }else {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            FacesMessage facesMessage = new FacesMessage();
            facesMessage.setSummary("Credenciais Incorrectas!");
            facesMessage.setSummary("Não conseguimos te autenticar com as credenciais que enviou!");
            facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
            facesContext.addMessage(null, facesMessage);
            return null;
        }
    }

}
