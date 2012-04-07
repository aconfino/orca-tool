package com.orca.page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orca.selenium.utils.TestUtils;

public class Support extends BasePageObject {
	protected WebDriver driver;
	protected SurveySubmenu submenu;
	
	public Support(WebDriver driver) {
		submenu = new SurveySubmenu(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id='support']/input[2]")
	private WebElement nextMetric;
	
	@FindBy(xpath="//*[@id='support']/input[3]")
	private WebElement goToSummary;
	
	@FindBy(id="commercialSupportSlider")
	private WebElement commercialSupportSlider;
	
	@FindBy(id="indemnificationSlider")
	private WebElement indemnificationSlider;
	
	@FindBy(id="communitySupportSlider")
	private WebElement communitySupportSlider;
	
	public void setMetrics(int xAxis){
		TestUtils.slideElement(driver, commercialSupportSlider, xAxis);
		TestUtils.slideElement(driver, indemnificationSlider, xAxis);
		TestUtils.slideElement(driver, communitySupportSlider, xAxis);
	}
	
	public Velocity continueSurvey(){
		TestUtils.slideElement(driver, commercialSupportSlider, 200);
		TestUtils.slideElement(driver, indemnificationSlider, 100);
		TestUtils.slideElement(driver, communitySupportSlider, 200);
		nextMetric.click();
		return new Velocity(driver);
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
