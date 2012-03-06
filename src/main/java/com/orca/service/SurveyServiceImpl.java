package com.orca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orca.dao.SurveyDAO;
import com.orca.domain.Survey;

@Service
public class SurveyServiceImpl implements SurveyService{
	
	@Autowired
	SurveyDAO dao;
	@Autowired
	EvaluationService evaluationService;

	public void saveSurvey(Survey survey) {
		dao.saveSurvey(survey);
	}
	
	public void removeSurvey(Survey survey){
		dao.removeSurvey(survey);
	}

	public Survey getSurvey(Integer surveyId) {
		return dao.getSurvey(surveyId);
	}

	public boolean authorizedUser(Survey survey) {
		return evaluationService.authorizedUser(survey.getEvaluation());
	}
}
