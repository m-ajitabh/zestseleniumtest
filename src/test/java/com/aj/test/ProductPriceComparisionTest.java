package com.aj.test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aj.common.CustomProperties;
import com.aj.flow.AmazonSearchFlow;
import com.aj.flow.FlipkartSearchFlow;
import com.aj.global.Log;
import com.aj.global.SeleniumBaseTest;

public class ProductPriceComparisionTest extends SeleniumBaseTest {

	static float flipkartPrice = 0;
	static float amazonPrice = 0;
	
	String amazonUrl;
	String flipkartUrl;
	
	@BeforeTest
	void getURL() {
		
		amazonUrl = CustomProperties.getConfigProperty("amazonurl");
		flipkartUrl = CustomProperties.getConfigProperty("flipkarturl");
		Log.info("Price Comparision: Fetched the urls of Amazon and Flipkart from properties file");
	}
	
	@DataProvider(name="SearchProvider")
    public Object[] getDataFromDataprovider(){
    return new Object[]
    	{
    		"Apple iPhone XR (64GB) - Yellow"
    	};
    	

    }
	
	@Test(dataProvider="SearchProvider")
	void test001(String productName) {
		Log.info("Amazon: Find product price started...");
		driver.navigate().to(amazonUrl);
		Log.info("Amazon: Url openned...");
		AmazonSearchFlow searchFlow = new AmazonSearchFlow();
		amazonPrice = searchFlow.searchAndReturnProductPriceAmazonFlow(productName);
	}
	
	@Test(dataProvider="SearchProvider")
	void test002(String productName) {
		Log.info("Flipkart: Find product price started...");
		driver.navigate().to(flipkartUrl);
		Log.info("Flipkart: Url openned...");
		
		FlipkartSearchFlow searchFlow = new FlipkartSearchFlow();
		flipkartPrice = searchFlow.searchAndReturnProductPriceFlipkartFlow(productName);
	}
	
	@AfterTest
	void results() {
		Log.info("Price Comparision: Amazon and Flipkart price comparision for a product started...");
		
		if(amazonPrice == 0 && flipkartPrice == 0) {
			System.out.println("Product not found in Amazon");
			System.out.println("Product not found in Flipkart");
		}else if(amazonPrice == 0) {
			System.out.println("Product not found in Amazon");
			System.out.println("Flipkart price is less: " + flipkartPrice);
		}else if(flipkartPrice == 0) {
			System.out.println("Product not found in Flipkart");
			System.out.println("Amazon price is less: " + amazonPrice);
		}else if(amazonPrice == flipkartPrice) {
			System.out.println("Amazon and Flipkart prices is same: " + amazonPrice);
		}
		else {
			if ( amazonPrice < flipkartPrice) {
				System.out.println("Amazon price is less: " + amazonPrice);
			}else {
				System.out.println("Flipkart price is less: " + flipkartPrice);
			}
		}
	}

}

