package com.orca.dao;

import com.orca.domain.Survey;

public interface SurveyDAO {

	public void saveSurvey(Survey survey);
	public void removeSurvey(Survey survey);
	public Survey getSurvey(Integer surveyId);
	
}
