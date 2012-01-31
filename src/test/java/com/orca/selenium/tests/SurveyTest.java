package com.orca.selenium.tests;

import static org.junit.Assert.*;
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

public class SurveyTest {
		
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
		
		@Test
		public void surveySubMenu() {
			beginEvaluation = homePage.beginEvaluation();
			evaluationWeight = beginEvaluation.createEvaluation();
			surveyName = evaluationWeight.continueEvaluation();
			codeDesign = surveyName.continueEvaluation();
			assertTrue(codeDesign.pageContains("Code Design"));
			codeRuntime = codeDesign.getSubmenu().goToCodeRuntime();
			assertTrue(codeRuntime.pageContains("Code Runtime"));
			codeStatic = codeRuntime.getSubmenu().goToCodeStatic();
			assertTrue(codeStatic.pageContains("Code Static"));
			community = codeStatic.getSubmenu().goToCommunity();
			assertTrue(community.pageContains("Community"));
			documentation = community.getSubmenu().goToDocumentation();
			assertTrue(documentation.pageContains("Documentation"));
			functionality = documentation.getSubmenu().goToFunctionality();
			assertTrue(functionality.pageContains("Functionality"));
			license = functionality.getSubmenu().goToLicense();
			assertTrue(license.pageContains("License"));
			pedigree = license.getSubmenu().goToPedigree();
			assertTrue(pedigree.pageContains("Pedigree"));
			marketPenetration = pedigree.getSubmenu().goToPenetration();
			assertTrue(marketPenetration.pageContains("Market Penetration"));
			support = marketPenetration.getSubmenu().goToSupport();
			assertTrue(support.pageContains("Support"));
			velocity = support.getSubmenu().goToVelocity();
			assertTrue(velocity.pageContains("Velocity"));
			evaluationSummary = velocity.getSubmenu().goToSummary();
			assertTrue(evaluationSummary.pageContains("Evaluation Summary"));
		}

}
