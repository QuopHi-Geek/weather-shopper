package com.qa.driver;

import java.util.Objects;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.qa.enums.ConfigProperties;
import com.qa.utils.PropertyUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverOperations {
	private DriverOperations() {
	}


	public static void initDriver(String browser) throws Exception {
		if (Objects.isNull(DriverManager.getDriver())) {
		
			// Driver is initialized with the browser given as input in testng.xml
			if(browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				DriverManager.setDriver(new ChromeDriver());
			} else if (browser.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				DriverManager.setDriver(new EdgeDriver());
			} else {
				System.out.println("Given Browser is not implemented");
			}

			DriverManager.getDriver().get(PropertyUtils.get(ConfigProperties.URL));
		}
	}

	public static void quitDriver() throws Exception {
		if (Objects.nonNull(DriverManager.getDriver())) {
			Thread.sleep(3000);
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}
}
