package com.orca.validator;

import javax.servlet.http.HttpSession;

import nl.captcha.Captcha;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;

import com.orca.form.ResetPasswordForm;
import com.orca.service.UserService;

public class ResetPasswordFormValidator {
	
	@Autowired
	private UserService service;
	private HttpSession session;
	
	public ResetPasswordFormValidator(HttpSession session){
		this.session = session;
	}
	
//	private Captcha captcha;
	
	public boolean supports(Class <?> clazz) {
		return ResetPasswordForm.class.equals(clazz);
	}

	public void validate(Object object, Errors e) {
//		captcha = ValidatorUtil.getCaptchaFromSession(session);
		ResetPasswordForm form = (ResetPasswordForm) object;
		if (!(ValidatorUtil.validEmail(form.getEmail()))){
            e.rejectValue("email", "reset.password.form.email.invalid");
        } else if (service.emailAvailable(form.getEmail())){
	        e.rejectValue("email", "reset.password.form.email.missing");
 	    } else if (form.getAnswer().isEmpty()) {
	        e.rejectValue("answer", "reset.password.form.answer.blank");
	//    } else if (!form.getAnswer().equals(captcha.getAnswer())) {
	 //       e.rejectValue("answer", "reset.password.form.answer.invalid");
	    } 
	}

}
