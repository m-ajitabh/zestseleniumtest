package com.aj.global;


import java.io.File;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aj.common.CustomProperties;



public class SeleniumBaseTest{

	protected static WebDriver driver;
	public static String currDirectory = new File(System.getProperty("user.dir")).getAbsolutePath();
	private static String HUB_URL;
	private static String BROWSER;
	
	
	static String url;
	public static WebDriver getWebDriver(){
		
		return driver;
	}
	
	@BeforeClass
	public static void launchWebDriver(){
		
		HUB_URL = CustomProperties.getConfigProperty("HUB_URL");
		BROWSER = CustomProperties.getConfigProperty("browser");
		String ss = CustomProperties.getConfigProperty("browser");
		
		DOMConfigurator.configure("log4j.xml");
		if(CustomProperties.getConfigProperty("browser").equalsIgnoreCase("firefox")){
			
			driver = new FirefoxDriver();
		}else if(CustomProperties.getConfigProperty("browser").equalsIgnoreCase("chrome")){
			File file = new File(currDirectory + File.separator + "chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("test-type");

			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
			driver = new ChromeDriver(capabilities);
			
		}else if(CustomProperties.getConfigProperty("browser").equalsIgnoreCase("ie")){
			driver = new InternetExplorerDriver();
		}
	
		//driver.navigate().to(url);
		driver.manage().window().maximize();
		

		//return driver;
	}
	
	@AfterTest
	public static void quit(){
		driver.close();
	}
}
