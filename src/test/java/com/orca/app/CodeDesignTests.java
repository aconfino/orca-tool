package com.orca.app;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.orca.domain.CodeDesign;
import com.orca.domain.Evaluation;
import com.orca.domain.Survey;
import com.orca.factory.EvaluationFactory;

@ContextConfiguration( locations = { "/root-context.xml", "/controllers.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class CodeDesignTests  {
	
	@Autowired
	EvaluationFactory factory;
	
	@Test
	public void calculateValueTest(){
		CodeDesign codeDesign = new CodeDesign();
		codeDesign.setObjectOriented(3);
		codeDesign.setTestability(4);
		codeDesign.setUnderstandability(3);
		codeDesign.setExtensibility(3);
		assertTrue((codeDesign.getCalculatedValue()==(new Double (6.5))));	
	}
	
	//@Test
	public void weightedValueTest(){
		CodeDesign codeDesign = new CodeDesign();
		codeDesign.setObjectOriented(3);
		codeDesign.setTestability(4);
		codeDesign.setUnderstandability(3);
		codeDesign.setExtensibility(3);
		assertTrue((codeDesign.getCalculatedValue()==(new Double (6.5))));	
		Evaluation evaluation = factory.createEvalution();
		evaluation.setCodeWeight(50);
		Survey survey = evaluation.getSurveyList().get(0);
		survey.setCodeDesign(codeDesign);
		assertTrue((codeDesign.getWeightedValue(survey)==(new Double (3.25))));	
	}
}
