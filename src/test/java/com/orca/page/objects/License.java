package com.orca.page.objects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class License {
	protected WebDriver driver;
	
	public License(WebDriver driver) {
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id='license']/input[5]")
	private WebElement nextMetric;
		                                                                         
	@FindBy(xpath="//*[@id='license']/input[6]")
	private WebElement goToSummary;
		
	@FindBy(id="licenseName")
	private WebElement licenseName;
	
	public MarketPenetration continueSurvey(){
		licenseName.clear();
		licenseName.sendKeys("Copyleft");
		nextMetric.click();
		return new MarketPenetration(driver);
	}
	
	public EvaluationSummary goToSummary(){
		goToSummary.click();
		return new EvaluationSummary(driver);
	}

}
