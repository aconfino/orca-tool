package com.orca.page.objects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orca.selenium.utils.TestUtils;

public class Velocity {
	protected WebDriver driver;
	
	public Velocity(WebDriver driver) {
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

}
