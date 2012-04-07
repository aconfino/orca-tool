package com.orca.web;	

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.orca.domain.Evaluation;
import com.orca.domain.Survey;
import com.orca.domain.User;
import com.orca.factory.EvaluationFactory;
import com.orca.factory.SurveyFactory;
import com.orca.service.EvaluationService;
import com.orca.service.SurveyService;

@SessionAttributes({"evaluation"})
@Controller
public class EvaluationController {
	
	@Autowired
	private EvaluationService evaluationService;
	@Autowired
	private SurveyService surveyService;
	@Autowired
	private EvaluationFactory evaluationFactory;
	@Autowired
	private SurveyFactory surveyFactory;

	
	@RequestMapping(value="beginEvaluation.html")
	public ModelAndView beginEvaluation(){
		ModelAndView mav = new ModelAndView("beginEvaluation");
		Evaluation evaluation = evaluationFactory.createEvalution();
		evaluation = associateUser(evaluation);
		mav.addObject("evaluation", evaluation);
		evaluationService.saveEvaluation(evaluation);
		return mav;
	}
	
	@RequestMapping(value="/getEvaluation.html")
	public String evaluationSummary(@RequestParam("evaluationNumber") String evaluationNumber){
		try {
			Long number = new Long(evaluationNumber);
			Evaluation evaluation = evaluationService.getEvaluationByNumber(number);
			if ( evaluation == null) {
				return "redirect:noResultsFound.html?evaluationNumber=" + evaluationNumber;	
			} else if (!evaluationService.authorizedUser(evaluation)) {
				return "redirect:notAuthorized.html";
			} else {
				return "redirect:evaluationSummary.html?evaluationId=" + evaluation.getId();
			}
		} catch (NumberFormatException e) {
			return "redirect:noResultsFound.html?evaluationNumber=" + evaluationNumber;	
		}
	}
	
	@RequestMapping(value="/continueEvaluation.html")
	public ModelAndView continueEvaluation(){
		return new ModelAndView("continueEvaluation");

	}
	
	@RequestMapping(value="/noResultsFound.html")
	public ModelAndView noResultsFound(@RequestParam("evaluationNumber") String evaluationNumber){
		return new ModelAndView("noResultsFound");
	}
	
	@RequestMapping(value="editEvaluation.html")
	public ModelAndView editEvaluation(@RequestParam("evaluationId") Integer evaluationId){
		Evaluation evaluation = evaluationService.getEvaluationById(evaluationId);
		if (!evaluationService.authorizedUser(evaluation)){
			return new ModelAndView("notAuthorized");
		}
		ModelAndView mav = new ModelAndView("editEvaluation");
		mav.addObject("evaluation", evaluation);
		evaluationService.saveEvaluation(evaluation);
		return mav;
	}
	
	@RequestMapping(value="saveEvaluation.html")
	public String saveEvaluationEdits(@ModelAttribute("evaluation") Evaluation evaluation){
		evaluation = associateUser(evaluation);
		evaluationService.saveEvaluation(evaluation);
		return "redirect:evaluationSummary.html?evaluationId=" + evaluation.getId();
	}
	
	@RequestMapping(value="/evaluationWeight.html")
	public ModelAndView evaluationWeight(@ModelAttribute("evaluation") Evaluation evaluation){
		if (!evaluationService.authorizedUser(evaluation)){
			return new ModelAndView("notAuthorized");
		}
		ModelAndView mav = new ModelAndView("evaluationWeight");
		evaluation = associateUser(evaluation);
		mav.addObject("evaluation", evaluation);
		evaluationService.saveEvaluation(evaluation);
		return mav;
	}
	
	@RequestMapping(value="/saveEvaluationWeight.html")
	public String saveEvaluationWeight(@ModelAttribute("evaluation") Evaluation evaluation,
			@RequestParam("submit") String submit){
		evaluationService.saveEvaluation(evaluation);
		if (submit.equals("Continue Survey")) {
			return "redirect:beginSurvey.html?evaluationId=" + evaluation.getId();
		} else {
			return "redirect:evaluationSummary.html?evaluationId=" + evaluation.getId();
		}
	}

	@RequestMapping(value="/evaluationSummary.html")
	public ModelAndView evaluationSummary(@RequestParam("evaluationId") Integer evaluationId){
		Evaluation evaluation = evaluationService.getEvaluationById(evaluationId);
		if (!evaluationService.authorizedUser(evaluation)){
			return new ModelAndView("notAuthorized");
		}
		ModelAndView mav = new ModelAndView("evaluationSummary");
		List <Survey> surveyList = evaluation.getSurveyList();
		mav.addObject("evaluation", evaluation);			
		mav.addObject("surveyList", surveyList);
		return mav;
	}
	
	@RequestMapping(value="addSurvey.html")
	public String addSurvey(@RequestParam("evaluationId") Integer evaluationId){
		Evaluation evaluation = evaluationService.getEvaluationById(evaluationId);
		if (!evaluationService.authorizedUser(evaluation)){
			return "redirect:myAccount.html";			
		}
		Survey survey = surveyFactory.newInstance(evaluation);
		evaluation.getSurveyList().add(survey);
		evaluationService.saveEvaluation(evaluation);
		return "redirect:surveyName.html?surveyId=" + survey.getId();
	}
	
	@RequestMapping(value="removeSurvey.html")
	public ModelAndView removeSurvey(@RequestParam("surveyId") Integer surveyId){
		ModelAndView mav = new ModelAndView("removeSurveyConfirm");
		Survey survey = surveyService.getSurvey(surveyId);
		mav.addObject("survey", survey);
		return mav;
	}
	
	@RequestMapping(value="removeSurveyConfirmed.html")
	public String removeSurveyConfirm(@RequestParam("surveyId") Integer surveyId){
		Evaluation evaluation = surveyService.getSurvey(surveyId).getEvaluation();
		if (!evaluationService.authorizedUser(evaluation)){
			return "redirect:myAccount.html";		
		}
		List <Survey> surveyList = evaluation.getSurveyList();
		for (Survey survey : surveyList){
			if (survey.getId().equals(new Integer(surveyId))){
				evaluationService.removeSurvey(survey);
			}
		}
		return "redirect:evaluationSummary.html?evaluationId=" + evaluation.getId();
	}
	
	@RequestMapping(value="removeEvaluation.html")
	public ModelAndView removeEvaluation(@RequestParam("evaluationId") Integer evaluationId){
		ModelAndView mav = new ModelAndView("removeEvaluationConfirm");
		Evaluation evaluation = evaluationService.getEvaluationById(evaluationId);
		mav.addObject("evaluation", evaluation);
		return mav;
	}
	
	@RequestMapping(value="removeEvaluationConfirmed.html")
	public String removeEvaluationConfirmed(@RequestParam("evaluationId") Integer evaluationId){
		Evaluation evaluation = evaluationService.getEvaluationById(evaluationId);
		if (evaluationService.authorizedUser(evaluation)){
			evaluationService.removeEvaluation(evaluation);	
		}
		return "redirect:myAccount.html";		
	}
	
	@RequestMapping(value="notAuthorized")
	public ModelAndView notAuthorized(){
		return new ModelAndView("notAuthorized");
	}
	
	public Evaluation associateUser(Evaluation evaluation){
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		if ((!username.equals("anonymousUser") && (evaluation.getUser() == null))){
			User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			evaluation.setUser(user);
		}
		return evaluation;
	}
}
