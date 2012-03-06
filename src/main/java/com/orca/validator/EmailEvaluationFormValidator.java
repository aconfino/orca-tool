package com.orca.validator;

import nl.captcha.Captcha;

import org.springframework.validation.Errors;

import com.orca.form.EmailEvaluationForm;

public class EmailEvaluationFormValidator {
	
	private Captcha captcha;
	
	public boolean supports(Class <?> clazz) {
		return EmailEvaluationFormValidator.class.equals(clazz);
	}

	public void validate(Object object, Errors e) {
		captcha = ValidatorUtil.getCaptchaFromSession();
		EmailEvaluationForm form = (EmailEvaluationForm) object;
        if (form.getAnswer().isEmpty()) {
            e.rejectValue("answer", "email.evaluation.form.answer.blank");
        } else if (!form.getAnswer().equals(captcha.getAnswer())) {
            e.rejectValue("answer", "email.evaluation.form.answer.invalid");
        } else if (!(ValidatorUtil.validEmail(form.getEmail()))){
            e.rejectValue("email", "email.evaluation.form.email.invalid");
        }
	}

}
