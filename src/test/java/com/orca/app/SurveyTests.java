package com.orca.app;


import static org.junit.Assert.assertTrue;

import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.orca.domain.Evaluation;
import com.orca.domain.Functionality;
import com.orca.domain.Survey;
import com.orca.factory.EvaluationFactory;

@ContextConfiguration( locations = { "/root-context.xml" , "/controllers.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class SurveyTests  {
	
	@Autowired
	EvaluationFactory factory;
			
	@Test
	public void surveyScoreTest(){
		Evaluation evaluation = factory.createEvalution();
		Survey survey = evaluation.getSurveyList().get(0);
		evaluation.setCodeWeight(50);  // sets weight for CodeDesign, CodeRuntime, and CodeStatic
		assertTrue(survey.getScore()==61.0);
	}
	

}
