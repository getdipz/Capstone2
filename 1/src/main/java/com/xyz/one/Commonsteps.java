package com.xyz.one;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Commonsteps {

	WebDriver driver;
	
	
	public WebDriver setUp()
	{
		System.setProperty("ebdriver.firefox.driver", "webdrivers/geckodriver");
		driver=new FirefoxDriver();
		driver.get("https://webdriveruniversity.com/index.html");
		System.out.println("i_Am_on_webdriveruniversity_homepage");
		return driver;
	}
	

	public void teardown() throws InterruptedException
	{
		driver.quit();
		Thread.sleep(1000);
		
	}
	

}