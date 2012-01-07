package com.orca.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.orca.service.EmailService;

@Controller
public class EmailController {

	@Autowired
	EmailService emailService;

	@RequestMapping(value = "emailEvaluation.html")
	public ModelAndView emailEvaluation(
			@RequestParam("evaluationNumber") String evaluationNumber) {
		ModelAndView mav = new ModelAndView("emailEvaluation");
		return mav;
	}

	@RequestMapping(value = "emailEvaluationConfirmation.html")
	public ModelAndView emailEvaluationConfirmation(
			@RequestParam("evaluationNumber") String evaluationNumber,
			@RequestParam("emailRecepient") String emailRecepient) {
		emailService.sendEmail(emailRecepient, getSubject(evaluationNumber),
				getMessageBody(evaluationNumber));
		ModelAndView mav = new ModelAndView("emailEvaluationConfirmation");
		return mav;
	}

	public String getSubject(String evaluationNumber) {
		String subject = new String("ORCA project - evaluation number: "
				+ evaluationNumber);
		return subject;
	}

	public String getMessageBody(String evaluationNumber) {
		String body = "Thank you for using the ORCA (Open Source Rapid Analysis) tool.  \n\n"
				+ "To continue your software evaluation go to "
				+ "http://localhost:8080/"
				+ "getEvaluation.html?evaluationNumber="
				+ evaluationNumber
				+ ".  \n\n Many thanks. \n The ORCA Team.";
		return body;
	}

}
