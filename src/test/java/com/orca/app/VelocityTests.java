package com.orca.app;


import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.orca.domain.Evaluation;
import com.orca.domain.Survey;
import com.orca.domain.Velocity;
import com.orca.factory.EvaluationFactory;

@ContextConfiguration( locations = { "/root-context.xml" , "/controllers.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class VelocityTests  {
	
	@Autowired
	EvaluationFactory factory;
			
	@Test
	public void getCalculatedValueTest(){
		Velocity velocity = new Velocity();
		velocity.setFeatureActual(3);
		velocity.setPatchActual(4);
		assertTrue(velocity.getCalculatedValue()==(new Double(7)));
	}
	
	@Test
	public void weightedValueTest(){
		Velocity velocity = new Velocity();
		velocity.setFeatureActual(3);
		velocity.setPatchActual(4);
		assertTrue(velocity.getCalculatedValue()==(new Double(7)));	
		Evaluation evaluation = factory.createEvalution();
		evaluation.setVelocityWeight(50);
		Survey survey = evaluation.getSurveyList().get(0);
		survey.setVelocity(velocity);
		assertTrue((velocity.getWeightedValue(survey)==(new Double (3.5))));	
	}

}
