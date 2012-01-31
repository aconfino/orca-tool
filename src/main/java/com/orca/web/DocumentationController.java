package com.orca.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.orca.domain.Documentation;
import com.orca.domain.Survey;
import com.orca.service.SurveyService;

@SessionAttributes({ "documentation" })
@Controller
public class DocumentationController {
	
	@Autowired
	SurveyService surveyService;

	@RequestMapping(value = "documentation.html")
	public ModelAndView documentation(@RequestParam("surveyId") Integer surveyId) {
		Survey survey = surveyService.getSurvey(surveyId);
		if (!surveyService.authorizedUser(survey))
			return new ModelAndView("notAuthorized");
		ModelAndView mav = new ModelAndView("documentation");
		mav.addObject("documentation", survey.getDocumentation());
		mav.addObject("survey", survey);
		return mav;
	}
	
	@RequestMapping(value = "saveDocumentation.html")
	public String saveDocumentation(@ModelAttribute("documentation") Documentation documentation, 
			@RequestParam("surveyId") Integer surveyId, @RequestParam("submit") String submit) {
		Survey survey = surveyService.getSurvey(surveyId);
		if (!surveyService.authorizedUser(survey))
			return "redirect:notAuthorized.html";
		survey.setDocumentation(documentation);
		surveyService.saveSurvey(survey);
		if (submit.equals("Next Metric"))
			return "redirect:license.html?surveyId=" + survey.getId();
		else {
			return "redirect:evaluationSummary.html?evaluationId=" + survey.getEvaluation().getId();	
		}
	}
}
