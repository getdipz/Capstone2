package com.dez.learn;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.util.List;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions; 
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import org.testng.asserts.SoftAssert;

public class NewTest2 {
	WebDriver driver;
	int i = 0;
	private @Nullable String childURL;
	private @Nullable String Childtitle;
	 SoftAssert softAssert ;
	 WebDriverWait wait;
	
	 @BeforeSuite
	 public void beforesuite()
	 {
		 System.setProperty("webdriver.gecko.driver", "/Users/kulkarnid/Documents/Drivers/geckodriver");
		driver = new FirefoxDriver() ;
	 }

	@Test(priority= 1 , groups={"smoke"})
	public void f() throws InterruptedException {
		System.out.println("This is a basetest in ");
		// System.setProperty("webdriver.chrome.driver",
		// "/Users/kulkarnid/Documents/Drivers/chromedriver");
		
		driver.get("http://webdriveruniversity.com/index.html");
		System.out.println(driver.getTitle());

		
	}
	

}
