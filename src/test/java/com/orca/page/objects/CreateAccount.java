package com.orca.page.objects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccount extends BasePageObject {
protected WebDriver driver;
	
	public CreateAccount(WebDriver driver) {
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="username")
	WebElement usernameField;
	
	@FindBy(id="password")
	WebElement passwordField;
	
	@FindBy(id="confirmPassword")
	WebElement confirmPasswordField;
	
	@FindBy(xpath="//*[@id='user']/span/input")
	WebElement createAccountButton;

	public MyAccount createTestAccount(String randomString){	
		usernameField.sendKeys(new String(randomString + "@mailinator.com"));
		passwordField.sendKeys(randomString);
		confirmPasswordField.sendKeys(randomString);
		createAccountButton.click();
		return new MyAccount(driver);
	}
	
}
