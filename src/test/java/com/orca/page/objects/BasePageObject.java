package com.orca.page.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasePageObject {
	
	@FindBy(id="page")
	WebElement page;
	
	public boolean pageContains(String string){
		boolean contains = false;
		if (page.getText().contains(string))
				contains = true;
		return contains;
	}

}
