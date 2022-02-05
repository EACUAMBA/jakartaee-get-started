package com.eacuamba.faces.converter;

import com.eacuamba.domain.model.Pessoa;
import com.eacuamba.domain.services.PessoaService;
import jakarta.enterprise.inject.spi.CDI;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

import java.io.Serializable;

@FacesConverter(forClass = Pessoa.class)
public class PessoaConverter implements Converter<Pessoa>, Serializable {

    private PessoaService pessoaService = CDI.current().select(PessoaService.class).get();

    @Override
    public Pessoa getAsObject(FacesContext context, UIComponent component, String value) {
        if(value!= null && !value.isEmpty()){
            try {
                return this.pessoaService.buscarPessoaPeloID(Long.parseLong(value));
            } catch (Exception e) {
                FacesContext facesContext = FacesContext.getCurrentInstance();
                facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Pessoa seleccionada não existe.", "Pessoa seleccionada não foi encontrada no banco de dados!"));
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Pessoa value) {
        if(value != null){
            return ((Pessoa)value).getId().toString();
        }
        return null;
    }
}
