package com.orca.page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class License extends BasePageObject {
	protected WebDriver driver;
	protected SurveySubmenu submenu;
	
	public License(WebDriver driver) {
		submenu = new SurveySubmenu(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id='license']/input[5]")
	private WebElement nextMetric;
		                                                                         
	@FindBy(xpath="//*[@id='license']/input[6]")
	private WebElement goToSummary;
		
	@FindBy(id="licenseName")
	private WebElement licenseName;
	
	@FindBy(id="acceptable1")
	private WebElement acceptableCheckBox;
		
	public MarketPenetration continueSurvey(){
		licenseName.clear();
		licenseName.sendKeys("Copyleft");
		nextMetric.click();
		return new MarketPenetration(driver);
	}
	
	public void clickCheckBox(){
		acceptableCheckBox.click();
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
