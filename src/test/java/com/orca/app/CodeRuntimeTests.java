package com.orca.app;


import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.orca.domain.CodeRuntime;
import com.orca.domain.Evaluation;
import com.orca.domain.Survey;
import com.orca.factory.EvaluationFactory;

@ContextConfiguration( locations = { "/root-context.xml", "/controllers.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class CodeRuntimeTests  {
	
	@Autowired
	EvaluationFactory factory;
	
	@Test
	public void getCalculatedValue(){
		CodeRuntime runtime = new CodeRuntime();
		runtime.setCpuThreshhold(1);
		runtime.setIOThreshhold(3);
		runtime.setMemoryThreshhold(4);
		assertTrue(runtime.getCalculatedValue()== (new Double(5.34)));
	}
	
	@Test
	public void weightedValueTest(){
		CodeRuntime runtime = new CodeRuntime();
		runtime.setCpuThreshhold(1);
		runtime.setIOThreshhold(3);
		runtime.setMemoryThreshhold(4);
		assertTrue(runtime.getCalculatedValue()== (new Double(5.34)));
		Evaluation evaluation = factory.createEvalution();
		evaluation.setCodeWeight(50);
		Survey survey = evaluation.getSurveyList().get(0);
		survey.setCodeRuntime(runtime);
		assertTrue((runtime.getWeightedValue(survey)==(new Double (2.67))));	
	}

}
