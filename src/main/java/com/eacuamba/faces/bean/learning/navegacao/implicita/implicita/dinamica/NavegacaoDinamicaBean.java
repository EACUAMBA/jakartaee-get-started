package com.eacuamba.faces.bean.learning.navegacao.implicita.implicita.dinamica;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

@Named
@SessionScoped
public class NavegacaoDinamicaBean implements Serializable {
    private static final Logger logger = LoggerFactory.getLogger(NavegacaoDinamicaBean.class);

    public String acessarComprimentar(){
        logger.info("Retornando a página cumprimenta.xhtml");
        return "/learning/cumprimenta?faces-redirect=true";
    }
}
