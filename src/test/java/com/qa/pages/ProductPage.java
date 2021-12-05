package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.qa.driver.DriverManager.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.qa.enums.WaitStrategy;

//This class is common for both the product pages - sunscreen and moisturizer
public final class ProductPage extends BasePage {
	protected ProductPage() {}

	private final static By textProducts=By.xpath("//div[@class='container']//p[1]");
	private final static By btnCart=By.xpath("//button[contains(text(),'Cart')]");

	public static void clickOnCart() {
		click(btnCart,WaitStrategy.CLICKABLE) ;
	}

	// This method clicks on the add button for least expensive product
	public static Map<String, Integer> clickOnLeastExpensiveProduct(String productType) {
		Map<String, Integer> map=getLeastExpensiveProductOfGivenType(productType);
		String productName = null ;
		for(Map.Entry<String, Integer> entry : map.entrySet()) {
			 productName = entry.getKey();
		}
		
		final By product=By.xpath("//p[text()='"+productName+"']/../button");	
		click(product,WaitStrategy.CLICKABLE) ;
		return map;
	}

	// This method returns least expensive product and its price in a map based on the product type given in input like Aloe, Almond, SPF-30 or 50.
	public static Map<String, Integer> getLeastExpensiveProductOfGivenType(String productType) {
		Map<String, Integer> map =getPriceMapOfAllProducts();
		List<Integer> priceList= new ArrayList<Integer>();
		String leastExpProd = null;

		Map<String,Integer> mapReturn = new HashMap<String, Integer>();

		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if(entry.getKey().contains(productType)) {
				priceList.add(entry.getValue());
			}
		}

		Collections.sort(priceList);
		int value =priceList.get(0) ;

		for (String key: map.keySet())
		{
			if (value == map.get(key)) {
				leastExpProd = key;
			}
		}
		mapReturn.put(leastExpProd, value);
		return mapReturn ;
	}

	// This method is to capture all the products and their prices in a map
	public static Map<String, Integer> getPriceMapOfAllProducts() {
		List<WebElement>  productsList= getDriver().findElements(textProducts);
		Map<String, Integer> map = new HashMap<String, Integer>();

		for(int i=1; i<=productsList.size();i++) {
			WebElement product = getDriver().findElement(By.xpath("(//div[@class='container']//p[1])["+ i + "]")) ;
			String productName = getElementText(product) ;

			WebElement productPrice = getDriver().findElement(By.xpath("(//div[@class='container']//p[2])["+ i + "]")) ;
			int productPriceInt =Integer.parseInt(getElementText(productPrice).replaceAll("[^\\d]", ""));
			map.put(productName, productPriceInt);
		}
		return map;
	}


}
