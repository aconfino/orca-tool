package com.orca.app;


import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.orca.domain.CodeStatic;
import com.orca.domain.Evaluation;
import com.orca.domain.Survey;
import com.orca.factory.EvaluationFactory;

@ContextConfiguration( locations = { "/root-context.xml", "/controllers.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class CodeStaticTests  {
	
	@Autowired
	EvaluationFactory factory;
		
	@Test
	public void calculatedValueTests(){
		CodeStatic codeStatic = new CodeStatic();
		codeStatic.setCyclomaticComplexity(5);
		codeStatic.setDependencyCycles(3);
		codeStatic.setMethodCount(2);
		assertTrue(codeStatic.getCalculatedValue()==new Double(6.66));
	}
	
	@Test
	public void weightedValueTest(){
		CodeStatic codeStatic = new CodeStatic();
		codeStatic.setCyclomaticComplexity(5);
		codeStatic.setDependencyCycles(3);
		codeStatic.setMethodCount(2);
		assertTrue(codeStatic.getCalculatedValue()==new Double(6.66));
		Evaluation evaluation = factory.createEvalution();
		evaluation.setCodeWeight(50);
		Survey survey = evaluation.getSurveyList().get(0);
		survey.setCodeStatic(codeStatic);
		assertTrue((codeStatic.getWeightedValue(survey)==(new Double (3.33))));	
	}

}
