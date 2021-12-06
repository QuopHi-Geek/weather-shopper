# weather-shopper
Test Weather Shopping App

How to use this framework?

Download the zip or clone the Git repository. Unzip the zip file (if you downloaded one). Open Command Prompt and Change directory (cd) to folder containing pom.xml Open Eclipse/IntelliJ File -> Import -> Existing Maven Project -> Navigate to the folder where you unzipped the zip Select the right project Right Click on the testng.xml and Run as 1 TestNg Suite You are all Set

Components of framework ?

testng.xml - It contains the test class and method name which is to be run.

src/main/java - Page objects and test files etc.

com.qa.constants Constants.java - This class contains constants which are used across framework and will never change. In our case, we are storing path of config.properties and explicit wait time.

com.qa.driver DriverManager.java - This class provides thread safety to the static variable (driver) so that parallel test execution can be done without any issues. DriverOperations.java - This class contains implementation of initDriver and quitDriver methods. Through these methods, we are initializing the driver with Browser drivers and then launching the URL.

WeatherShopper_Manual_Testcase - Gherkin E2E test case for Weather Shopping
