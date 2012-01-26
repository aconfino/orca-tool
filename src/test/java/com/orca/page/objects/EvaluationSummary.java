package com.orca.page.objects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EvaluationSummary {
	protected WebDriver driver;
	
	public EvaluationSummary(WebDriver driver){
		this.driver=driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="page")
	WebElement page;
	
	public boolean pageContains(String string){
		boolean contains = false;
		if (page.getText().contains(string))
				contains = true;
		return contains;
	}
	
}
