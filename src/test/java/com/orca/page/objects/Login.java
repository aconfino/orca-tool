package com.orca.page.objects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login extends BasePageObject {
	protected WebDriver driver;
	
	public Login(WebDriver driver) {
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id='content']/div/div/form/span/input")
	private WebElement usernameField;
	
	@FindBy(xpath="//*[@id='content']/div/div/form/span/input[2]")
	private WebElement passwordField;

	@FindBy(xpath="//*[@id='content']/div/div/form/span/input[3]")
	private WebElement submitButton;
	
	@FindBy(xpath="//*[@id='content']/div/div/span/form/input")
	private WebElement createAccount;
	
	public MyAccount login (String username, String password){
		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		submitButton.click();
		return new MyAccount(driver);
	}
	
	public CreateAccount createAccount(){
		createAccount.click();
		return new CreateAccount(driver);
	}

}
