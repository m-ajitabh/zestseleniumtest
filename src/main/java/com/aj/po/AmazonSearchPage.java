package com.aj.po;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aj.global.SeleniumBasePage;

public class AmazonSearchPage extends SeleniumBasePage {

	@FindBy(xpath = "//*[@class='a-last']")
	public static WebElement nextPage;
	public void gotoNextPage() {
		nextPage.click();
	}

	@FindBy(xpath = "//*[@class='a-size-medium a-color-base a-text-normal']")
	public static List<WebElement> listOfItemName;

	public int getItemNameFromList(String name) {
		//System.out.println(name.toLowerCase().replace(" ", "").replace("-", ""));
		for (int i = 0; i < listOfItemName.size(); i++) {
			//System.out.println(listOfItemName.get(i).getText().toLowerCase().replace(" ", "").replace("-", ""));
			if(listOfItemName.get(i).getText().toLowerCase().replaceAll("[^a-zA-Z0-9]", "").contains(name.toLowerCase().replaceAll("[^a-zA-Z0-9]", "")))
				return i;
		}
		return -1;
	}
	
	public int getItemNameFromList(String productName, String sizegb, String color) {
		//System.out.println(name.toLowerCase().replace(" ", "").replace("-", ""));
		for (int i = 0; i < listOfItemName.size(); i++) {
			String elementName = listOfItemName.get(i).getText();
			driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS) ;
			elementName = elementName.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
			if(elementName.contains(productName.toLowerCase().replaceAll("[^a-zA-Z0-9]", "")) && elementName.contains(color.toLowerCase().replaceAll("[^a-zA-Z0-9]", "")) && elementName.contains(sizegb.toLowerCase().replaceAll("[^a-zA-Z0-9]", "")) )
				return i;
			if(listOfItemName.get(i).getText().toLowerCase().replaceAll("[^a-zA-Z0-9]", "").contains(productName.toLowerCase()))
				return i;
		}
		return -1;
	}

	@FindBy(xpath = "//*[@class='a-price-whole']")
	public static List<WebElement> listOfPrice;

	public float getPriceFromList(int index) {

		return Float.parseFloat(listOfPrice.get(index).getText().replace(",", ""));
	}

	

}
