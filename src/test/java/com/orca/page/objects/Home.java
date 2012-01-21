package com.orca.page.objects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orca.selenium.utils.TestUtils;

public class Home {
	protected WebDriver driver;

	@FindBy(xpath="//*[@id='menu']/ul/li/a")
	private WebElement beginEvaluation;

	public Home(WebDriver driver) {
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		PageFactory.initElements(driver, this);

	}

	public void open() {
		driver.get(TestUtils.getURL());
	}
	
	public BeginEvaluation beginEvaluation(){
			beginEvaluation.click();
			return new BeginEvaluation(driver);
	}

}
