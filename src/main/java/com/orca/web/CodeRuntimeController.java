package com.orca.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.orca.domain.CodeRuntime;
import com.orca.domain.Survey;
import com.orca.service.SurveyService;

@SessionAttributes({ "codeRuntime" })
@Controller
public class CodeRuntimeController {

	@Autowired
	SurveyService surveyService;

	@RequestMapping(value = "codeRuntime.html")
	public ModelAndView codeRuntime(@RequestParam("surveyId") Integer surveyId) {
		Survey survey = surveyService.getSurvey(surveyId);
		if (!surveyService.authorizedUser(survey))
			return new ModelAndView("notAuthorized");
		ModelAndView mav = new ModelAndView("codeRuntime");
		mav.addObject("codeRuntime", survey.getCodeRuntime());
		mav.addObject("survey", survey);
		return mav;
	}
	
	@RequestMapping(value = "saveCodeRuntime.html")
	public String saveCodeRuntime(@ModelAttribute("codeRuntime") CodeRuntime codeRuntime, 
			@RequestParam("surveyId") Integer surveyId, @RequestParam("submit") String submit) {
		Survey survey = surveyService.getSurvey(surveyId);
		if (!surveyService.authorizedUser(survey))
			return "redirect:notAuthorized.html";
		survey.setCodeRuntime(codeRuntime);
		surveyService.saveSurvey(survey);
		if (submit.equals("Next Metric"))
			return "redirect:codeStatic.html?surveyId=" + survey.getId();
		else {
			return "redirect:evaluationSummary.html?evaluationId=" + survey.getEvaluation().getId();	
		}
	}
}
