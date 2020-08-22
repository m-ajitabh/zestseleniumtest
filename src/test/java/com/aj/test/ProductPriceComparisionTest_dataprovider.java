package com.aj.test;

import com.aj.common.CustomProperties;
import com.aj.flow.AmazonSearchFlow;
import com.aj.flow.FlipkartSearchFlow;
import com.aj.global.SeleniumBaseTest;
import com.aj.pojo.TestData;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ProductPriceComparisionTest_dataprovider extends SeleniumBaseTest{
	static float flipkartPrice = 0;
	static float amazonPrice = 0;
	//String productName = "Apple iPhone 11 (128GB) - Black";
	
	String amazonUrl;
	String flipkartUrl;
	
	@BeforeTest
	void getURL() {
		
		amazonUrl = CustomProperties.getConfigProperty("amazonurl");
		flipkartUrl = CustomProperties.getConfigProperty("flipkarturl");
	}
	
	@Test(dataProvider="SearchProvider")
	void test001(TestData data) {
		driver.navigate().to(amazonUrl);
		AmazonSearchFlow searchFlow = new AmazonSearchFlow();
		amazonPrice = searchFlow.searchAndReturnProductPriceAmazonFlow(data.getProductName(), data.getProductSize(),data.getProductColor());
	}
	
	@Test(dataProvider="SearchProvider")
	void test002(TestData data) {
		driver.navigate().to(flipkartUrl);
		FlipkartSearchFlow searchFlow = new FlipkartSearchFlow();
		flipkartPrice = searchFlow.searchAndReturnProductPriceFlipkartFlow(data.getProductName(), data.getProductSize(),data.getProductColor());
	}
	
	@AfterTest
	void results() {
		
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

	
	@DataProvider(name="SearchProvider")
    public Object[] getDataFromDataprovider(){
    return new Object[]
    	{
    		new TestData("Apple iPhone XR", "64GB", "Yellow")
    	};
    	

    }
	
}
