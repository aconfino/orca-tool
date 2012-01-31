package com.orca.page.objects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orca.selenium.utils.TestUtils;

public class Velocity extends BasePageObject {
	protected WebDriver driver;
	protected SurveySubmenu submenu;
	
	public Velocity(WebDriver driver) {
		submenu = new SurveySubmenu(driver);
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id='velocity']/input[2]")
	private WebElement nextMetric;
	
	@FindBy(xpath="//*[@id='velocity']/input[3]")
	private WebElement goToSummary;
	
	@FindBy(id="featureActualSlider")
	private WebElement featureActualSlider;
	
	@FindBy(id="patchActualSlider")
	private WebElement patchActualSlider;
	
	public void setMetrics(int xAxis){
		TestUtils.slideElement(driver, featureActualSlider, xAxis);
		TestUtils.slideElement(driver, patchActualSlider, xAxis);
	}
	
	public Functionality continueSurvey(){
		TestUtils.slideElement(driver, featureActualSlider, 200);
		TestUtils.slideElement(driver, patchActualSlider, 100);
		nextMetric.click();
		return new Functionality(driver);
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
