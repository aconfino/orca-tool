package com.orca.app;


import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.orca.domain.Evaluation;
import com.orca.domain.Support;
import com.orca.domain.Survey;
import com.orca.factory.EvaluationFactory;

@ContextConfiguration( locations = { "/root-context.xml" , "/controllers.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class SupportTests  {
	
	@Autowired
	EvaluationFactory factory;
	
	@Test
	public void calculateValueTest(){
		Support support = new Support();
		support.setCommercialSupport(3);
		support.setCommunitySupport(3);
		support.setIndemnification(4);
		assertTrue(support.getCalculatedValue() == (new Double(6.66)));	
	}
	
	@Test
	public void weightedValueTest(){
		Support support = new Support();
		support.setCommercialSupport(3);
		support.setCommunitySupport(3);
		support.setIndemnification(4);
		assertTrue(support.getCalculatedValue() == (new Double(6.66)));		
		Evaluation evaluation = factory.createEvalution();
		evaluation.setSupportWeight(75);
		Survey survey = evaluation.getSurveyList().get(0);
		survey.setSupport(support);
		assertTrue((support.getWeightedValue(survey)==(new Double (5))));	
	}
}
