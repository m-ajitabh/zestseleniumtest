package com.aj.po;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aj.global.SeleniumBasePage;

public class FlipkartSearchPage extends SeleniumBasePage{
	
	@FindBy(xpath = "//*[@class='_3fVaIS']")
	public static WebElement noOfPages;
	public int getNoOfPages() {
		try {
		String pageNo = noOfPages.getText();
		pageNo.substring(pageNo.length() - 1);
		return Integer.parseInt(pageNo);
	} catch (Exception e) {
			// TODO: handle exception
		}
	return 1;
	}
	
	@FindBy(xpath = "//*[@class='_3fVaIS']")
	public static WebElement nextPage;
	public void gotoNextPage() {
		nextPage.click();
	}

	@FindBy(xpath = "//*[@class='_3wU53n']")
	public static List<WebElement> listOfItemName;

	public int getItemNameFromList(String name){
		//System.out.println(name.toLowerCase().replace(" ", "").replace("-", ""));
		String productName = 	name.split("\\(")[0];
		String productColor = name.split("-")[1];
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS) ;
		int size = listOfItemName.size();
		
		for (int i = 0; i < size; i++) {
			driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS) ;
			String elementName = listOfItemName.get(i).getText();
			driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS) ;
			elementName = elementName.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
			if(elementName.contains(productName.toLowerCase().replaceAll("[^a-zA-Z0-9]", "")) && elementName.contains(productColor.toLowerCase().replaceAll("[^a-zA-Z0-9]", "")) )
				return i;
		}
		return -1;
	}
	
	public int getItemNameFromList(String productName, String sizegb, String productColor){
		
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS) ;
		int size = listOfItemName.size();
		
		for (int i = 0; i < size; i++) {
			driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS) ;
			String elementName = listOfItemName.get(i).getText();
			driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS) ;
			elementName = elementName.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
			if(elementName.contains(productName.toLowerCase().replaceAll("[^a-zA-Z0-9]", "")) && elementName.contains(productColor.toLowerCase().replaceAll("[^a-zA-Z0-9]", "")) && elementName.contains(sizegb.toLowerCase().replaceAll("[^a-zA-Z0-9]", "")) )
				return i;
		}
		return -1;
	}


	@FindBy(xpath = "//*[@class='_1vC4OE _2rQ-NK']")
	public static List<WebElement> listOfPrice;

	public  float getPriceFromList(int index) {

		return Float.parseFloat(listOfPrice.get(index).getText().replace(",", "").replace("₹", ""));
	}


}
