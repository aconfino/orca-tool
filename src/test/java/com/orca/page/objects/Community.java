package com.orca.page.objects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orca.selenium.utils.TestUtils;

public class Community {
	protected WebDriver driver;
	
	public Community(WebDriver driver) {
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id='community']/input[2]")
	private WebElement nextMetric;
	
	@FindBy(xpath="//*[@id='community']/input[3]")
	private WebElement goToSummary;
	
	@FindBy(id="websiteSlider")
	private WebElement websiteSlider;
	
	@FindBy(id="mailingListSlider")
	private WebElement mailingListSlider;
	
	@FindBy(id="bugTrackerSlider")
	private WebElement bugTrackerSlider;
	
	public Documentation continueSurvey(){
		TestUtils.slideElement(driver, websiteSlider, 100);
		TestUtils.slideElement(driver, mailingListSlider, 100);
		TestUtils.slideElement(driver, bugTrackerSlider, 200);
		nextMetric.click();
		return new Documentation(driver);
	}
	
	public EvaluationSummary goToSummary(){
		goToSummary.click();
		return new EvaluationSummary(driver);
	}

}
