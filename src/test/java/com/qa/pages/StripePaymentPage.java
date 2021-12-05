package com.qa.pages;

import static com.qa.driver.DriverManager.getDriver;
import org.openqa.selenium.By;
import com.qa.enums.WaitStrategy;
import com.qa.factories.ExplicitWaitFactory;

// This class is for handling everything related to payment
public class StripePaymentPage extends BasePage{

	private final static By textBoxEmail = By.xpath("//div[contains(@class,'emailInput')]/input");
	private final static By textBoxCardNumber = By.xpath("//div[contains(@class,'cardNumberInput')]/input");
	private final static By textBoxCardExpiry = By.xpath("//div[contains(@class,'cardExpiresInput')]/input");
	private final static By textBoxCVC = By.xpath("//div[contains(@class,'cardCVCInput')]/input");
	private final static By textBoxZipCode = By.xpath("//div[contains(@class,'zipCodeInput')]/input");
	private final static By btnPay = By.xpath("//span[contains(text(),'Pay INR')]/../..");
	private final static By textPaymentSuccess = By.xpath("//h2[text()='PAYMENT SUCCESS']");

	public static void enterEmail(String email) {
		sendKeys(textBoxEmail , email, WaitStrategy.CLICKABLE);
	}
	
	public static void  clickOnCardNumberTextBox() {
		click(textBoxCardNumber, WaitStrategy.CLICKABLE);
	}
	public static void enterCardNumber(String cardNumber) {
		sendKeys(textBoxCardNumber , cardNumber, WaitStrategy.CLICKABLE);
	}

	public static void enterCardExpiry(String cardNumber) {
		sendKeys(textBoxCardExpiry , cardNumber , WaitStrategy.CLICKABLE);
	}

	public static void enterCardCVC(String CVC) {
		sendKeys(textBoxCVC , CVC , WaitStrategy.CLICKABLE);
	}

	public static void enterZipCode(String zipCode) {
		sendKeys(textBoxZipCode , zipCode , WaitStrategy.CLICKABLE);
	}

	public static void  clickOnPayButton() {
		click(btnPay, WaitStrategy.CLICKABLE);
	}
	
	public static String getPaymentSuccessText() {
		getDriver().switchTo().defaultContent();
		ExplicitWaitFactory.performWaitStrategy(WaitStrategy.VISIBLE, textPaymentSuccess);
		return getElementText(getDriver().findElement(textPaymentSuccess));
	}
	
	public static void switchToIframe() {
		getDriver().switchTo().frame("stripe_checkout_app");
	}
}
