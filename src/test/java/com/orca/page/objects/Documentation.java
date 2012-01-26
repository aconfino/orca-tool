package com.orca.page.objects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orca.selenium.utils.TestUtils;

public class Documentation {
	protected WebDriver driver;
	
	public Documentation(WebDriver driver) {
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id='documentation']/input[2]")
	private WebElement nextMetric;
	
	@FindBy(xpath="//*[@id='documentation']/input[3]")
	private WebElement goToSummary;
	
	@FindBy(id="userDocumentationSlider")
	private WebElement userDocumentationSlider;
	
	@FindBy(id="developerDocumentationSlider")
	private WebElement developerDocumentationSlider;
	
	@FindBy(id="codeCommentsSlider")
	private WebElement codeCommentsSlider;
	
	@FindBy(id="installationDocumentationSlider")
	private WebElement installationDocumentationSlider;
	
	@FindBy(id="administrationDocumentationSlider")
	private WebElement administrationDocumentationSlider;
	
	public License continueSurvey(){
		TestUtils.slideElement(driver, userDocumentationSlider, 100);
		TestUtils.slideElement(driver, developerDocumentationSlider, -100);
		TestUtils.slideElement(driver, codeCommentsSlider, 100);
		TestUtils.slideElement(driver, installationDocumentationSlider, 200);
		TestUtils.slideElement(driver, administrationDocumentationSlider, 100);
		nextMetric.click();
		return new License(driver);
	}
	
	public EvaluationSummary goToSummary(){
		goToSummary.click();
		return new EvaluationSummary(driver);
	}

}
