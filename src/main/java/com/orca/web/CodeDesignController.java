package com.orca.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.orca.domain.CodeDesign;
import com.orca.domain.Survey;
import com.orca.service.SurveyService;

@SessionAttributes({ "codeDesign" })
@Controller
public class CodeDesignController {

	@Autowired
	SurveyService surveyService;

	@RequestMapping(value = "codeDesign.html")
	public ModelAndView codeDesign(@RequestParam("surveyId") Integer surveyId) {
		Survey survey = surveyService.getSurvey(surveyId);
		if (!surveyService.authorizedUser(survey))
			return new ModelAndView("notAuthorized");
		ModelAndView mav = new ModelAndView("codeDesign");	
		mav.addObject("codeDesign", survey.getCodeDesign());
		return mav;	
	}
	
	@RequestMapping(value = "saveCodeDesign.html")
	public String saveCodeDesign(@ModelAttribute("codeDesign") CodeDesign codeDesign, 
			@RequestParam("surveyId") Integer surveyId, @RequestParam("submit") String submit) {
		Survey survey = surveyService.getSurvey(surveyId);
		if (!surveyService.authorizedUser(survey))
			return "redirect:notAuthorized.html";
		survey.setCodeDesign(codeDesign);
		surveyService.saveSurvey(survey);
		if (submit.equals("Next Metric"))
	        return "redirect:codeRuntime.html?surveyId=" + survey.getId();
		else {
			return "redirect:evaluationSummary.html?evaluationId=" + survey.getEvaluation().getId();	
		}
	}

}
