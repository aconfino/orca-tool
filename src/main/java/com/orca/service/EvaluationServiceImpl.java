package com.orca.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.orca.dao.EvaluationDAO;
import com.orca.dao.SurveyDAO;
import com.orca.domain.Evaluation;
import com.orca.domain.Survey;

@Service
public class EvaluationServiceImpl implements EvaluationService{
	
	@Autowired
	EvaluationDAO evaluationDao;
	@Autowired
	SurveyDAO surveyDao;
	
	public Evaluation getEvaluationByNumber(Long number) {
		return evaluationDao.getEvaluationByNumber(number);
	}

	public Evaluation getEvaluationById(Integer evaluationId) {
		return evaluationDao.getEvaluationById(evaluationId);
	}

	public void saveEvaluation(Evaluation evaluation) {
		evaluationDao.saveEvaluation(evaluation);
	}

	public void removeEvaluation(Evaluation evaluation) {
		evaluationDao.removeEvaluation(evaluation);
	}
	
	public void removeSurvey(Survey survey) {
		surveyDao.removeSurvey(survey);
	}

	public Long generateNumber() {
		boolean unavailable = true;
		Long number = null;
		while (unavailable) {
			number = randomNumber().longValue();
			if (isNumberAvailable(number)) {
				unavailable = false;
			}
		}
		return number;
	}
	
	public Integer randomNumber(){
		Random random = new Random();
		return random.nextInt(1000000) + 1000000;
	}
	
	public boolean isNumberAvailable(Long number){
		Evaluation evaluation = evaluationDao.getEvaluationByNumber(number);
		if (evaluation == null) {
			return true;
		} else {
			return false;
		}
	}

	public boolean authorizedUser(Evaluation evaluation) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		if (evaluation.getUser()==null){		// evaluation doesn't belong to anyone
			return true;									// occurs during evaluation creation
		} 
		else if ((evaluation.getUser() != null) && (evaluation.getUser().getUsername().equals(username))) {
			return true;
		} else {
			return false;
		}
	}

}
