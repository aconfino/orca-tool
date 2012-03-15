package com.orca.validator;


public class ValidatorUtil {

	public static Boolean validEmail(String email) {
		Boolean validEmail = false;
		if (email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}$"));
		validEmail = true;
		return validEmail;
	}

}