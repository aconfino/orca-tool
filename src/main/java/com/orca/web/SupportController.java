package com.orca.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.orca.domain.Support;
import com.orca.domain.Survey;
import com.orca.service.SurveyService;

@SessionAttributes({ "support" })
@Controller
public class SupportController {
	
	@Autowired
	private SurveyService surveyService;

	@RequestMapping(value = "support.html")
	public ModelAndView support(@RequestParam("surveyId") Integer surveyId) {
		Survey survey = surveyService.getSurvey(surveyId);
		if (!surveyService.authorizedUser(survey)){
			return new ModelAndView("notAuthorized");
		}
		ModelAndView mav = new ModelAndView("support");
		mav.addObject("support", survey.getSupport());
		mav.addObject("survey", survey);
		return mav;
	}
	
	@RequestMapping(value = "saveSupport.html")
	public String saveSupport(@ModelAttribute("support") Support support, 
			@RequestParam("surveyId") Integer surveyId, @RequestParam("submit") String submit) {
		Survey survey = surveyService.getSurvey(surveyId);
		if (!surveyService.authorizedUser(survey)){
			return "redirect:notAuthorized.html";
		}
		survey.setSupport(support);
		surveyService.saveSurvey(survey);
		if (submit.equals("Next Metric")) {
			return "redirect:velocity.html?surveyId=" + survey.getId();
		} else {
			return "redirect:evaluationSummary.html?evaluationId=" + survey.getEvaluation().getId();	
		}
	}
}
