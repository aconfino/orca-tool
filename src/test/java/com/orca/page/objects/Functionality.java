package com.orca.page.objects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orca.selenium.utils.TestUtils;

public class Functionality {
	protected WebDriver driver;
	
	public Functionality(WebDriver driver) {
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//*[@id='functionality']/input[2]")
	private WebElement nextMetric;
	
	@FindBy(xpath="//*[@id='functionality']/input[3]")
	private WebElement goToSummary;
	
	@FindBy(id="featureScoreSlider")
	private WebElement featureScoreSlider;
	
	public Comments continueSurvey(){
		TestUtils.slideElement(driver, featureScoreSlider, 200);
		nextMetric.click();
		return new Comments(driver);
	}
	
	public EvaluationSummary goToSummary(){
		goToSummary.click();
		return new EvaluationSummary(driver);
	}
}
