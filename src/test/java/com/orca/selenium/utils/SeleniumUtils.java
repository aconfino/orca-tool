package com.orca.selenium.utils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.ui.Select;

public class SeleniumUtils {
		
	/*
	* Helper method to populate forms with POJOs. 
	 * Checks the variable name against the form input name and populates the value.
	 * If the form input name has a space, replace with a underscore on the POJO
	 * i.e.  name="some value"  should be some_value on the POJO
	*/

	public static void populateForm(WebElement formElement, Object object, WebDriver driver) {
		// change the timeouts just for this method
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		List<WebElement> inputs = formElement.findElements(By.cssSelector("input"));
		List<WebElement> dropDowns = formElement.findElements(By.cssSelector("select"));
		List<WebElement> textAreas = formElement.findElements(By.cssSelector("textarea"));
			for (WebElement element : inputs){     
				if (element.getAttribute("type").equals("text")){
					populateTextInput(object, element);
				} else if (element.getAttribute("type").equals("password")){
					populateTextInput(object, element);
				} else if (element.getAttribute("type").equals("checkbox")){
					populateCheckbox(object, element);
				} else if (element.getAttribute("type").equals("radio")){
					populateRadioButton(object, element);
				} else if (element.getAttribute("type").equals("email")){
					populateTextInput(object, element);
				}
			}
			
			for (WebElement element : dropDowns){
				populateDropDown(object, element);
			}
			
			for (WebElement element : textAreas){
				populateTextInput(object, element);
			}

			// change the timeouts back
			driver.manage().timeouts().implicitlyWait(TestUtils.getDrivertimeout(), TimeUnit.SECONDS);
	}

private static void populateTextInput(Object object, WebElement element) {
	String value = getValueFromBean(object, element);     
		if (value != null) {
			element.clear();
			element.sendKeys(value);
		}
}

private static void populateCheckbox(Object object, WebElement element) {
	String value = getValueFromBean(object, element);     
		if ((element.getAttribute("value").equals(value)) && (!element.isSelected())){
			element.click();
		}
}

private static void populateRadioButton(Object object, WebElement element) {
	String value = getValueFromBean(object, element);     
		if (element.getAttribute("value").equals(value)) {
			clickRadioButton(element);
		}
}

public static void clickRadioButton(WebElement element){
	if (element.isDisplayed()){
		element.click();
	}
	// TODO - FIXME
	// Selenium currently does not allow elements to be clicked if they
	// are not visible.  This is common on elements affect by jQuery UI
}

private static void populateDropDown(Object object, WebElement element) {
	String value = getValueFromBean(object, element);     
		if (value != null) {
			Select select = new Select(element);
			select.selectByValue(value);
		}
}

public static String getValueFromBean(Object object, WebElement element){
	String value = null;
		try {
			value = BeanUtils.getProperty(object, element.getAttribute("name"));
		} catch (IllegalAccessException e) {
	       // no match, return null
		} catch (InvocationTargetException e) {
			// no match, return null
		} catch (NoSuchMethodException e) {
			// no match, return null
		}
		if (value == null){
			value = getValueWithoutSpaces(object, element);
		}
		return value;
}

/*
* a form input name can contain spaces while a Java variable cannot
* this method handles those instances
*/

public static String getValueWithoutSpaces(Object object, WebElement element){

	String value = null;
		try {
			value = BeanUtils.getProperty(object, element.getAttribute("name").replace(" ", "_"));
		} catch (IllegalAccessException e) {
			// no match, return null
		} catch (InvocationTargetException e) {
			// no match, return null
		} catch (NoSuchMethodException e) {
			// no match, return null
	   }
	   return value;
}
	

	@SuppressWarnings("unused")
	public void takeScreenShot(String className, Throwable t, WebDriver driver) throws IOException {
		String callerMethod = null;
		WebDriver augmentedDriver = new Augmenter().augment(driver);
		File screenshot = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
		File scrFile = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
		StackTraceElement[] stackTraceElements = t.getStackTrace();

		for (StackTraceElement element : stackTraceElements) {
			if (element.getClassName().equals(className)) {
				callerMethod = element.getMethodName();
				break;
			}
		}
		String filename = new String("target/screenshots/" + className + "-" + callerMethod + "()" + ".png");
		FileUtils.copyFile(scrFile, new File(filename));
	}
	
}
