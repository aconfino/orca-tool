package com.orca.page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EvaluationSubMenu extends BasePageObject {
	
	protected WebDriver driver;
	
	public EvaluationSubMenu(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id='page']/span/a")
	private WebElement createNewEvaluation;
	
	@FindBy(xpath="//*[@id='page']/span[2]/a")
	private WebElement editEvaluation;
	
	@FindBy(xpath="//*[@id='page']/span[3]/a")
	private WebElement evaluationSummary;
	
	public BeginEvaluation createNewEvaluation(){
		createNewEvaluation.click();
		return new BeginEvaluation(driver);
	}
	
	public EditEvaluation editEvaluation(){
		editEvaluation.click();
		return new EditEvaluation(driver);
	}
	
	public EvaluationSummary goToSummary(){
		evaluationSummary.click();
		return new EvaluationSummary(driver);
	}

}
