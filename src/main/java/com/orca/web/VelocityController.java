package com.orca.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.orca.domain.Survey;
import com.orca.domain.Velocity;
import com.orca.service.SurveyService;

@SessionAttributes({ "velocity" })
@Controller
public class VelocityController {
	
	@Autowired
	private SurveyService surveyService;

	@RequestMapping(value = "velocity.html")
	public ModelAndView velocity(@RequestParam("surveyId") Integer surveyId) {
		Survey survey = surveyService.getSurvey(surveyId);
		if (!surveyService.authorizedUser(survey)){
			return new ModelAndView("notAuthorized");
		}
		ModelAndView mav = new ModelAndView("velocity");
		mav.addObject("velocity", survey.getVelocity());
		mav.addObject("survey", survey);
		return mav;
	}
	
	@RequestMapping(value = "saveVelocity.html")
	public String saveVelocity(@ModelAttribute("velocity") Velocity velocity, 
			@RequestParam("surveyId") Integer surveyId, @RequestParam("submit") String submit) {
		Survey survey = surveyService.getSurvey(surveyId);
		if (!surveyService.authorizedUser(survey)){
			return "redirect:notAuthorized.html";
		}
		survey.setVelocity(velocity);
		surveyService.saveSurvey(survey);
		if (submit.equals("Next Metric")) {
			return "redirect:functionality.html?surveyId=" + survey.getId();
		} else {
			return "redirect:evaluationSummary.html?evaluationId=" + survey.getEvaluation().getId();	
		}
	}
}
