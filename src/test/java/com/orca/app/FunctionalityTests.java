package com.orca.app;


import static org.junit.Assert.assertTrue;

import org.junit.Test;
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
public class FunctionalityTests  {
	
	@Autowired
	EvaluationFactory factory;
			
	@Test
	public void getCalculatedValueTest(){
		Functionality functionality = new Functionality();
		functionality.setFeatureScore(5);
		assertTrue(functionality.getCalculatedValue()==(new Double(10)));
	}
	
	@Test
	public void weightedValueTest(){
		Functionality functionality = new Functionality();
		functionality.setFeatureScore(5);
		assertTrue(functionality.getCalculatedValue()==(new Double(10)));
		Evaluation evaluation = factory.createEvalution();
		evaluation.setFunctionalityWeight(75);
		Survey survey = evaluation.getSurveyList().get(0);
		survey.setFunctionality(functionality);
		assertTrue((functionality.getWeightedValue(survey)==(new Double (7.50))));	
	}

}
