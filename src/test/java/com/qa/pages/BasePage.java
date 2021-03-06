package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.qa.driver.DriverManager;
import com.qa.enums.WaitStrategy;
import com.qa.factories.ExplicitWaitFactory;

// This class contains methods for common actions which can be used across all the pages. All the page classes extends this class.
public class BasePage {
	
	protected BasePage() {}
	
	protected static void click(By by, WaitStrategy waitStrategy) {
		ExplicitWaitFactory.performWaitStrategy(waitStrategy, by).click();
	}
	
	protected static void sendKeys(By by, String value, WaitStrategy waitStrategy) {
		ExplicitWaitFactory.performWaitStrategy(waitStrategy, by).sendKeys(value);
	}
	
	protected static String getPageTitle() {
		return DriverManager.getDriver().getTitle() ;
	}
	
	protected static String getElementText(WebElement element) {
		return element.getText() ;
	}

}
