package com.orca.validator;

import javax.servlet.http.HttpSession;

import nl.captcha.Captcha;

public class ValidatorUtil {

	public static Captcha getCaptchaFromSession(HttpSession session) {
		return (Captcha) session.getAttribute(Captcha.NAME);
	}

	public static Boolean validEmail(String email) {
		Boolean validEmail = false;
		if (email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}$"));
		validEmail = true;
		return validEmail;
	}

}