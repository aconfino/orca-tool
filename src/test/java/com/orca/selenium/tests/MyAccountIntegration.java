package com.orca.selenium.tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.orca.page.objects.CreateAccount;
import com.orca.page.objects.Home;
import com.orca.page.objects.Login;
import com.orca.page.objects.MyAccount;
import com.orca.selenium.utils.TestUtils;
import com.orca.service.UserService;
import com.orca.service.UserServiceImpl;

public class MyAccountIntegration {
		
		private Home homePage;
		private Login login;
		private MyAccount myAccount;
		private CreateAccount createAccount;
		private UserService userService = new UserServiceImpl();
		private static String randomString;
		WebDriver driver;
	
		
		@Before
		public void openTheBrowser() throws IOException {
			driver = TestUtils.getFirefoxDriver();
			homePage = PageFactory.initElements(driver, Home.class);
			homePage.open();
		}

		@After
		public void closeTheBrowser() {
			driver.quit();
		}
		
		@Test
		public void createAccount() {
			randomString = userService.getRandomString();
			login = homePage.logIntoAccount(driver);
			createAccount = login.createAccount();
			myAccount = createAccount.createTestAccount(randomString);
			assertTrue(myAccount.pageContains("My Account"));
			assertTrue(myAccount.pageContains(randomString + "@mailinator.com"));
		}
		
		@Test
		public void logIntoAccount(){
			login = homePage.logIntoAccount(driver);
			myAccount = login.login(new String(randomString + "@mailinator.com"), randomString);
			assertTrue(myAccount.pageContains("My Account"));
			assertTrue(myAccount.pageContains(randomString + "@mailinator.com"));		
		}

}
