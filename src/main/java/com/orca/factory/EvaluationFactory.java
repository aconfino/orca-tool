package com.orca.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orca.domain.Evaluation;
import com.orca.domain.Survey;
import com.orca.service.EvaluationService;

@Service
public class EvaluationFactory {

	@Autowired
	EvaluationService service;
	@Autowired
	SurveyFactory surveyFactory;

	public Evaluation createEvalution() {
		Evaluation evaluation = new Evaluation();
		evaluation.populate();
		Survey survey = surveyFactory.newInstance(evaluation);
		evaluation.addSurvey(survey);
		evaluation.setNumber(service.generateNumber());
		return evaluation;
	}

}
