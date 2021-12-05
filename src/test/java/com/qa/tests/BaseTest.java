package com.qa.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.qa.driver.DriverOperations;

// This class initializes and quits driver
public class BaseTest {
	
	protected BaseTest() {
		
	}

	@BeforeMethod
	protected void setup() throws Exception {	
		DriverOperations.initDriver();
	}
	
	@AfterMethod
	protected void teardown() throws Exception {
		DriverOperations.quitDriver();
	}
}
