package com.orca.validator;

import javax.servlet.http.HttpSession;

import nl.captcha.Captcha;

import org.springframework.validation.Errors;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.orca.domain.EmailEvaluationForm;
import com.orca.domain.User;

public class EmailEvaluationFormValidator {
	
	private Captcha captcha;
	
	public EmailEvaluationFormValidator(){
		this.captcha = getCaptchaFromSession();
	}
	
	public boolean supports(Class <?> clazz) {
		return User.class.equals(clazz);
	}

	public void validate(Object object, Errors e) {
		EmailEvaluationForm form = (EmailEvaluationForm) object;
        if (form.getAnswer().isEmpty()) {
            e.rejectValue("answer", "email.evaluation.form.answer.blank");
        } else if (!form.getAnswer().equals(captcha.getAnswer())) {
            e.rejectValue("answer", "email.evaluation.form.answer.invalid");
        } else if (!(form.getEmail().matches("^([0-9a-zA-Z]([-\\.\\w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-\\w]*[0-9a-zA-Z]\\.)+[a-zA-Z]{2,9})$"))){
            e.rejectValue("email", "email.evaluation.form.email.invalid");
        }
	}
	
	public static Captcha getCaptchaFromSession() {
	    ServletRequestAttributes attribute = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
	    HttpSession session =  attribute.getRequest().getSession(true);  
	    return (Captcha) session.getAttribute(Captcha.NAME);
	}

}
