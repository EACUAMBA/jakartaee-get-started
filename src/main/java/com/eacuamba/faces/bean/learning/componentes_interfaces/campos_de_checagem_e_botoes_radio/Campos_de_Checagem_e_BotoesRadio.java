package com.eacuamba.faces.bean.learning.componentes_interfaces.campos_de_checagem_e_botoes_radio;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named
@SessionScoped
public class Campos_de_Checagem_e_BotoesRadio implements Serializable {
    private String estadoCivil = "";
    private String[] estadosDaAgua =  new String[]{"Solido", "Liquido", "Gasoso"};

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String[] getEstadosDaAgua() {
        return estadosDaAgua;
    }

    public void setEstadosDaAgua(String[] estadosDaAgua) {
        this.estadosDaAgua = estadosDaAgua;
    }

    public void processar(){}
}
