package com.aj.common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aj.global.SeleniumBaseTest;



public class CustomWait extends SeleniumBaseTest {
	static WebDriver driver = (WebDriver) getWebDriver();

	
		
	@SuppressWarnings("unchecked")
	public static WebElement waitForWebElementElementToBeVisible(WebElement element) {

		
		FluentWait fluentWait = new FluentWait(driver).withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(3, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.visibilityOf(element));
		return element;

	}
	
	
}