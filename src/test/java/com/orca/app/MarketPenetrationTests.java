package com.orca.app;


import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.orca.domain.Evaluation;
import com.orca.domain.MarketPenetration;
import com.orca.domain.Survey;
import com.orca.factory.EvaluationFactory;

@ContextConfiguration( locations = { "/root-context.xml" , "/controllers.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class MarketPenetrationTests  {
	
	@Autowired
	EvaluationFactory factory;
	
	@Test
	public void calculateValueTest(){
		MarketPenetration market = new MarketPenetration();
		market.setMarketPenetrationScore(2);
		assertTrue((market.getCalculatedValue()==(new Double (4))));	
	}
	
	@Test
	public void weightedValueTest(){
		MarketPenetration market = new MarketPenetration();
		market.setMarketPenetrationScore(2);
		assertTrue((market.getCalculatedValue()==(new Double (4))));	
		Evaluation evaluation = factory.createEvalution();
		evaluation.setMarketWeight(100);
		Survey survey = evaluation.getSurveyList().get(0);
		survey.setMarketPenetration(market);
		assertTrue((market.getWeightedValue(survey)==(new Double (4))));	
	}
}
