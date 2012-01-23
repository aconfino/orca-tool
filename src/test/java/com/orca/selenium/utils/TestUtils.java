package com.orca.selenium.utils;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class TestUtils {
	
	public static final String URL = "http://localhost:8080/";

	public static FirefoxDriver getFirefoxDriver(){
		// TODO make this path relative
		File profileDirectory = new File("C:\\workspace\\orcaproject\\src\\test\\resources\\FirefoxProfile");
		FirefoxProfile profile = new FirefoxProfile(profileDirectory);
		return new FirefoxDriver(profile);
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
