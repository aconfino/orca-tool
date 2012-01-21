package com.orca.selenium.utils;

import java.io.File;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class TestUtils {
	
	public static final String URL = "http://localhost:8080/";

	public static FirefoxDriver getFirefoxDriver(){
		// TODO make this path relative
		File profileDirectory = new File("C:\\workspace\\orcaproject\\src\\test\\resources\\FirefoxProfile");
		FirefoxProfile profile = new FirefoxProfile(profileDirectory);
		return new FirefoxDriver(profile);
	}
	
	public static String getURL(){
		return URL;
	}

}
