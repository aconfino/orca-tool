package com.orca.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.orca.domain.CodeStatic;
import com.orca.domain.Survey;
import com.orca.service.SurveyService;

@SessionAttributes({ "codeStatic" })
@Controller
public class CodeStaticController {
	
	@Autowired
	SurveyService surveyService;

	@RequestMapping(value = "codeStatic.html")
	public ModelAndView codeStatic(@RequestParam("surveyId") Integer surveyId) {
		Survey survey = surveyService.getSurvey(surveyId);
		if (!surveyService.authorizedUser(survey))
			return new ModelAndView("notAuthorized");
		ModelAndView mav = new ModelAndView("codeStatic");
		mav.addObject("codeStatic", survey.getCodeStatic());
		return mav;
	}
	
	@RequestMapping(value = "saveCodeStatic.html")
	public String saveCodeStatic(@ModelAttribute("codeStatic") CodeStatic codeStatic, 
			@RequestParam("surveyId") Integer surveyId, @RequestParam("submit") String submit) {
		Survey survey = surveyService.getSurvey(surveyId);
		if (!surveyService.authorizedUser(survey))
			return "redirect:notAuthorized.html";
		survey.setCodeStatic(codeStatic);
		surveyService.saveSurvey(survey);
		if (submit.equals("Next Metric"))
			return "redirect:community.html?surveyId=" + survey.getId();
		else {
			return "redirect:evaluationSummary.html?evaluationId=" + survey.getEvaluation().getId();	
		}
	}
}
