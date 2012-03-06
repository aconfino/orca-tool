package com.orca.validator;

import org.springframework.validation.Errors;

import com.orca.domain.User;

public class ChangePasswordValidator {
		
	public boolean supports(Class <?> clazz) {
		return User.class.equals(clazz);
	}

	public void validate(Object object, Errors e) {
		User user = (User) object;
		if (user.getPassword().isEmpty()){
            e.rejectValue("password", "change.password.form.password.empty");
        } else if (user.getPassword().length() < 6){
            e.rejectValue("password", "change.password.form.password.too.short");
        } else if (user.getPassword().contains(" ")){
            e.rejectValue("password", "change.password.form.password.no.spaces");
        } else if (!(user.getPassword().equals(user.getConfirmPassword()))){
	        e.rejectValue("confirmPassword", "change.password.form.confirm.password.match");
 	   } 
	}

}
