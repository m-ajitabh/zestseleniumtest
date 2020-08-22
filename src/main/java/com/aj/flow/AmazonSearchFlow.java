package com.aj.flow;

import com.aj.global.Log;
import com.aj.po.AmazonHomePage;
import com.aj.po.AmazonSearchPage;


public class AmazonSearchFlow {
	
	int pageNo;
	int productIndex;
	static float amazonPrice = 0;
	
	public float searchAndReturnProductPriceAmazonFlow(String productName) {
		Log.info("Amazon search flow started");
		pageNo = 1;
		productIndex = -1;
		AmazonHomePage amazonHomePage = new AmazonHomePage();
		AmazonSearchPage amazonSearchPage = amazonHomePage.searchProductAmazon(productName);
		do {
			productIndex = amazonSearchPage.getItemNameFromList(productName);
			Log.info("Amazon - got the product index: "+productIndex);
			//System.out.println("index " + productIndex);
			if (productIndex >= 0) {
				amazonPrice = amazonSearchPage.getPriceFromList(productIndex);
				Log.info("Amazon - got the product price: "+amazonPrice);
				break;
			} else {
				try {
					amazonSearchPage.gotoNextPage();
					Thread.sleep(1000);
					// CustomWait.waitForWebElementElementToBeVisible(element);
				} catch (Exception e) {
					break;
				}

			}
		} while (true);
		
		return amazonPrice;
	}

	public float searchAndReturnProductPriceAmazonFlow(String productName, String size, String color) {
		pageNo = 1;
		productIndex = -1;
		AmazonHomePage amazonHomePage = new AmazonHomePage();
		AmazonSearchPage amazonSearchPage = amazonHomePage.searchProductAmazon(productName +" "+size + " " + color);
		do {
			productIndex = amazonSearchPage.getItemNameFromList(productName, size, color);
			//System.out.println("index " + productIndex);
			if (productIndex >= 0) {
				amazonPrice = amazonSearchPage.getPriceFromList(productIndex);

				break;
			} else {
				try {
					amazonSearchPage.gotoNextPage();
					Thread.sleep(1000);
					// CustomWait.waitForWebElementElementToBeVisible(element);
				} catch (Exception e) {
					break;
				}

			}
		} while (true);
		
		return amazonPrice;
	}

}
