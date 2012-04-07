package com.orca.page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccount extends BasePageObject {
	protected WebDriver driver;
	
	public MyAccount(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id='content']/div/div/h3/a")
	private WebElement changePassword;
	
	public ChangePassword changePassword(){
		changePassword.click();
		return new ChangePassword(driver);
	}

	
}
