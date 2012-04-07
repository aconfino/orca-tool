package com.orca.page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.orca.selenium.utils.TestUtils;

public class Home extends BasePageObject{
	protected WebDriver driver;

	public Home(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void open() {
		driver.get(TestUtils.getURL());
	}
	
	public BeginEvaluation beginEvaluation(){
		return super.beginEvaluation(driver);
}

}
