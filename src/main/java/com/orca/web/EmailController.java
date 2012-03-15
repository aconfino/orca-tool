package com.orca.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.orca.form.EmailEvaluationForm;
import com.orca.service.EmailService;
import com.orca.validator.EmailEvaluationFormValidator;

@SessionAttributes({"emailEvaluationForm", "emailFormValidator"})
@Controller
public class EmailController {

	@Autowired
	private EmailService emailService;
	@Autowired
	private EmailEvaluationFormValidator emailFormValidator;

	@RequestMapping(value = "emailEvaluation.html")
	public ModelAndView emailEvaluation(
			@RequestParam("evaluationNumber") String evaluationNumber) {
		ModelAndView mav = new ModelAndView("emailEvaluation");
		mav.addObject("emailEvaluationForm", new EmailEvaluationForm());
		return mav;
	}

	@RequestMapping(value = "emailEvaluationVerify.html")
	public ModelAndView emailEvaluationVerify(@ModelAttribute("emailEvaluationForm") EmailEvaluationForm form, BindingResult result, HttpServletRequest request) {	
		emailFormValidator.validate(form, result);
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView("emailEvaluation");
			mav.addObject("form", form);
			return mav;
		}
		emailService.sendEmail(form.getEmail(), getSubject(form.getEvaluationNumber()),getMessageBody(form.getEvaluationNumber()));
		return new ModelAndView("emailEvaluationConfirmation");
	}

	public String getSubject(String evaluationNumber) {
		return new String("ORCA project - evaluation number: " + evaluationNumber);
	}

	public String getMessageBody(String evaluationNumber) {
		String body = "Thank you for using the ORCA (Open Source Rapid Analysis) tool.  \n\n"
				+ "To continue your software evaluation go to "
				+ "http://orca-project.herokuapp.com/"
				+ "getEvaluation.html?evaluationNumber="
				+ evaluationNumber
				+ ".  \n\n Many thanks. \n The ORCA Team.";
		return body;
	}
	
}
