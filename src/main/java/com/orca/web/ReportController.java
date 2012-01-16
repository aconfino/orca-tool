package com.orca.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.orca.domain.Evaluation;
import com.orca.domain.Report;
import com.orca.form.ReportForm;
import com.orca.service.EvaluationService;
import com.orca.service.SurveyService;

@Controller
public class ReportController {
	
	@Autowired
	SurveyService surveyService;
	@Autowired
	EvaluationService evaluationService;
	
	@RequestMapping(value="reportSummary.html")
	public ModelAndView reportSummary(@ModelAttribute("reportForm") ReportForm reportForm){
		Evaluation evaluation = evaluationService.getEvaluationById(reportForm.getEvaluationId());
		if (!evaluationService.authorizedUser(evaluation))
			return new ModelAndView("notAuthorized");
		ModelAndView mav = new ModelAndView("reportSummary");
		mav.addObject("report", populateReport(reportForm));
		mav.addObject("surveyList", evaluationService.getEvaluationById(reportForm.getEvaluationId()).getSurveyList());
		mav.addObject("evaluation", evaluation);
		return mav;
	}
	
	public Report populateReport(ReportForm reportForm){
		Report report = new Report();
		report.setType(reportForm.getType());
		report.setFirstSurvey(surveyService.getSurvey(reportForm.getFirstSurveyId()));
		report.setSecondSurvey(surveyService.getSurvey(reportForm.getSecondSurveyId()));
		report.setThirdSurvey(surveyService.getSurvey(reportForm.getThirdSurveyId()));
		report.setFourthSurvey(surveyService.getSurvey(reportForm.getFourthSurveyId()));
		report = generateReportQuantity(report);
		return report;
	}
	
	public Report generateReportQuantity (Report report){
		int count = 0;
		if (report.getFirstSurvey() != null)
			count++;
		if (report.getSecondSurvey() != null)
			count++;
		if (report.getThirdSurvey() != null)
			count++;
		if(report.getFourthSurvey() != null)
			count++;
		report.setQuantity(count);
		return report;
	}
}
