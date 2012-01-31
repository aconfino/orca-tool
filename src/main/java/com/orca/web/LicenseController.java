package com.orca.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.orca.domain.License;
import com.orca.domain.Survey;
import com.orca.service.SurveyService;

@SessionAttributes({ "license" })
@Controller
public class LicenseController {
	
	@Autowired
	SurveyService surveyService;

	@RequestMapping(value = "license.html")
	public ModelAndView license(@RequestParam("surveyId") Integer surveyId) {
		Survey survey = surveyService.getSurvey(surveyId);
		if (!surveyService.authorizedUser(survey))
			return new ModelAndView("notAuthorized");
		ModelAndView mav = new ModelAndView("license");
		mav.addObject("license", survey.getLicense());
		mav.addObject("survey", survey);
		return mav;
	}
	
	@RequestMapping(value = "saveLicense.html")
	public String saveLicense(@ModelAttribute("license") License license, 
			@RequestParam("surveyId") Integer surveyId, @RequestParam("submit") String submit) {
		Survey survey = surveyService.getSurvey(surveyId);
		if (!surveyService.authorizedUser(survey))
			return "redirect:notAuthorized.html";
		survey.setLicense(license);
		surveyService.saveSurvey(survey);
		if (submit.equals("Next Metric"))
			return "redirect:marketPenetration.html?surveyId=" + survey.getId();
		else {
			return "redirect:evaluationSummary.html?evaluationId=" + survey.getEvaluation().getId();	
		}
	}
}
