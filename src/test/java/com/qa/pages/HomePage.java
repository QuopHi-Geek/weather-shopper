package com.qa.pages;

import org.openqa.selenium.By;

import com.qa.driver.DriverManager;
import com.qa.enums.WaitStrategy;
import com.qa.pages.BasePage;

public class HomePage extends BasePage{


	private final static By textTemperature = By.id("temperature");
	private final static By btnBuyMoisturizer = By.xpath("//button[text()='Buy moisturizers']");
	private final static By btnBuySunscreen = By.xpath("//button[text()='Buy sunscreens']");
	
	// This method returns current temperature displayed on screen
	public static String getTemperature() {
		String text = getElementText(DriverManager.getDriver().findElement(textTemperature));
		return text ;
	}
	
	// This method decides whether to shop moisturizer or Sunscreen based on the current temperature and then clicks on the appropriate button
	public static void startShopping() {
		String temp = getTemperature().replaceAll("[^\\d.]", "");
		int actualTemp = Integer.parseInt(temp);
		System.out.println("Temp is "+actualTemp);
		if(actualTemp<19) {
			click(btnBuyMoisturizer , WaitStrategy.CLICKABLE);
		} else if (actualTemp>34) {
			click(btnBuySunscreen , WaitStrategy.CLICKABLE);
		} else {
			System.out.println("Shopping is not required");
		}
	}

	// This method maximizes window
	public static void maximizeWindow() {
		DriverManager.
				getDriver().manage().window().maximize();
	}
}
