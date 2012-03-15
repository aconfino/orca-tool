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
import com.orca.page.objects.Community;
import com.orca.page.objects.Documentation;
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

public class MetricsIntegration {
		
		private Home homePage;
		private BeginEvaluation beginEvaluation;
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
		
		/*
		 * Note that the setMetrics methods take xAxis pixels
		 * as their argument, not the final value of the slider.
		 */
		
		@Test
		public void codeDesignTest() {
			 beginEvaluation = homePage.beginEvaluation();
			 evaluationWeight = beginEvaluation.createEvaluation();
			 surveyName = evaluationWeight.continueEvaluation();
			 codeDesign = surveyName.getSubmenu().goToCodeDesign();
			 codeDesign.setMetrics(100);
			 evaluationSummary = codeDesign.goToSummary();
			assertTrue(evaluationSummary.pageContains("Code Design: 8.0"));
			codeDesign = evaluationSummary.editCodeDesign();
			codeDesign.setMetrics(-100);
			evaluationSummary = codeDesign.goToSummary();
			assertTrue(evaluationSummary.pageContains("Code Design: 2.0"));
		}
		
		@Test
		public void codeRuntimeTest() {
			 beginEvaluation = homePage.beginEvaluation();
			 evaluationWeight = beginEvaluation.createEvaluation();
			 surveyName = evaluationWeight.continueEvaluation();
			 codeRuntime = surveyName.getSubmenu().goToCodeRuntime();
			 codeRuntime.setMetrics(100);
			 evaluationSummary = codeRuntime.goToSummary();
			assertTrue(evaluationSummary.pageContains("Code Runtime: 8.0"));
			codeRuntime = evaluationSummary.editCodeRuntime();
			codeRuntime.setMetrics(-100);
			evaluationSummary = codeRuntime.goToSummary();
			assertTrue(evaluationSummary.pageContains("Code Runtime: 2.0"));
		}
		
		@Test
		public void codeStaticTest() {
			 beginEvaluation = homePage.beginEvaluation();
			 evaluationWeight = beginEvaluation.createEvaluation();
			 surveyName = evaluationWeight.continueEvaluation();
			 codeStatic = surveyName.getSubmenu().goToCodeStatic();
			 codeStatic.setMetrics(100);
			 evaluationSummary = codeStatic.goToSummary();
			assertTrue(evaluationSummary.pageContains("Code Static: 8.0"));
			codeStatic = evaluationSummary.editCodeStatic();
			codeStatic.setMetrics(-100);
			evaluationSummary = codeStatic.goToSummary();
			assertTrue(evaluationSummary.pageContains("Code Static: 2.0"));
		}
		
		@Test
		public void communityTest() {
			 beginEvaluation = homePage.beginEvaluation();
			 evaluationWeight = beginEvaluation.createEvaluation();
			 surveyName = evaluationWeight.continueEvaluation();
			 community = surveyName.getSubmenu().goToCommunity();
			 community.setMetrics(100);
			 evaluationSummary = community.goToSummary();
			assertTrue(evaluationSummary.pageContains("Community: 8.0"));
			community = evaluationSummary.editCommunity();
			community.setMetrics(-100);
			evaluationSummary = community.goToSummary();
			assertTrue(evaluationSummary.pageContains("Community: 2.0"));
		}

	    @Test
		public void documentationTest() {
			 beginEvaluation = homePage.beginEvaluation();
			 evaluationWeight = beginEvaluation.createEvaluation();
			 surveyName = evaluationWeight.continueEvaluation();
			 documentation = surveyName.getSubmenu().goToDocumentation();
			 documentation.setMetrics(100);
			 evaluationSummary = documentation.goToSummary();
			assertTrue(evaluationSummary.pageContains("Documentation: 8.0"));
			documentation = evaluationSummary.editDocumentation();
			documentation.setMetrics(-100);
			evaluationSummary = documentation.goToSummary();
			assertTrue(evaluationSummary.pageContains("Documentation: 2.0"));
		}
	
	@Test
	public void licenseTest() {
		 beginEvaluation = homePage.beginEvaluation();
		 evaluationWeight = beginEvaluation.createEvaluation();
		 surveyName = evaluationWeight.continueEvaluation();
		 license = surveyName.getSubmenu().goToLicense();
		 license.clickCheckBox();
		 evaluationSummary = license.goToSummary();
		assertTrue(evaluationSummary.pageContains("License: 0.0"));
		license = evaluationSummary.editLicense();
		license.clickCheckBox();
		evaluationSummary = license.goToSummary();
		assertTrue(evaluationSummary.pageContains("License: 10"));
	}
	
	@Test
	public void marketPenetrationTest(){
			 beginEvaluation = homePage.beginEvaluation();
			 evaluationWeight = beginEvaluation.createEvaluation();
			 surveyName = evaluationWeight.continueEvaluation();
			 marketPenetration = surveyName.getSubmenu().goToPenetration();
			 marketPenetration.setMetrics(100);
			 evaluationSummary = marketPenetration.goToSummary();
			assertTrue(evaluationSummary.pageContains("Market Penetration: 8.0"));
			marketPenetration = evaluationSummary.editMarketPenetration();
			marketPenetration.setMetrics(-100);
			evaluationSummary = marketPenetration.goToSummary();
			assertTrue(evaluationSummary.pageContains("Market Penetration: 2.0"));
		}
	
	@Test
	public void pedigreeTest(){
			 beginEvaluation = homePage.beginEvaluation();
			 evaluationWeight = beginEvaluation.createEvaluation();
			 surveyName = evaluationWeight.continueEvaluation();
			 pedigree = surveyName.getSubmenu().goToPedigree();
			 pedigree.setMetrics(100);
			 evaluationSummary = pedigree.goToSummary();
			assertTrue(evaluationSummary.pageContains("Pedigree: 8.0"));
			pedigree = evaluationSummary.editPedigree();
			pedigree.setMetrics(-100);
			evaluationSummary = pedigree.goToSummary();
			assertTrue(evaluationSummary.pageContains("Pedigree: 2.0"));
		}
	
	@Test
	public void supportTest(){
			 beginEvaluation = homePage.beginEvaluation();
			 evaluationWeight = beginEvaluation.createEvaluation();
			 surveyName = evaluationWeight.continueEvaluation();
			 support = surveyName.getSubmenu().goToSupport();
			 support.setMetrics(100);
			 evaluationSummary = support.goToSummary();
			assertTrue(evaluationSummary.pageContains("Support: 8.0"));
			support = evaluationSummary.editSupport();
			support.setMetrics(-100);
			evaluationSummary = support.goToSummary();
			assertTrue(evaluationSummary.pageContains("Support: 2.0"));
		}
		
	@Test
	public void velocityTest(){
			 beginEvaluation = homePage.beginEvaluation();
			 evaluationWeight = beginEvaluation.createEvaluation();
			 surveyName = evaluationWeight.continueEvaluation();
			 velocity = surveyName.getSubmenu().goToVelocity();
			 velocity.setMetrics(100);
			 evaluationSummary = velocity.goToSummary();
			assertTrue(evaluationSummary.pageContains("Velocity: 8.0"));
			velocity = evaluationSummary.editVelocity();
			velocity.setMetrics(-100);
			evaluationSummary = velocity.goToSummary();
			assertTrue(evaluationSummary.pageContains("Velocity: 2.0"));
		}
	
	@Test
	public void functionalityTest(){
			 beginEvaluation = homePage.beginEvaluation();
			 evaluationWeight = beginEvaluation.createEvaluation();
			 surveyName = evaluationWeight.continueEvaluation();
			 functionality = surveyName.getSubmenu().goToFunctionality();
			 functionality.setMetrics(100);
			 evaluationSummary = functionality.goToSummary();
			assertTrue(evaluationSummary.pageContains("Functionality: 8.0"));
			functionality = evaluationSummary.editFunctionality();
			functionality.setMetrics(-100);
			evaluationSummary = functionality.goToSummary();
			assertTrue(evaluationSummary.pageContains("Functionality: 2.0"));
		}	
}
