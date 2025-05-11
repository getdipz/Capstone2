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

public class NewTest {
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
		
		driver.get("https://www.autify.com");
		Thread.sleep(10000);
		String parentHandle = driver.getWindowHandle();
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(By.id("w-dropdown-toggle-1"));
		action.moveToElement(we).moveToElement(we).build().perform();

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Autify Nexus"))).click();

		
	}
	@Test(priority=2, groups= {"smoke"})
	public void f2() throws InterruptedException 
	{
		        // Switch to New Tab:
				wait.until(ExpectedConditions.numberOfWindowsToBe(2));

				Object[] windowHandles = driver.getWindowHandles().toArray();
				driver.switchTo().window((String) windowHandles[1]);
				// assert on title of new window
				String title = driver.getTitle();
				System.out.println("Title is" + title);
				// assertEquals("Simple Page",title);

				childURL = driver.getCurrentUrl();
				Childtitle = driver.getTitle();
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='submit']"))).click();
				Thread.sleep(5000);
				// Error Checks:
				String[] expectedErrors = { "First name can't be blank", "Last name can't be blank",
						"Company name can't be blank", "Password cannot be blank", "Email can't be blank",
						"Please complete this required field." };

				List<WebElement> list = driver.findElements(By.cssSelector("label.hs-error-msg.hs-main-font-element"));
				softAssert = new SoftAssert(); 
				for (WebElement singleerror : list) {
					  
					  softAssert.assertEquals(singleerror.getText(), expectedErrors[i], "doesn't match");
					  i++;



					/*
					 * if (singleerror.getText().equals(expectedErrors[i])) {
					 * 
					 * System.out.println("Matches" + " Expected:" + expectedErrors[i] + " Actual:"
					 * + singleerror.getText()); i++; } else { System.out.println( "Doesn't match" +
					 * "Expected:" + expectedErrors[i] + " Actual:" + singleerror.getText()); i++; }
					 */
				}
				softAssert.assertEquals(driver.findElement(By.className("hs-main-font-element")).getText(), expectedErrors[i],"Doesn't match");
				driver.close();
				driver.switchTo().window((String) windowHandles[0]);
				System.out.println("Switched to main Tab");
				
			
				softAssert.assertAll();
			
				

	}
	@AfterSuite
	public void aftersuite()
	{
		
		driver.close();
		System.out.println("Aftersuite");
	}
	

}
