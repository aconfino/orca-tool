package com.orca.selenium.utils;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class TestUtils {
	
	// TODO make this path relative
	public static final String firefoxProfileDir = "C:\\workspace\\orcaproject\\src\\test\\resources\\FirefoxProfile";	
	public static final String URL = "http://localhost:8080/";
	
	public static FirefoxDriver getFirefoxDriver(){
	//	File profileDirectory = new File(firefoxProfileDir);
	//	FirefoxProfile profile = new FirefoxProfile(profileDirectory);
	//	return new FirefoxDriver(profile);
		return new FirefoxDriver();
	}
	
	public static void slideElement(WebDriver driver, WebElement webElement, int xAxis){
		 Actions builder = new Actions(driver);
		 Action slide = builder.dragAndDropBy(webElement, xAxis, 0).build();
		 slide.perform();
	}
	
	public static String getURL(){
		return URL;
	}

}
