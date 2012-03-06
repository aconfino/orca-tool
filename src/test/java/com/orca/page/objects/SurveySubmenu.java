package com.orca.page.objects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SurveySubmenu {
	
	protected WebDriver driver;
	
	public SurveySubmenu(WebDriver driver) {
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id='surveyTopNav']/span/a")
	private WebElement codeDesign;
	
	@FindBy(xpath="//*[@id='surveyTopNav']/span[2]/a")
	private WebElement codeRuntime;
	
	@FindBy(xpath="//*[@id='surveyTopNav']/span[3]/a")
	private WebElement codeStatic;
	
	@FindBy(xpath="//*[@id='surveyTopNav']/span[4]/a")
	private WebElement community;
	
	@FindBy(xpath="//*[@id='surveyTopNav']/span[5]/a")
	private WebElement  documentation;	
	
	@FindBy(xpath="//*[@id='surveyTopNav']/span[6]/a")
	private WebElement  license;	

	@FindBy(xpath="//*[@id='surveyTopNav']/span[7]/a")
	private WebElement  marketPenetration;	
	
	@FindBy(xpath="//*[@id='surveyTopNav']/span[8]/a")
	private WebElement  pedigree;	
	
	@FindBy(xpath="//*[@id='surveyTopNav']/span[9]/a")
	private WebElement  support;	
	
	@FindBy(xpath="//*[@id='surveyTopNav']/span[10]/a")
	private WebElement  velocity;
	
	@FindBy(xpath="//*[@id='surveyTopNav']/span[11]/a")
	private WebElement  functionality;	
	
	@FindBy(xpath="//*[@id='surveyTopNav']/span[12]/a")
	private WebElement  summary;	
	
	public CodeDesign goToCodeDesign(){
		codeDesign.click();
		return new CodeDesign(driver);
	}
	
	public CodeRuntime goToCodeRuntime(){
		codeRuntime.click();
		return new CodeRuntime(driver);
	}
	
	public CodeStatic goToCodeStatic(){
		codeStatic.click();
		return new CodeStatic(driver);
	}
	
	public Community goToCommunity(){
		community.click();
		return new Community(driver);
	}
	
	public Documentation goToDocumentation(){
		documentation.click();
		return new Documentation(driver);
	}
	
	public License goToLicense(){
		license.click();
		return new License(driver);
	}
	
	public MarketPenetration goToPenetration(){
		marketPenetration.click();
		return new MarketPenetration(driver);
	}
	
	public Pedigree goToPedigree(){
		pedigree.click();
		return new Pedigree(driver);
	}
	
	public Support goToSupport(){
		support.click();
		return new Support(driver);
	}
	
	public Velocity goToVelocity(){
		velocity.click();
		return new Velocity(driver);
	}
	
	public Functionality goToFunctionality(){
		functionality.click();
		return new Functionality(driver);
	}
	
	public EvaluationSummary goToSummary(){
		summary.click();
		return new EvaluationSummary(driver);
	}
}
