package com.orca.page.objects;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SurveyName {
	private WebDriver driver;
	
	public SurveyName(WebDriver driver){
		this.driver=driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="surveyName")
	private WebElement surveyName;
	
	@FindBy(xpath="//*[@id='survey']/input[3]")
	private WebElement beginMetrics;
	
	@FindBy(xpath="//*[@id='survey']/input[4]")
	private WebElement goToSummary;
	
	
	public CodeDesign continueEvaluation(){
		Date date = new Date();
		surveyName.sendKeys("Test Survey -- " + date.toString());
		beginMetrics.click();
		return new CodeDesign(driver);
	}
	
	public EvaluationSummary goToSummary(){
		goToSummary.click();
		return new EvaluationSummary(driver);
	}
	
}
