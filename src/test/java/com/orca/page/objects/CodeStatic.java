package com.orca.page.objects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orca.selenium.utils.TestUtils;

public class CodeStatic {
	protected WebDriver driver;
	
	public CodeStatic(WebDriver driver) {
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id='codeStatic']/input[2]")
	private WebElement nextMetric;
	
	@FindBy(xpath="//*[@id='codeStatic']/input[3]")
	private WebElement goToSummary;
	
	@FindBy(id="cyclomaticComplexitySlider")
	private WebElement cyclomaticComplexitySlider;
	
	@FindBy(id="methodCountSlider")
	private WebElement methodCountSlider;
	
	@FindBy(id="dependencyCyclesSlider")
	private WebElement dependencyCyclesSlider;
	
	public Community continueSurvey(){
		TestUtils.slideElement(driver, cyclomaticComplexitySlider, -200);
		TestUtils.slideElement(driver, methodCountSlider, 200);
		TestUtils.slideElement(driver, dependencyCyclesSlider, 100);
		nextMetric.click();
		return new Community(driver);
	}
	
	public EvaluationSummary goToSummary(){
		goToSummary.click();
		return new EvaluationSummary(driver);
	}

}
