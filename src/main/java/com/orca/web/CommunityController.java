package com.orca.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.orca.domain.Community;
import com.orca.domain.Survey;
import com.orca.service.SurveyService;

@SessionAttributes({ "community" })
@Controller
public class CommunityController {
	
	@Autowired
	SurveyService surveyService;

	@RequestMapping(value = "community.html")
	public ModelAndView community(@RequestParam("surveyId") Integer surveyId) {
		Survey survey = surveyService.getSurvey(surveyId);
		if (!surveyService.authorizedUser(survey))
			return new ModelAndView("notAuthorized");
		ModelAndView mav = new ModelAndView("community");
		mav.addObject("community", survey.getCommunity());
		mav.addObject("survey", survey);
		return mav;
	}
	
	@RequestMapping(value = "saveCommunity.html")
	public String saveCommunity(@ModelAttribute("community") Community community, 
			@RequestParam("surveyId") Integer surveyId, @RequestParam("submit") String submit) {
		Survey survey = surveyService.getSurvey(surveyId);
		if (!surveyService.authorizedUser(survey))
			return "redirect:notAuthorized.html";
		survey.setCommunity(community);
		surveyService.saveSurvey(survey);
		if (submit.equals("Next Metric"))
			return "redirect:documentation.html?surveyId=" + survey.getId();
		else {
			return "redirect:evaluationSummary.html?evaluationId=" + survey.getEvaluation().getId();	
		}
	}
}