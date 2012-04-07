package com.orca.page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orca.selenium.utils.TestUtils;

public class CodeRuntime extends BasePageObject{
	protected WebDriver driver;
	public SurveySubmenu submenu;
	
	public CodeRuntime(WebDriver driver) {
		submenu = new SurveySubmenu(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//*[@id='codeRuntime']/input[2]")
	private WebElement nextMetric;
	
	@FindBy(xpath="//*[@id='codeRuntime']/input[3]")
	private WebElement goToSummary;
	
	@FindBy(id="cpuThreshholdSlider")
	private WebElement cpuThreshholdSlider;
	
	@FindBy(id="memoryThreshholdSlider")
	private WebElement memoryThreshholdSlider;

	@FindBy(id="IOThreshholdSlider")
	private WebElement IOThreshholdSlider;
	
	public void setMetrics(int xAxis){
		TestUtils.slideElement(driver, cpuThreshholdSlider, xAxis);
		TestUtils.slideElement(driver, memoryThreshholdSlider, xAxis);
		TestUtils.slideElement(driver, IOThreshholdSlider, xAxis);
	}
	
	public CodeStatic continueSurvey(){
		TestUtils.slideElement(driver, cpuThreshholdSlider, -100);
		TestUtils.slideElement(driver, memoryThreshholdSlider, -200);
		TestUtils.slideElement(driver, IOThreshholdSlider, 100);
		nextMetric.click();
		return new CodeStatic(driver);
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
