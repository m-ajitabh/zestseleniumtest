package com.aj.flow;

import com.aj.global.Log;
import com.aj.po.FlipkartHomePage;
import com.aj.po.FlipkartSearchPage;

public class FlipkartSearchFlow {

	int pageNo;
	int productIndex;
	static float flipkartPrice = 0;
	
	
	public float searchAndReturnProductPriceFlipkartFlow(String productName) {
		
		Log.info("Search Flow started");
		FlipkartHomePage flipkartHomePage = new FlipkartHomePage();
		FlipkartSearchPage flipkartSearchPage = flipkartHomePage.searchProductFlipkart(productName);
		
		try {
			pageNo = flipkartSearchPage.getNoOfPages();
		} catch (Exception e) {
			// TODO: handle exception
		}

		for (int i = 0; i < pageNo; i++) {
			productIndex = flipkartSearchPage.getItemNameFromList(productName);
			Log.info("Flipkart - got the product index: "+productIndex);
			if (productIndex >= 0) {
				flipkartPrice = flipkartSearchPage.getPriceFromList(productIndex);
				Log.info("Flipkart - got the product price: "+flipkartPrice);

				break;
			} else {
				try {
					flipkartSearchPage.gotoNextPage();
				} catch (Exception e) {
					// TODO: handle exception
				}
			}

		}
		return flipkartPrice;
	}
	
	public float searchAndReturnProductPriceFlipkartFlow(String productName, String size, String color) {
		FlipkartHomePage flipkartHomePage = new FlipkartHomePage();
		FlipkartSearchPage flipkartSearchPage = flipkartHomePage.searchProductFlipkart(productName +" "+size + " " + color);
		
		try {
			pageNo = flipkartSearchPage.getNoOfPages();
		} catch (Exception e) {
			// TODO: handle exception
		}

		for (int i = 0; i < pageNo; i++) {
			productIndex = flipkartSearchPage.getItemNameFromList(productName, size, color);

			if (productIndex >= 0) {
				flipkartPrice = flipkartSearchPage.getPriceFromList(productIndex);
				break;
			} else {
				try {
					flipkartSearchPage.gotoNextPage();
				} catch (Exception e) {
					// TODO: handle exception
				}
			}

		}
		return flipkartPrice;
	}
}
