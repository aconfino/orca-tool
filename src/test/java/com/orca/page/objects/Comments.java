package com.orca.page.objects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Comments {
	protected WebDriver driver;
	
	public Comments(WebDriver driver) {
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="comments")
	private WebElement surveyComments;
	
	@FindBy(xpath="//*[@id='survey']/input[2]")
	private WebElement finishSurvey;
		
	public EvaluationSummary finishSurvey() {
		surveyComments.sendKeys("Lorem ipsum dolor sit amet, consectetur adipiscing elit. ");
		finishSurvey.click();
		return new EvaluationSummary(driver);
	}
}
