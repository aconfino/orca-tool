package com.orca.page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasePageObject {
	
	@FindBy(xpath="//*[@id='menu']/ul/li/a")
	protected WebElement beginEvaluation;
	
	@FindBy(xpath="//*[@id='menu']/ul/li[5]/a")
	protected WebElement myAccount;
	
	@FindBy(id="page")
	protected WebElement page;
	
	
	public boolean pageContains(String string){
		boolean contains = false;
		if (page.getText().contains(string))
				contains = true;
		return contains;
	}
	
	public BeginEvaluation beginEvaluation(WebDriver driver){
		beginEvaluation.click();
		return new BeginEvaluation(driver);
	}
	
	public Login logIntoAccount(WebDriver driver){
		myAccount.click();
		return new Login(driver);
	}

}
