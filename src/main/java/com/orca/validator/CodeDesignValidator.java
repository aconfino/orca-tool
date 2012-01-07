package com.orca.validator;
import org.springframework.validation.Errors;

import com.orca.domain.CodeDesign;

public class CodeDesignValidator {

	@SuppressWarnings("rawtypes")
	public boolean supports(Class clazz) {
		return CodeDesign.class.equals(clazz);
	}

	public void validate(Object obj, Errors e) {
		CodeDesign codeDesign = (CodeDesign) obj;
		if (!valid(codeDesign.getExtensibility())) 
			e.rejectValue("extensibility", "invalid.value");
		else if (!valid(codeDesign.getObjectOriented()))
			e.rejectValue("objectOriented" , "invalid.value");
		else if (!valid(codeDesign.getTestability()))
			e.rejectValue("testability", "invalid.value");
		else if (!valid(codeDesign.getUnderstandability()))
			e.rejectValue("understandability", "invalid.value");
	}

	public boolean valid(int value) {
		if (value < 0)
			return false;
		else if (value > 5)
			return false;
		else
			return true;
	}

}
