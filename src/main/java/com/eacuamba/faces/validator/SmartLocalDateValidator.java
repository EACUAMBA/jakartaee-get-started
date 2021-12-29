package com.eacuamba.faces.validator;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.FacesValidator;
import jakarta.faces.validator.Validator;
import jakarta.faces.validator.ValidatorException;

import java.time.DayOfWeek;
import java.time.LocalDate;

@FacesValidator(value = "smartLocalDateValidator")
public class SmartLocalDateValidator implements Validator {
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        LocalDate localDate = (LocalDate) value;
        if(localDate.getDayOfWeek() == DayOfWeek.SATURDAY || localDate.getDayOfWeek() == DayOfWeek.SUNDAY){
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Data fora do padrão", "Informa uma data que seja um dia útil. A sua data é " + localDate.getDayOfWeek().name()));
        }
    }
}
