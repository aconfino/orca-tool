package com.orca.page.objects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EvaluationSummary extends BasePageObject{
	protected WebDriver driver;
	
	public EvaluationSummary(WebDriver driver){
		this.driver=driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id='noRightRailContent']/div/div/div/a")
	WebElement editEvaluation;
	
	@FindBy(xpath="//*[@id='noRightRailContent']/div/div/div[2]")
	WebElement functionalityWeight;
	
	@FindBy(xpath="//*[@id='noRightRailContent']/div/div[2]/div[2]/a")
	WebElement editCodeDesign;
	
	@FindBy(xpath="//*[@id='noRightRailContent']/div/div[2]/div[3]/a")
	WebElement editCodeRuntime;
	
	@FindBy(xpath="//*[@id='noRightRailContent']/div/div[2]/div[4]/a")
	WebElement editCodeStatic;
	
	@FindBy(xpath="//*[@id='noRightRailContent']/div/div[2]/div[5]/a")
	WebElement editCommunity;

	@FindBy(xpath="//*[@id='noRightRailContent']/div/div[2]/div[6]/a")
	WebElement editDocumentation;
	
	@FindBy(xpath="//*[@id='noRightRailContent']/div/div[2]/div[7]/a")
	WebElement editLicense;
	
	@FindBy(xpath="//*[@id='noRightRailContent']/div/div[2]/div[8]/a")
	WebElement editMarketPenetration;
	
	@FindBy(xpath="//*[@id='noRightRailContent']/div/div[2]/div[9]/a")
	WebElement editPedigree;
	
	@FindBy(xpath="//*[@id='noRightRailContent']/div/div[2]/div[10]/a")
	WebElement editSupport;
	
	@FindBy(xpath="//*[@id='noRightRailContent']/div/div[2]/div[11]/a")
	WebElement editVelocity;
	
	@FindBy(xpath="//*[@id='noRightRailContent']/div/div[2]/div[12]/a")
	WebElement editFunctionality;

	public EditEvaluation editEvaluation(){
		editEvaluation.click();
		return new EditEvaluation(driver);
	}
	
	public CodeDesign editCodeDesign(){
		editCodeDesign.click();
		return new CodeDesign(driver);
	}
	
	public CodeRuntime editCodeRuntime(){
		editCodeRuntime.click();
		return new CodeRuntime(driver);
	}
	
	public CodeStatic editCodeStatic(){
		editCodeStatic.click();
		return new CodeStatic(driver);
	}
	
	public Community editCommunity(){
		editCommunity.click();
		return new Community(driver);
	}
	
	public Documentation editDocumentation(){
		editDocumentation.click();
		return new Documentation(driver);
	}
	
	public License editLicense(){
		editLicense.click();
		return new License(driver);
	}
	
	public MarketPenetration editMarketPenetration(){
		editMarketPenetration.click();
		return new MarketPenetration(driver);
	}
	
	public Pedigree editPedigree(){
		editPedigree.click();
		return new Pedigree(driver);
	}
	
	public Support editSupport(){
		editSupport.click();
		return new Support(driver);
	}
	
	public  Velocity editVelocity(){
		editVelocity.click();
		return new Velocity(driver);
	}
	
	public  Functionality editFunctionality(){
		editFunctionality.click();
		return new Functionality(driver);
	}
}
