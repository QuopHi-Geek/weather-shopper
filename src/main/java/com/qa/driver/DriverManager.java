package com.qa.driver;

import org.openqa.selenium.WebDriver;

// This class provides thread safety to the static driver variable so that parallel execution can be done without any issues.
public class DriverManager {
	private DriverManager(){
		
	} 
	
	private static ThreadLocal<WebDriver> dr = new ThreadLocal<WebDriver>();
	
	public static WebDriver getDriver() {
		return dr.get();
	}
	
	public static void setDriver(WebDriver driverRef) {
		dr.set(driverRef);
	}
	
	public static void unload() {
		dr.remove();
	}
}

