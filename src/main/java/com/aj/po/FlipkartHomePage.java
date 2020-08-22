package com.aj.po;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aj.global.SeleniumBasePage;



public class FlipkartHomePage extends SeleniumBasePage{
	
	@FindBy(name="q")
	public static WebElement flipkartSearchBox;
	public FlipkartSearchPage searchProductFlipkart(String product) {
		flipkartSearchBox.sendKeys(product);
		flipkartSearchBox.sendKeys(Keys.ENTER);
		
		return new FlipkartSearchPage();
	}
	
}
