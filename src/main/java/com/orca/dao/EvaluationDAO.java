package com.orca.dao;

import com.orca.domain.Evaluation;

public interface EvaluationDAO {
	
	public Evaluation getEvaluationByNumber(Long number);
	public Evaluation getEvaluationById(Integer evaluationId);
	public void saveEvaluation(Evaluation evaluation);
	public void removeEvaluation(Evaluation evaluation);

}
