package com.orca.page.objects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orca.selenium.utils.TestUtils;

public class CodeRuntime {
	protected WebDriver driver;
	
	public CodeRuntime(WebDriver driver) {
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
	
	
}
