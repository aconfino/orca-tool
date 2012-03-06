package com.orca.app;


import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.orca.domain.Evaluation;
import com.orca.domain.Pedigree;
import com.orca.domain.Survey;
import com.orca.factory.EvaluationFactory;

@ContextConfiguration( locations = { "/root-context.xml" , "/controllers.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class PedigreeTests  {
	
	@Autowired
	EvaluationFactory factory;
	
	@Test
	public void calculateValueTest(){
		Pedigree pedigree = new Pedigree();
		pedigree.setAuthor(3);
		pedigree.setDerived(1);
		pedigree.setGroupSponsor(2);
		assertTrue((pedigree.getCalculatedValue()==(new Double (4))));	
	}
	
	@Test
	public void weightedValueTest(){
		Pedigree pedigree = new Pedigree();
		pedigree.setAuthor(3);
		pedigree.setDerived(1);
		pedigree.setGroupSponsor(2);
		assertTrue((pedigree.getCalculatedValue()==(new Double (4))));		
		Evaluation evaluation = factory.createEvalution();
		evaluation.setPedigreeWeight(25);
		Survey survey = evaluation.getSurveyList().get(0);
		survey.setPedigree(pedigree);
		assertTrue((pedigree.getWeightedValue(survey)==(new Double (1))));	
	}
}
