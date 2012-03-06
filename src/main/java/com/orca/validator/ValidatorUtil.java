package com.orca.validator;

import javax.servlet.http.HttpSession;

import nl.captcha.Captcha;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class ValidatorUtil {
	
	public static Captcha getCaptchaFromSession() {
	    ServletRequestAttributes attribute = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
	    HttpSession session =  attribute.getRequest().getSession(true);  
	    return (Captcha) session.getAttribute(Captcha.NAME);
	}
	
	public static Boolean validEmail(String email){
		Boolean validEmail = false;
		if (email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}$")){
 			validEmail = true;
		}
		return validEmail;
	}

}
