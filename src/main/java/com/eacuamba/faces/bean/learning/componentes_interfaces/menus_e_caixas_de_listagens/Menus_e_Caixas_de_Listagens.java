package com.eacuamba.faces.bean.learning.componentes_interfaces.menus_e_caixas_de_listagens;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.Arrays;

@Named
@SessionScoped
public class Menus_e_Caixas_de_Listagens implements Serializable {
    private String provincia = "";
    private String[] provincias = new String[]{};

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String[] getProvincias() {
        return provincias;
    }

    public String getProvinciastoString() {
        StringBuilder out = new StringBuilder();
        Arrays.stream(provincias).forEach(out::append);
        return out.toString();
    }

    public void setProvincias(String[] provincias) {
        this.provincias = provincias;
    }

    public void processar(){

    }

}
