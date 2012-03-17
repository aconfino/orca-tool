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
		survey.setScore(0);
		return survey;
	}
	
	public void createCodeDesign(Survey survey){
		CodeDesign codeDesign = new CodeDesign();
		codeDesign.populate();
		codeDesign.setSurvey(survey);
		survey.setCodeDesign(codeDesign);
	}
	
	public void createCodeRuntime(Survey survey){
		CodeRuntime codeRuntime = new CodeRuntime();
		codeRuntime.populate();
		codeRuntime.setSurvey(survey);
		survey.setCodeRuntime(codeRuntime);
	}
	
	public void createCodeStatic(Survey survey){
		CodeStatic codeStatic = new CodeStatic();
		codeStatic.populate();
		codeStatic.setSurvey(survey);
		survey.setCodeStatic(codeStatic);
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
	
	public void createSupport(Survey survey){
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
