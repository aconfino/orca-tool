package com.orca.page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orca.selenium.utils.TestUtils;

public class EditEvaluation {
	private WebDriver driver;
	protected EvaluationSubMenu submenu;
	
	public EditEvaluation(WebDriver driver){
		submenu = new EvaluationSubMenu(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="name")
	private WebElement name;
	
	@FindBy(className="functionalityWeightSlider")
	private WebElement functionalitySlider;
	
	@FindBy(className="codeWeightSlider")
	private WebElement codeSlider;

	@FindBy(className="pedigreeWeightSlider")
	private WebElement pedigreeSlider;
	
	@FindBy(className="marketWeightSlider")
	private WebElement marketSlider;

	@FindBy(className="supportWeightSlider")
	private WebElement supportSlider;
	
	@FindBy(className="licenseWeightSlider")
	private WebElement licenseSlider;

	@FindBy(className="velocityWeightSlider")
	private WebElement velocitySlider;

	@FindBy(className="communityWeightSlider")
	private WebElement communitySlider;

	@FindBy(className="documentationWeightSlider")
	private WebElement documentationSlider;
	
	@FindBy(xpath="//*[@id='evaluation']/div[2]/input")
	private WebElement saveButton;
	
	public EvaluationSummary saveAndGoToSummary(){
		saveButton.click();
		return new EvaluationSummary(driver);
	}
	
	public EvaluationSummary editAndSaveEvaluation(String name){
		editName(name);
		editWeight();
		saveButton.click();
		return new EvaluationSummary(driver);
	}
	
	public void editName(String string){
		name.clear();
		name.sendKeys(string);
	}
	
	public void editWeight(){	
		TestUtils.slideElement(driver, functionalitySlider, 20);
		TestUtils.slideElement(driver, codeSlider, 40);
		TestUtils.slideElement(driver, pedigreeSlider, 60);
		TestUtils.slideElement(driver, marketSlider, 80);
		TestUtils.slideElement(driver, supportSlider, 100);
		TestUtils.slideElement(driver, licenseSlider, -20);
		TestUtils.slideElement(driver, velocitySlider, -60);
		TestUtils.slideElement(driver, communitySlider, -80);
		TestUtils.slideElement(driver, documentationSlider, -100);
	}
	
	public void moveFunctionalitySlider(int value){
		TestUtils.slideElement(driver, functionalitySlider, value);
	}
	
	public void moveCodeSlider(int value){
		TestUtils.slideElement(driver, codeSlider, value);
	}
	
	public void movePedigreeSlider(int value){
		TestUtils.slideElement(driver, pedigreeSlider, value);
	}
	
	public void moveMarketSlider(int value){
		TestUtils.slideElement(driver, marketSlider, value);
	}
	
	public void moveSupportSlider(int value){
		TestUtils.slideElement(driver, supportSlider, value);
	}
	
	public void moveLicenseSlider(int value){
		TestUtils.slideElement(driver, licenseSlider, value);
	}
	
	public void moveVelocitySlider(int value){
		TestUtils.slideElement(driver, velocitySlider, value);
	}
	
	public void moveCommunitySlider(int value){
		TestUtils.slideElement(driver, communitySlider, value);
	}
	
	public void moveDocumentationSlider(int value){
		TestUtils.slideElement(driver, documentationSlider, value);
	}

	public EvaluationSubMenu getSubmenu() {
		return submenu;
	}

	public void setSubmenu(EvaluationSubMenu submenu) {
		this.submenu = submenu;
	}

}
