package com.orca.page.objects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orca.selenium.utils.TestUtils;

public class EvaluationWeight {
	protected WebDriver driver;
	
	public EvaluationWeight(WebDriver driver){
		this.driver=driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="functionalityWeightSlider")
	private WebElement functionalitySlider;
	
	@FindBy(id="codeWeightSlider")
	private WebElement codeSlider;

	@FindBy(id="pedigreeWeightSlider")
	private WebElement pedigreeSlider;
	
	@FindBy(id="marketWeightSlider")
	private WebElement marketSlider;

	@FindBy(id="supportWeightSlider")
	private WebElement supportSlider;
	
	@FindBy(id="licenseWeightSlider")
	private WebElement licenseSlider;

	@FindBy(id="velocityWeightSlider")
	private WebElement velocitySlider;

	@FindBy(id="communityWeightSlider")
	private WebElement communitySlider;

	@FindBy(id="documentationWeightSlider")
	private WebElement documentationSlider;
	
	@FindBy(xpath="//*[@id='evaluation']/div[2]/input[2]")
	private WebElement continueButton;
	
	@FindBy(xpath="//*[@id='evaluation']/div[2]/input[3]")
	private WebElement gotoSummaryButton;
	
	public SurveyName setWeight(){	
		TestUtils.slideElement(driver, functionalitySlider, -20);
		TestUtils.slideElement(driver, codeSlider, -40);
		TestUtils.slideElement(driver, pedigreeSlider, -60);
		TestUtils.slideElement(driver, marketSlider, -80);
		TestUtils.slideElement(driver, supportSlider, -100);
		TestUtils.slideElement(driver, licenseSlider, 20);
		TestUtils.slideElement(driver, velocitySlider, 40);
		TestUtils.slideElement(driver, velocitySlider, 60);
		TestUtils.slideElement(driver, communitySlider, 80);
		TestUtils.slideElement(driver, documentationSlider, 100);
		continueButton.click();
	return new SurveyName(driver);
	}

}
