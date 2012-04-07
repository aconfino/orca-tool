package com.orca.page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orca.selenium.utils.TestUtils;

public class MarketPenetration extends BasePageObject {
	protected WebDriver driver;
	protected SurveySubmenu submenu;
	
	public MarketPenetration(WebDriver driver) {
		submenu = new SurveySubmenu(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id='marketPenetration']/input[2]")
	private WebElement nextMetric;
	
	@FindBy(xpath="//*[@id='marketPenetration']/input[3]")
	private WebElement goToSummary;
	
	@FindBy(id="marketPenetrationScoreSlider")
	private WebElement marketPenetrationScoreSlider;
	
	public void setMetrics(int xAxis){
		TestUtils.slideElement(driver, marketPenetrationScoreSlider, xAxis);
	}
	
	public Pedigree continueSurvey(){
		TestUtils.slideElement(driver, marketPenetrationScoreSlider, 100);
		nextMetric.click();
		return new Pedigree(driver);
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
