package es.common;

import java.text.SimpleDateFormat;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value = "validar")
public class Validar implements Validator {
	 public void validate(FacesContext context, UIComponent component,
	            Object value) throws ValidatorException {
	       	
		 	
		 	String fecha=String.valueOf(value).substring(0,4);
	           boolean valid = true;
	        if (value == null) {
	            valid = false;
	        } else if (Integer.parseInt(fecha) <=1915){
	            valid = false;
	        }
	        if (!valid) {
	            FacesMessage message = new FacesMessage(
	                    FacesMessage.SEVERITY_ERROR, "Invalid email address",
	                    "The email address you entered is not valid.");
	            throw new ValidatorException(message);
	        }
	    }
}
