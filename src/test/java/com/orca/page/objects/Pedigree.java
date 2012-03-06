package com.orca.page.objects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orca.selenium.utils.TestUtils;

public class Pedigree extends BasePageObject {
	protected WebDriver driver;
	protected SurveySubmenu submenu;
	
	public Pedigree(WebDriver driver) {
		submenu = new SurveySubmenu(driver);
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id='pedigree']/input[2]")
	private WebElement nextMetric;
	
	@FindBy(xpath="//*[@id='pedigree']/input[3]")
	private WebElement goToSummary;
	
	@FindBy(id="authorSlider")
	private WebElement authorSlider;
	
	@FindBy(id="groupSponsorSlider")
	private WebElement groupSponsorSlider;
	
	@FindBy(id="derivedSlider")
	private WebElement derivedSlider;
	
	public void setMetrics(int xAxis){
		TestUtils.slideElement(driver, authorSlider, xAxis);
		TestUtils.slideElement(driver, groupSponsorSlider, xAxis);
		TestUtils.slideElement(driver, derivedSlider, xAxis);
	}
	
	public Support continueSurvey(){
		TestUtils.slideElement(driver, authorSlider, -200);
		TestUtils.slideElement(driver, groupSponsorSlider, 100);
		TestUtils.slideElement(driver, derivedSlider, 200);
		nextMetric.click();
		return new Support(driver);
	}
	
	public EvaluationSummary goToSummary(){
		goToSummary.click();
		return new EvaluationSummary(driver);
	}

	public SurveySubmenu getSubmenu() {
		return submenu;
	}

	public void setSubmenu(SurveySubmenu submenu) {
		this.submenu = submenu;
	}

}
