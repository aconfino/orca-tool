package com.orca.page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChangePassword extends BasePageObject {
	protected WebDriver driver;
	
	public ChangePassword(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id='content']/div/div/form/input")
	private WebElement passwordField;
	
	@FindBy(xpath="//*[@id='content']/div/div/form/input[2]")
	private WebElement confirmPasswordField;
	
	@FindBy(xpath="//*[@id='content']/div/div/form/input[3]")
	private WebElement changePasswordButton;
	
	@FindBy(xpath="//*[@id='content']/div/div/form/a")
	private WebElement returnToAccount;
	
	public MyAccount changePassword(String string){
		passwordField.sendKeys(string);
		confirmPasswordField.sendKeys(string);
		changePasswordButton.click();
		return new MyAccount(driver);
	}
	
	public MyAccount returnToAccount(){
		returnToAccount.click();
		return new MyAccount(driver);
	}

}
