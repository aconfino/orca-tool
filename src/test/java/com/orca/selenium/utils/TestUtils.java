package com.orca.selenium.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestUtils {
	
	// TODO make this path relative
	public static final String firefoxProfileDir = "C:\\workspace\\orcaproject\\src\\test\\resources\\FirefoxProfile";	
	public static final String URL = "http://orca-project.herokuapp.com/";
	private static final Integer driverTimeout = 30;

    public static WebDriver getFirefoxDriver() {
    	DesiredCapabilities capabilities = new DesiredCapabilities();
    	capabilities = DesiredCapabilities.firefox();
    	capabilities.setBrowserName("firefox");
    	capabilities.setPlatform(org.openqa.selenium.Platform.WINDOWS);
    	capabilities.setVersion("10");
    	WebDriver firefoxDriver = new FirefoxDriver(capabilities);
    	firefoxDriver.manage().timeouts().implicitlyWait(driverTimeout, TimeUnit.SECONDS);
    	return firefoxDriver;
    }	
	
	public static ChromeDriver getChromeDriver(){
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(driverTimeout, TimeUnit.SECONDS);
		return driver;
	}
	
	public static InternetExplorerDriver getInternetExplorerDriver(){
		InternetExplorerDriver driver = new InternetExplorerDriver();
		driver.manage().timeouts().implicitlyWait(driverTimeout, TimeUnit.SECONDS);
		return driver;
	}
	
	public static void slideElement(WebDriver driver, WebElement webElement, int xAxis){
		 Actions builder = new Actions(driver);
		 Action slide = builder.dragAndDropBy(webElement, xAxis, 0).build();
		 slide.perform();
	}
	
	public static String getURL(){
		return URL;
	}

	public static Integer getDrivertimeout() {
		return driverTimeout;
	}

}
