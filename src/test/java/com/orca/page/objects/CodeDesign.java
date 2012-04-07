package com.orca.page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orca.selenium.utils.TestUtils;

public class CodeDesign extends BasePageObject {
	protected WebDriver driver;
	protected SurveySubmenu submenu;
	
	public CodeDesign(WebDriver driver) {
		submenu = new SurveySubmenu(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id='codeDesign']/input[2]")
	private WebElement nextMetric;
	
	@FindBy(xpath="//*[@id='codeDesign']/input[3]")
	private WebElement goToSummary;
	
	@FindBy(id="objectOrientedSlider")
	private WebElement objectOrientedSlider;

	@FindBy(id="understandabilitySlider")
	private WebElement understandabilitySlider;
	
	@FindBy(id="extensibilitySlider")
	private WebElement extensibilitySlider;
	
	@FindBy(id="testabilitySlider")
	private WebElement testabilitySlider;
	
	public void setMetrics(int xAxis){
		TestUtils.slideElement(driver, objectOrientedSlider, xAxis);
		TestUtils.slideElement(driver, understandabilitySlider, xAxis);
		TestUtils.slideElement(driver, extensibilitySlider, xAxis);
		TestUtils.slideElement(driver, testabilitySlider, xAxis);
	}
	
	public CodeRuntime continueSurvey(){
		TestUtils.slideElement(driver, objectOrientedSlider, 100);
		TestUtils.slideElement(driver, understandabilitySlider, 200);
		TestUtils.slideElement(driver, extensibilitySlider, -100);
		TestUtils.slideElement(driver, testabilitySlider, -200);
		nextMetric.click();
		return new CodeRuntime(driver);
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
