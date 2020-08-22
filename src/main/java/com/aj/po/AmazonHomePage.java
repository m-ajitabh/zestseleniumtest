package com.aj.po;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aj.common.CustomWait;
import com.aj.global.SeleniumBasePage;


public class AmazonHomePage extends SeleniumBasePage {

	@FindBy(id = "twotabsearchtextbox")
	public static WebElement searchBox;
	public AmazonSearchPage searchProductAmazon(String search) {
		CustomWait.waitForWebElementElementToBeVisible(searchBox).sendKeys(search);
		searchBox.sendKeys(Keys.ENTER);
		
		return new AmazonSearchPage();
	}

	
}
