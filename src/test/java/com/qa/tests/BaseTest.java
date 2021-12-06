package com.qa.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.qa.driver.DriverOperations;

// This class initializes and quits driver
public class BaseTest {
	
	protected BaseTest() {
		
	}

	@BeforeMethod
	protected void setup(Object[] parameters) throws Exception {
		// We are taking the parameter sent to test method from testng xml in below line of code
		String browser = parameters[0].toString() ;
		DriverOperations.initDriver(browser);
	}
	
	@AfterMethod
	protected void teardown() throws Exception {
		DriverOperations.quitDriver();
	}
}
