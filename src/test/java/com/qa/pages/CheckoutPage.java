package com.qa.pages;

import static com.qa.driver.DriverManager.getDriver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.qa.enums.WaitStrategy;

public class CheckoutPage extends BasePage{

	private final static By btnPayWithCard = By.xpath("//button[@type='submit']");
	private final static By rowCount = By.xpath("//table//tbody/tr");
	private final static By totalPrice = By.id("total");


	public static void clickOnPayWithCard() {
		click(btnPayWithCard , WaitStrategy.CLICKABLE);
	}
	
	// This method is to get total price printed on the Checkout page
	public static Integer getTotalPrice() {
		 String price =getElementText(getDriver().findElement(totalPrice)).replaceAll("[^\\d]", "");
		 Integer totalPrice =Integer.parseInt(price);
		 return totalPrice ; 
	}
	
	// This method is to return sum of the prices of all the products listed in checkout page
	public static Integer sumOfAllPrices() {
		Integer sum =0;
		List<Map<String,Integer>> list = getPriceMapOfProducts() ;
	
		for(Map<String,Integer> map : list) {
			for (Map.Entry<String, Integer> entry : map.entrySet()) {
				sum = sum + entry.getValue() ;
			}
		}
		return sum ;
	}
	
	// This method is to capture all the products and their prices in a map
	public static List<Map<String,Integer>>  getPriceMapOfProducts() {
		List<WebElement> rows= getDriver().findElements(rowCount);
		List<Map<String,Integer>> list = new ArrayList<Map<String,Integer>>();
		
		
		for(int i=1; i<=rows.size();i++) {
			Map<String, Integer> map = new HashMap<String, Integer>();
			WebElement product = getDriver().findElement(By.xpath("//table//tbody/tr["+ i +"]/td[1]")) ;
			String productName = getElementText(product) ;

			WebElement productPrice = getDriver().findElement(By.xpath("//table//tbody/tr["+ i +"]/td[2]")) ;
			
			int productPriceInt =Integer.parseInt(getElementText(productPrice));
			map.put(productName, productPriceInt);
			list.add(map);
		}
		return list;
	}
	

}
