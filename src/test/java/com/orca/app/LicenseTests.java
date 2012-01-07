package com.orca.app;


import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.orca.domain.Evaluation;
import com.orca.domain.License;
import com.orca.domain.Survey;
import com.orca.factory.EvaluationFactory;

@ContextConfiguration( locations = { "/root-context.xml" , "/controllers.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class LicenseTests  {
	
	@Autowired
	EvaluationFactory factory;
	
	@Test
	public void calculatedValueTests(){
		License license = new License();
		license.populate();
		assertTrue(license.getCalculatedValue()==new Double(10));
	}
	
	@Test
	public void weightedValueTest(){
		License license = new License();
		license.populate();
		assertTrue(license.getCalculatedValue()==new Double(10));
		Evaluation evaluation = factory.createEvalution();
		evaluation.setCodeWeight(50);
		Survey survey = evaluation.getSurveyList().get(0);
		survey.setLicense(license);
		assertTrue((license.getWeightedValue(survey)==(new Double (5))));	
	}

}
