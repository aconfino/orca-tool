package com.orca.service;

import com.orca.domain.Evaluation;
import com.orca.domain.Survey;

public interface EvaluationService {
	
	public Long generateNumber();
	public boolean isNumberAvailable(Long number);
	public Evaluation getEvaluationByNumber(Long number);
	public Evaluation getEvaluationById(Integer evaluationId);
	public void saveEvaluation(Evaluation evaluation);
	public void removeEvaluation(Evaluation evaluation);
	public void removeSurvey(Survey survey);
	public boolean authorizedUser(Evaluation evaluation);
	
}
