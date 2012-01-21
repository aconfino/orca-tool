package com.orca.page.objects;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BeginEvaluation {
	protected WebDriver driver;
	
	public BeginEvaluation(WebDriver driver) {
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id='page']/span/a")
	private WebElement createNewEvaluation;
	
	@FindBy(xpath="//*[@id='page']/span[2]/a")
	private WebElement editEvaluation;
	
	@FindBy(xpath="//*[@id='page']/span[3]/a")
	private WebElement evaluationSummary;
	
	@FindBy(id="name")
	private WebElement evaluationName;
	
	@FindBy(xpath="//*[@id='evaluation']/input[3]")
	private WebElement submitButton;
	
	public EvaluationWeight createEvaluation(){
		Date date = new Date();
		evaluationName.clear();
		evaluationName.sendKeys("Test Evaluation" + date.toString());
		submitButton.click();
		return new EvaluationWeight(driver);
	}

}
