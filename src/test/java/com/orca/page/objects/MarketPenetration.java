package com.orca.page.objects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orca.selenium.utils.TestUtils;

public class MarketPenetration {
	protected WebDriver driver;
	
	public MarketPenetration(WebDriver driver) {
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id='marketPenetration']/input[2]")
	private WebElement nextMetric;
	
	@FindBy(xpath="//*[@id='marketPenetration']/input[3]")
	private WebElement goToSummary;
	
	@FindBy(id="marketPenetrationScoreSlider")
	private WebElement marketPenetrationScoreSlider;
	
	
	public Pedigree continueSurvey(){
		TestUtils.slideElement(driver, marketPenetrationScoreSlider, 100);
		nextMetric.click();
		return new Pedigree(driver);
	}
	
	public EvaluationSummary goToSummary(){
		goToSummary.click();
		return new EvaluationSummary(driver);
	}

}
