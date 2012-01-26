package com.orca.page.objects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orca.selenium.utils.TestUtils;

public class CodeDesign {
	protected WebDriver driver;
	
	public CodeDesign(WebDriver driver) {
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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

}
