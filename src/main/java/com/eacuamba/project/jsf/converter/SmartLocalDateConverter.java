package com.eacuamba.project.jsf.converter;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.ConverterException;
import jakarta.faces.convert.FacesConverter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@FacesConverter(value = "smartLocalDateConverter")
public class SmartLocalDateConverter implements jakarta.faces.convert.Converter<LocalDate>{

    private static final DateTimeFormatter FORMATADOR = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @Override
    public LocalDate getAsObject(FacesContext context, UIComponent component, String value) {
        LocalDate dataConvertida = null;
        if(value == null || value.isEmpty()){
            return null;
        }

        if("hoje".equalsIgnoreCase(value)){
            dataConvertida = LocalDate.now();
        }else if (value.equalsIgnoreCase("amanha")){
            dataConvertida = LocalDate.now().plusDays(1);
        }else if(value.equalsIgnoreCase("ontem")){
            dataConvertida = LocalDate.now().minusDays(1);
        }else {
            try {
                dataConvertida = LocalDate.parse(value.trim(),FORMATADOR);
            }catch (DateTimeParseException e){
                throw  new ConverterException(new FacesMessage(FacesMessage.SEVERITY_INFO, "Data incorecta.", "Informe  uma data no padrão  "));
            }
        }
        return dataConvertida;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, LocalDate value) {
        return ((LocalDate)value).format(FORMATADOR);
    }
}
