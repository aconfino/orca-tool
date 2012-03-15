package com.orca.selenium.tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.orca.page.objects.BeginEvaluation;
import com.orca.page.objects.CodeDesign;
import com.orca.page.objects.CodeRuntime;
import com.orca.page.objects.CodeStatic;
import com.orca.page.objects.Comments;
import com.orca.page.objects.Community;
import com.orca.page.objects.Documentation;
import com.orca.page.objects.EditEvaluation;
import com.orca.page.objects.EvaluationSummary;
import com.orca.page.objects.EvaluationWeight;
import com.orca.page.objects.Functionality;
import com.orca.page.objects.Home;
import com.orca.page.objects.License;
import com.orca.page.objects.MarketPenetration;
import com.orca.page.objects.Pedigree;
import com.orca.page.objects.Support;
import com.orca.page.objects.SurveyName;
import com.orca.page.objects.Velocity;
import com.orca.selenium.utils.TestUtils;

public class EvaluationIntegration {
		
		private Home homePage;
		private BeginEvaluation beginEvaluation;
		private EditEvaluation editEvaluation;
		private EvaluationWeight evaluationWeight;
		private SurveyName surveyName;
		private CodeDesign codeDesign;
		private CodeRuntime codeRuntime;
		private CodeStatic codeStatic;
		private Community community;
		private Documentation documentation;
		private License license;
		private MarketPenetration marketPenetration;
		private Pedigree pedigree;
		private Support support;
		private Velocity velocity;
		private Functionality functionality;
		private Comments comments;
		private EvaluationSummary evaluationSummary;
		WebDriver driver;
		
		@Before
		public void openTheBrowser() throws IOException {
			driver = TestUtils.getFirefoxDriver();
			homePage = PageFactory.initElements(driver, Home.class);
			homePage.open();
		}

		@After
		public void closeTheBrowser() {
			driver.quit();
		}
		
		@Test
		public void createEvaluation() {
			beginEvaluation = homePage.beginEvaluation();
			evaluationWeight = beginEvaluation.createEvaluation();
			surveyName = evaluationWeight.continueEvaluation();
			codeDesign = surveyName.continueEvaluation();
			codeRuntime = codeDesign.continueSurvey();
			codeStatic = codeRuntime.continueSurvey();
			community = codeStatic.continueSurvey();
			documentation = community.continueSurvey();
			license = documentation.continueSurvey();
			marketPenetration = license.continueSurvey();
			pedigree = marketPenetration.continueSurvey();
			support = pedigree.continueSurvey();
			velocity = support.continueSurvey();
			functionality = velocity.continueSurvey();
			comments = functionality.continueSurvey();
			evaluationSummary = comments.finishSurvey();
			assertTrue(evaluationSummary.pageContains("Evaluation Summary"));
		}
		
		@Test
		public void evaluationSubMenu() {
			beginEvaluation = homePage.beginEvaluation();
			beginEvaluation= beginEvaluation.getSubmenu().createNewEvaluation();
			editEvaluation = beginEvaluation.getSubmenu().editEvaluation();
			evaluationSummary = editEvaluation.getSubmenu().goToSummary();
			assertTrue(evaluationSummary.pageContains("Evaluation Summary"));
		}
		
		/*
		 * Note that the moveSlider methods take xAxis pixels
		 * as their argument, not the final value of the slider.
		 */
		
		@Test
		public void editEvaluationWeight(){
			String name = "Updated Evaluation Name";
			String functionalityWeight = "Functionality weight: 55";
			String codeWeight = "Code weight: 58";
			String communityWeight = "Community weight: 60";	
			String documentationWeight = "Documentation weight: 63";
			String licenseWeight = "License weight: 65";
			String marketWeight = "Market weight: 68";
			String pedigreeWeight = "Pedigree weight: 70";
			String supportWeight = "Support weight: 73";
			String velocityWeight = "Velocity weight: 75";
			beginEvaluation = homePage.beginEvaluation();
			evaluationSummary = beginEvaluation.getSubmenu().goToSummary();
			editEvaluation = evaluationSummary.editEvaluation();
			editEvaluation.editName(name);
			editEvaluation.moveFunctionalitySlider(20);
			editEvaluation.moveCodeSlider(30);
			editEvaluation.moveCommunitySlider(40);
			editEvaluation.moveDocumentationSlider(50);
			editEvaluation.moveLicenseSlider(60);
			editEvaluation.moveMarketSlider(70);
			editEvaluation.movePedigreeSlider(80);
			editEvaluation.moveSupportSlider(90);
			editEvaluation.moveVelocitySlider(100);
			evaluationSummary = editEvaluation.saveAndGoToSummary();
			assertTrue(evaluationSummary.pageContains(name));
			assertTrue(evaluationSummary.pageContains(functionalityWeight));
			assertTrue(evaluationSummary.pageContains(codeWeight));
			assertTrue(evaluationSummary.pageContains(communityWeight));
			assertTrue(evaluationSummary.pageContains(documentationWeight));
			assertTrue(evaluationSummary.pageContains(licenseWeight));
			assertTrue(evaluationSummary.pageContains(marketWeight));
			assertTrue(evaluationSummary.pageContains(pedigreeWeight));
			assertTrue(evaluationSummary.pageContains(supportWeight));
			assertTrue(evaluationSummary.pageContains(velocityWeight));			
		}

}
