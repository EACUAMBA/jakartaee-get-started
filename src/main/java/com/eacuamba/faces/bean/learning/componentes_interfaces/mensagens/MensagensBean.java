package com.eacuamba.faces.bean.learning.componentes_interfaces.mensagens;

import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.facelets.FaceletContext;
import jakarta.inject.Named;

import java.util.concurrent.TimeUnit;

@ApplicationScoped
@Named
public class MensagensBean {
    private String email;

    public void assinar() throws InterruptedException {
        Thread.sleep(TimeUnit.SECONDS.toMillis(5));
        FacesContext facesContext = FacesContext.getCurrentInstance();

        FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Assinatura newsletter",String.format("O email %s foi adicionado a nossa caixa de destinatarios", this.email));
        facesContext.addMessage(null, facesMessage);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
