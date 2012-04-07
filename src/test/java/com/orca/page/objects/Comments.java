package com.orca.page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Comments extends BasePageObject {
	protected WebDriver driver;
	
	public Comments(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="surveyComments")
	private WebElement surveyComments;
		
	@FindBy(xpath="//*[@id='survey']/input[2]")
	private WebElement finishSurvey;
		
	public EvaluationSummary finishSurvey() {
		surveyComments.sendKeys("Lorem ipsum dolor sit amet, consectetur adipiscing elit. ");
		finishSurvey.click();
		return new EvaluationSummary(driver);
	}
}
