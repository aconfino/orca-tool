package com.orca.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.orca.domain.MarketPenetration;
import com.orca.domain.Survey;
import com.orca.service.SurveyService;

@SessionAttributes({ "marketPenetration" })
@Controller
public class MarketPenetrationController {
	
	@Autowired
	private SurveyService surveyService;

	@RequestMapping(value = "marketPenetration.html")
	public ModelAndView marketPenetration(@RequestParam("surveyId") Integer surveyId) {
		Survey survey = surveyService.getSurvey(surveyId);
		if (!surveyService.authorizedUser(survey)){
			return new ModelAndView("notAuthorized");
		}
		ModelAndView mav = new ModelAndView("marketPenetration");
		mav.addObject("marketPenetration", survey.getMarketPenetration());
		mav.addObject("survey", survey);
		return mav;
	}
	
	@RequestMapping(value = "saveMarketPenetration.html")
	public String saveMarketPenetration(@ModelAttribute("marketPenetration") MarketPenetration marketPenetration, 
			@RequestParam("surveyId") Integer surveyId, @RequestParam("submit") String submit) {
		Survey survey = surveyService.getSurvey(surveyId);
		if (!surveyService.authorizedUser(survey)){
			return "redirect:notAuthorized.html";
		}
		survey.setMarketPenetration(marketPenetration);
		surveyService.saveSurvey(survey);
		if (submit.equals("Next Metric")) {
			return "redirect:pedigree.html?surveyId=" + survey.getId();
		} else {
			return "redirect:evaluationSummary.html?evaluationId=" + survey.getEvaluation().getId();	
		}
	}
}
