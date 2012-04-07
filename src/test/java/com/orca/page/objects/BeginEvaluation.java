package com.orca.page.objects;

import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BeginEvaluation {
	protected WebDriver driver;
	protected EvaluationSubMenu submenu;
	
	public BeginEvaluation(WebDriver driver) {
		submenu = new EvaluationSubMenu(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="name")
	private WebElement evaluationName;
	
	@FindBy(xpath="//*[@id='evaluation']/input[3]")
	private WebElement submitButton;
	
	public EvaluationWeight createEvaluation(){
		Date date = new Date();
		evaluationName.clear();
		evaluationName.sendKeys("Test Evaluation -- " + date.toString());
		submitButton.click();
		return new EvaluationWeight(driver);
	}

	public EvaluationSubMenu getSubmenu() {
		return submenu;
	}

	public void setSubmenu(EvaluationSubMenu submenu) {
		this.submenu = submenu;
	}
	
}
