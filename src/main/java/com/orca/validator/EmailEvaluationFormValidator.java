package com.orca.validator;

import org.springframework.validation.Errors;

import com.orca.form.EmailEvaluationForm;

public class EmailEvaluationFormValidator {

	@SuppressWarnings("rawtypes")
	public boolean supports(Class clazz) {
		return EmailEvaluationFormValidator.class.equals(clazz);
	}

	public void validate(Object object, Errors e) {
		EmailEvaluationForm form = (EmailEvaluationForm) object;
        if (!(ValidatorUtil.validEmail(form.getEmail()))){
            e.rejectValue("email", "email.evaluation.form.email.invalid");
        }
	}

}
