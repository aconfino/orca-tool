package com.orca.validator;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;

import com.orca.form.ResetPasswordForm;
import com.orca.service.UserService;

public class ResetPasswordFormValidator {
	
	@Autowired
	private UserService service;
	
	public boolean supports(Class <?> clazz) {
		return ResetPasswordForm.class.equals(clazz);
	}

	public void validate(Object object, Errors e) {
		ResetPasswordForm form = (ResetPasswordForm) object;
		if (!(ValidatorUtil.validEmail(form.getEmail()))){
            e.rejectValue("email", "reset.password.form.email.invalid");
        } else if (service.emailAvailable(form.getEmail())){
	        e.rejectValue("email", "reset.password.form.email.missing");
 	    } 
	}

}
