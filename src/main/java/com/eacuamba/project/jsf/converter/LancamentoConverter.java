package com.eacuamba.project.jsf.converter;

import com.eacuamba.project.domain.model.Lancamento;
import com.eacuamba.project.domain.services.LancamentoService;
import jakarta.enterprise.inject.spi.CDI;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Inject;

import java.util.Objects;

@FacesConverter(forClass = Lancamento.class)
public class LancamentoConverter implements Converter<Lancamento> {

    private LancamentoService lancamentoService = CDI.current().select(LancamentoService.class).get();

    @Override
    public Lancamento getAsObject(FacesContext facesContext, UIComponent uiComponent, String value){
        if(value != null && !value.isEmpty()){
            return this.lancamentoService.findById(Long.parseLong(value)).orElse(null);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Lancamento value){
        if(Objects.nonNull(value)){
            return Objects.toString(((Lancamento)value).getId());
        }
        return "";
    }
}
