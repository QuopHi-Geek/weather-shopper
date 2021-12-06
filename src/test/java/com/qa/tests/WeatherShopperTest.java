package com.qa.tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.pages.CheckoutPage;
import com.qa.pages.HomePage;
import com.qa.pages.ProductPage;
import com.qa.pages.StripePaymentPage;

import static com.qa.driver.DriverManager.*;


public class WeatherShopperTest extends BaseTest{	

	@Parameters({"browser"})
	@Test(description = "Validate user is able to do end to end shopping flow either for moisturizers or sunscreens based on the current temperature")

	public  void weatherShopping1(String browser) throws Exception {
    
		HomePage.maximizeWindow();

		HomePage.startShopping();

		List<Map<String,Integer>> list = new ArrayList<Map<String,Integer>>();

		if(getDriver().getCurrentUrl().contains("sunscreen")) {
			list.add(ProductPage.clickOnLeastExpensiveProduct("SPF-50"));	
			list.add(ProductPage.clickOnLeastExpensiveProduct("SPF-30"));	
		}
		else if (getDriver().getCurrentUrl().contains("moisturizer")){
			list.add(ProductPage.clickOnLeastExpensiveProduct("Aloe"));	
			list.add(ProductPage.clickOnLeastExpensiveProduct("Almond"));	
		} 
		else {
			System.out.println("Sunscreen or Moisturizer page not found");
		}

		ProductPage.clickOnCart();

    
		Assert.assertEquals(list, CheckoutPage.getPriceMapOfProducts(),
				"Validate name and corresponding price of each and every product in checkout page with respect to the price displayed in previous page");
		Assert.assertEquals(CheckoutPage.getTotalPrice(),CheckoutPage.sumOfAllPrices(),
				"Validate if total price and sum of prices of all the products is same");
		
		CheckoutPage.clickOnPayWithCard();

		StripePaymentPage.switchToIframe();
		
		StripePaymentPage.enterEmail("a.b@mail.com");
		
		StripePaymentPage.clickOnCardNumberTextBox();
		StripePaymentPage.enterCardNumber("4242");
		StripePaymentPage.enterCardNumber("4242");
		StripePaymentPage.enterCardNumber("4242");
		StripePaymentPage.enterCardNumber("4242");
		
		StripePaymentPage.enterCardExpiry("01");
		StripePaymentPage.enterCardExpiry("22");
		StripePaymentPage.enterCardCVC("123");
		StripePaymentPage.enterZipCode("12345");
		
		StripePaymentPage.clickOnPayButton();
		
		Assert.assertEquals(StripePaymentPage.getPaymentSuccessText(), "PAYMENT SUCCESS","Validate if sucessful payment message is visible on screen");
	}	
}
