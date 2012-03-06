package com.orca.app;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.orca.domain.Evaluation;
import com.orca.domain.Survey;
import com.orca.factory.EvaluationFactory;
import com.orca.service.EvaluationService;

@ContextConfiguration( locations = { "/root-context.xml", "/db-config.xml", "/controllers.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class EvaluationTests  {
	
	@Autowired
	EvaluationService service;
	@Autowired
	EvaluationFactory factory;
	Evaluation evaluation;
	Evaluation secondEvaluation;
	Date date = new Date();
	
	@Before
	public void setup(){
	    evaluation = factory.createEvalution();
		evaluation.setName("Test Evaluation " + date.toString());
		Survey survey = evaluation.getSurveyList().get(0);
		survey.setSurveyName("Test Survey " + date.toString());
	}
	
	@Test
	public void saveEvaluationTest(){
		service.saveEvaluation(evaluation);
		service.removeEvaluation(evaluation);
	}
	
	@Test
	public void numberUnavailable(){
		service.saveEvaluation(evaluation);
		Long number = evaluation.getNumber();
		assertFalse(service.isNumberAvailable(number));
	}
	
	@Test
	public void numberAvailable(){
		service.saveEvaluation(evaluation);
		Long number = evaluation.getNumber() + 1;
		assertTrue(service.isNumberAvailable(number));
	}
	
	@Test 
	public void removeEvaluationTest(){
		service.saveEvaluation(evaluation);
		service.removeEvaluation(evaluation);
		Evaluation newEvaluation = service.getEvaluationByNumber(evaluation.getNumber());
		assertTrue(newEvaluation == null);
	}
	
	@Test
	public void getEvaluationTest(){
		service.saveEvaluation(evaluation);
		Evaluation newEvaluation = service.getEvaluationByNumber(evaluation.getNumber());
		Survey survey = newEvaluation.getSurveyList().get(0);
		assertTrue(newEvaluation.getName().equals("Test Evaluation " + date.toString()));
		assertTrue(survey.getSurveyName().equals("Test Survey " + date.toString()));
		assertTrue(survey.getCodeDesign().getExtensibility() != null);
		assertTrue(survey.getCodeDesign().getObjectOriented() != null);
		assertTrue(survey.getCodeDesign().getTestability() != null);
		assertTrue(survey.getCodeDesign().getSurvey() != null);
		assertTrue(survey.getCodeRuntime().getSurvey() != null);
		assertTrue(survey.getCodeRuntime().getCpuThreshhold() != null);
		assertTrue(survey.getCodeRuntime().getIOThreshhold() != null);
		assertTrue(survey.getCodeRuntime().getMemoryThreshhold() != null);
		assertTrue(survey.getCodeStatic().getCyclomaticComplexity() != null);
		assertTrue(survey.getCodeStatic().getDependencyCycles() != null);
		assertTrue(survey.getCodeStatic().getMethodCount() != null);
		assertTrue(survey.getCodeStatic().getSurvey() != null);
		assertTrue(survey.getCommunity().getMailingList() != null);
		assertTrue(survey.getCommunity().getSurvey() != null);
		assertTrue(survey.getCommunity().getWebsite() != null);
		assertTrue(survey.getDocumentation().getAdministrationDocumentation() != null);
		assertTrue(survey.getDocumentation().getCodeComments() != null);
		assertTrue(survey.getDocumentation().getDeveloperDocumentation() != null);
		assertTrue(survey.getDocumentation().getInstallationDocumentation() != null);
		assertTrue(survey.getDocumentation().getSurvey() != null);
		assertTrue(survey.getDocumentation().getUserDocumentation() != null);
		assertTrue(survey.getLicense().getLicenseName() != null);
		assertTrue(survey.getLicense().getSurvey() != null);
		assertTrue(survey.getLicense().getAcceptable() != null);
		assertTrue(survey.getMarketPenetration().getMarketPenetrationScore() != null);
		assertTrue(survey.getMarketPenetration().getSurvey() != null);
		assertTrue(survey.getPedigree().getDerived() != null);
		assertTrue(survey.getPedigree().getGroupSponsor() != null);
		assertTrue(survey.getPedigree().getSurvey() != null);
		assertTrue(survey.getSupport().getCommercialSupport() != null);
		assertTrue(survey.getSupport().getCommunitySupport() != null);
		assertTrue(survey.getSupport().getIndemnification() != null);
		assertTrue(survey.getSupport().getSurvey() != null);
		assertTrue(survey.getVelocity().getFeatureActual() != null);
		assertTrue(survey.getVelocity().getPatchActual() != null);
		assertTrue(survey.getVelocity().getSurvey() != null);
		service.removeEvaluation(evaluation);
	}
	
}
