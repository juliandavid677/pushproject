/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.validation;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author shhin
 */
@FacesValidator(value = "validationSurname")
public class ValidationSurname implements Validator {
    private Integer validar;
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String texto = String.valueOf(value);
        try {
            validar = Integer.parseInt(texto);
            System.out.println("ENTRO AL VALIDAR = " + validar);
        } catch (NumberFormatException nfe) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Apellido es un número", "Debe ser letras");
            throw new ValidatorException(msg);
        }
    }
    
}
