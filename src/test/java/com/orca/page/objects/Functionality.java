package com.orca.page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orca.selenium.utils.TestUtils;

public class Functionality extends BasePageObject {
	protected WebDriver driver;
	protected SurveySubmenu submenu;
	
	public Functionality(WebDriver driver) {
		submenu = new SurveySubmenu(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//*[@id='functionality']/input[2]")
	private WebElement nextMetric;
	
	@FindBy(xpath="//*[@id='functionality']/input[3]")
	private WebElement goToSummary;
	
	@FindBy(id="featureScoreSlider")
	private WebElement featureScoreSlider;
	
	public void setMetrics(int xAxis){
		TestUtils.slideElement(driver, featureScoreSlider, xAxis);
	}
	
	public Comments continueSurvey(){
		TestUtils.slideElement(driver, featureScoreSlider, 200);
		nextMetric.click();
		return new Comments(driver);
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
