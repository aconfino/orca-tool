package com.orca.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.orca.domain.User;
import com.orca.service.UserService;

public class UserValidator implements Validator {

	@Autowired
	UserService service;
	
	public boolean supports(Class <?> clazz) {
		return User.class.equals(clazz);
	}

	public void validate(Object object, Errors e) {
		User user = (User) object;
        if (user.getPassword().isEmpty()) {
            e.rejectValue("password", "password.blank");
        } else if (user.getPassword().length() < 6) {
            e.rejectValue("password", "password.minimum.length");
        } else if (!(user.getPassword().equals(user.getConfirmPassword()))){
        	e.rejectValue("confirmPassword", "confirmPassword.does.not.match");
        } else if (!(user.getUsername().matches("^([0-9a-zA-Z]([-\\.\\w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-\\w]*[0-9a-zA-Z]\\.)+[a-zA-Z]{2,9})$"))) {
            e.rejectValue("username", "username.invalid", "email invalid");
        } else if (!(service.emailAvailable(user.getUsername()))){
            e.rejectValue("username", "username.exists");
        }
	}

}
