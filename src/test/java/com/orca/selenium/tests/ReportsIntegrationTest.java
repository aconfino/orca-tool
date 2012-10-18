package com.orca.selenium.tests;

import java.io.IOException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.orca.page.objects.Home;
import com.orca.selenium.utils.TestUtils;

public class ReportsIntegrationTest {
		
		private Home homePage;
		WebDriver driver;
		
		@Before
		public void openTheBrowser() throws IOException {
			driver = TestUtils.getFirefox9Driver();
			homePage = PageFactory.initElements(driver, Home.class);
			homePage.open();
		}

		@After
		public void closeTheBrowser() {
			driver.quit();
		}
		
		@Test
		public void createAccount() {
			
		}

}
