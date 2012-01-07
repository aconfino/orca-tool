package com.orca.service;

import com.orca.domain.Survey;

public interface SurveyService {
	
	public void saveSurvey(Survey survey);
	public void removeSurvey(Survey survey);
	public Survey getSurvey(Integer surveyId);
	public boolean authorizedUser(Survey survey);

}
