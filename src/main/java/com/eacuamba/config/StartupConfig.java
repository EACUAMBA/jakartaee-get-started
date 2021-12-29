package com.eacuamba.config;

import com.eacuamba.config.resource_bundle.ResourceBundleWraper;
import jakarta.faces.context.FacesContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StartupConfig {
    private static Logger logger = LoggerFactory.getLogger(StartupConfig.class);
    static {

        /*
         * Os construtores estáticos não iniciam automaticamente, para eles iniciarem devemos fazer uma dessas coisas:
         * 1 — Criar uma instância da classe;
         * 2 — Acessar um membro estático;
         */
        logger.info("Limpando a cache do Resource Bundle.");
        ResourceBundleWraper.clearCache();
    }
    public static void init(){

    }
}
