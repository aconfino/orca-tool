package com.orca.factory;

import org.springframework.stereotype.Service;

import com.orca.domain.CodeDesign;
import com.orca.domain.CodeRuntime;
import com.orca.domain.CodeStatic;
import com.orca.domain.Community;
import com.orca.domain.Documentation;
import com.orca.domain.Evaluation;
import com.orca.domain.Functionality;
import com.orca.domain.License;
import com.orca.domain.MarketPenetration;
import com.orca.domain.Pedigree;
import com.orca.domain.Support;
import com.orca.domain.Survey;
import com.orca.domain.Velocity;

@Service
public class SurveyFactory {

	public Survey newInstance(Evaluation evaluation) {
		Survey survey = new Survey();
		survey.setSurveyName("Sample Survey");
		survey.setComments("No comments");
		createCodeDesign(survey);
		createCodeRuntime(survey);
		createCodeStatic(survey);
		createCommunity(survey);
		createDocumentation(survey);
		createLicense(survey);
		createMarketPenetration(survey);
		createSupport(survey);
		createPedigree(survey);
		createVelocity(survey);
	    createFunctionality(survey);
		survey.setEvaluation(evaluation);
		return survey;
	}
	
	public void createCodeDesign(Survey survey){
		CodeDesign cd = new CodeDesign();
		cd.populate();
		cd.setSurvey(survey);
		survey.setCodeDesign(cd);
	}
	
	public void createCodeRuntime(Survey survey){
		CodeRuntime cr = new CodeRuntime();
		cr.populate();
		cr.setSurvey(survey);
		survey.setCodeRuntime(cr);
	}
	
	public void createCodeStatic(Survey survey){
		CodeStatic cs = new CodeStatic();
		cs.populate();
		cs.setSurvey(survey);
		survey.setCodeStatic(cs);
	}
	
	public void createCommunity(Survey survey){
		Community community = new Community();
		community.populate();
		community.setSurvey(survey);
		survey.setCommunity(community);
	}
	
	public void createDocumentation(Survey survey){
		Documentation documentation = new Documentation();
		documentation.populate();
		documentation.setSurvey(survey);
		survey.setDocumentation(documentation);
	}
	
	public void createLicense(Survey survey){
		License license = new License();
		license.populate();
		license.setSurvey(survey);
		survey.setLicense(license);
	}
	
	public void createMarketPenetration(Survey survey){
		MarketPenetration marketPenetration = new MarketPenetration();
		marketPenetration.populate();
		marketPenetration.setSurvey(survey);
		survey.setMarketPenetration(marketPenetration);
	}
	
	public void createPedigree(Survey survey){
		Pedigree pedigree = new Pedigree();
		pedigree.populate();
		pedigree.setSurvey(survey);
		survey.setPedigree(pedigree);
	}
	
	public static void createSupport(Survey survey){
		Support support = new Support();
		support.populate();
		support.setSurvey(survey);
		survey.setSupport(support);
	}
	
	public void createVelocity(Survey survey){
		Velocity velocity = new Velocity();
		velocity.populate();
		velocity.setSurvey(survey);
		survey.setVelocity(velocity);
	}
	
	public void createFunctionality(Survey survey){
		Functionality functionality = new Functionality();
		functionality.populate();
		functionality.setSurvey(survey);
		survey.setFunctionality(functionality);
	}

}
