package com.orca.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.orca.domain.Evaluation;
import com.orca.domain.Survey;
import com.orca.factory.SurveyFactory;
import com.orca.service.EvaluationService;
import com.orca.service.SurveyService;

@SessionAttributes({ "survey" })
@Controller
public class SurveyController {

	@Autowired
	EvaluationService evaluationService;
	@Autowired
	SurveyService surveyService;
	@Autowired
	SurveyFactory factory;

	@RequestMapping(value = "beginSurvey.html")
	public String beginSurvey(@RequestParam("evaluationId") Integer evaluationId) {
		Evaluation evaluation = evaluationService.getEvaluationById(evaluationId);
		if (!evaluationService.authorizedUser(evaluation))
			return "redirect:notAuthorized";
		return "redirect:surveyName.html?surveyId=" + evaluation.getSurveyList().get(0).getId();
	}
	
	@RequestMapping(value = "surveyName.html")
	public ModelAndView surveyName(@RequestParam("surveyId") Integer surveyId){
		Survey survey = surveyService.getSurvey(surveyId);
		if (!surveyService.authorizedUser(survey))
			return new ModelAndView("notAuthorized");
		ModelAndView mav = new ModelAndView("surveyName");
		mav.addObject("survey", survey);
		return mav;
	}
	
	@RequestMapping(value = "saveSurveyName.html")
	public String saveSurveyName(@ModelAttribute("survey") Survey survey, @RequestParam("submit") String submit){
		if (!surveyService.authorizedUser(survey))
			return "redirect:notAuthorized.html";
		surveyService.saveSurvey(survey);
		if (submit.equals("Begin Metrics")) {
	        return "redirect:codeDesign.html?surveyId=" + survey.getId();
		} else {
			return "redirect:evaluationSummary.html?evaluationId=" + survey.getEvaluation().getId();	
		}
	}
	
	@RequestMapping(value = "surveyComments.html")
	public ModelAndView comments(@RequestParam("surveyId") Integer surveyId){
		Survey survey = surveyService.getSurvey(surveyId);
		if (!surveyService.authorizedUser(survey))
			return new ModelAndView("notAuthorized");
		ModelAndView mav = new ModelAndView("surveyComments");
		mav.addObject("survey", survey);
		return mav;
	}
	
	@RequestMapping(value = "saveSurveyComments.html")
	public String saveSurveyComment(@ModelAttribute("survey") Survey survey, @RequestParam("submit") String submit){
		if (!surveyService.authorizedUser(survey))
			return "redirect:notAuthorized.html";
		surveyService.saveSurvey(survey);
		return "redirect:evaluationSummary.html?evaluationId=" + survey.getEvaluation().getId();	
	}
}
