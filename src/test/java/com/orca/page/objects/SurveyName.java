package com.orca.page.objects;

import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SurveyName extends BasePageObject {
	private WebDriver driver;
	protected SurveySubmenu submenu;
	
	public SurveyName(WebDriver driver){
		submenu = new SurveySubmenu(driver);
		this.driver=driver;
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

	public SurveySubmenu getSubmenu() {
		return submenu;
	}

	public void setSubmenu(SurveySubmenu submenu) {
		this.submenu = submenu;
	}
	
	
	
}
