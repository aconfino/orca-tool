package com.orca.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.orca.domain.Pedigree;
import com.orca.domain.Survey;
import com.orca.service.SurveyService;

@SessionAttributes({ "pedigree" })
@Controller
public class PedigreeController {
	
	@Autowired
	SurveyService surveyService;

	@RequestMapping(value = "pedigree.html")
	public ModelAndView pedigree(@RequestParam("surveyId") Integer surveyId) {
		Survey survey = surveyService.getSurvey(surveyId);
		if (!surveyService.authorizedUser(survey))
			return new ModelAndView("notAuthorized");
		ModelAndView mav = new ModelAndView("pedigree");
		mav.addObject("pedigree", survey.getPedigree());
		return mav;
	}
	
	@RequestMapping(value = "savePedigree.html")
	public String savePedigree(@ModelAttribute("pedigree") Pedigree pedigree, 
			@RequestParam("surveyId") Integer surveyId, @RequestParam("submit") String submit) {
		Survey survey = surveyService.getSurvey(surveyId);
		if (!surveyService.authorizedUser(survey))
			return "redirect:notAuthorized.html";
		survey.setPedigree(pedigree);
		surveyService.saveSurvey(survey);
		if (submit.equals("Next Metric"))
			return "redirect:support.html?surveyId=" + survey.getId();
		else {
			return "redirect:evaluationSummary.html?evaluationId=" + survey.getEvaluation().getId();	
		}
	}
}
