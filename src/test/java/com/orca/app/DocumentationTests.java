package com.orca.app;


import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.orca.domain.Community;
import com.orca.domain.Documentation;
import com.orca.domain.Evaluation;
import com.orca.domain.Survey;
import com.orca.factory.EvaluationFactory;

@ContextConfiguration( locations = { "/root-context.xml", "/controllers.xml"  })
@RunWith(SpringJUnit4ClassRunner.class)
public class DocumentationTests  {
	
	@Autowired
	EvaluationFactory factory;
	
	@Test
	public void calculatedValueTests(){
		Documentation documentation = new Documentation();
		documentation.setAdministrationDocumentation(2);
		documentation.setCodeComments(1);
		documentation.setDeveloperDocumentation(4);
		documentation.setInstallationDocumentation(5);
		documentation.setUserDocumentation(3);
		assertTrue(documentation.getCalculatedValue()==new Double(6));
	}
	
	@Test
	public void weightedValueTest(){
		Community community = new Community();
		community.setBugTracker(1);
		community.setMailingList(3);
		community.setWebsite(4);
		assertTrue(community.getCalculatedValue()==new Double(5.34));
		Evaluation evaluation = factory.createEvalution();
		evaluation.setCodeWeight(50);
		Survey survey = evaluation.getSurveyList().get(0);
		survey.setCommunity(community);
		assertTrue((community.getWeightedValue(survey)==(new Double (2.67))));	
	}

}
