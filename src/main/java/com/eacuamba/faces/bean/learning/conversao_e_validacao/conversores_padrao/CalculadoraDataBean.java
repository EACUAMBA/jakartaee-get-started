package com.eacuamba.faces.bean.learning.conversao_e_validacao.conversores_padrao;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.time.LocalDate;

@Named
@RequestScoped
public class CalculadoraDataBean implements Serializable {
    private LocalDate date;
    private Integer dias;
    private LocalDate resultado;


    public void adicionar(){
        this.resultado = this.date.plusDays(this.dias);
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getDias() {
        return dias;
    }

    public void setDias(Integer dias) {
        this.dias = dias;
    }

    public LocalDate getResultado() {
        return resultado;
    }

    public void setResultado(LocalDate resultado) {
        this.resultado = resultado;
    }
}
