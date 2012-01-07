package com.orca.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.orca.domain.Functionality;
import com.orca.domain.Survey;
import com.orca.service.SurveyService;

@SessionAttributes({ "functionality" })
@Controller
public class FunctionalityController {
	
	@Autowired
	SurveyService surveyService;

	@RequestMapping(value = "functionality.html")
	public ModelAndView functionality(@RequestParam("surveyId") Integer surveyId) {
		Survey survey = surveyService.getSurvey(surveyId);
		if (!surveyService.authorizedUser(survey))
			return new ModelAndView("notAuthorized");
		ModelAndView mav = new ModelAndView("functionality");
		mav.addObject("functionality", survey.getFunctionality());
		return mav;
	}
	
	@RequestMapping(value = "saveFunctionality.html")
	public String saveFunctionality(@ModelAttribute("functionality") Functionality functionality, 
			@RequestParam("surveyId") Integer surveyId, @RequestParam("submit") String submit) {
		Survey survey = surveyService.getSurvey(surveyId);
		if (!surveyService.authorizedUser(survey))
			return "redirect:notAuthorized.html";
		survey.setFunctionality(functionality);
		surveyService.saveSurvey(survey);
		if (submit.equals("Next Metric"))
			return "redirect:surveyComments.html?surveyId=" + survey.getId();
		else {
			return "redirect:evaluationSummary.html?evaluationId=" + survey.getEvaluation().getId();	
		}
	}
}
