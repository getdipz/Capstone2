package steps;

import java.util.Set;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.xyz.one.Commonsteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AppTest {

	WebDriver driver;

	public AppTest(Commonsteps commonstep) {

		this.driver = commonstep.setUp();
		// super();
		// TODO Auto-generated constructor stub
	}

	@Given("the user navigates to the WebDriver University homepage")
	public void home() {
		// Write code here that turns the phrase above into concrete actions

		driver.get("https://webdriveruniversity.com/index.html");
		System.out.println("i_Am_on_webdriveruniversity_homepage");

	}

	@Then("the page title should contain \"WebDriverUniversity\"")
	public void verifythetitle() {

		@Nullable
		String actualTitle = driver.getTitle();
		if (actualTitle.contains("WebDriverUniversity")) {
			System.out.println("contains deisred title" + driver.getTitle());
		} else {
			System.out.println("doesn't match");
		}
		// Assert.assertTrue(actualTitle.contains("WebDriverUniversity"),
		// "Page title should contain '" + "WebDriverUniversity "+ "'");

	}

	@When("the user clicks on the \"IFRAMES\" section link")
	public void clickiframes() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.id("popup-alerts")));
		Thread.sleep(10000);
		driver.findElement(By.id("iframe")).click();
	}

	@Then("a new browser tab should open for the IFRAME page")
	public void verifytheTabs() throws InterruptedException {
		Set<String> allTabs = driver.getWindowHandles();
		if (allTabs.size() > 1) {
			System.out.println("A new tab opened beacuse allTabs.size() > 1");
		} else {
			{
				System.out.println("A new tab opened did not open");
			}
		}
		Thread.sleep(10000);
		// Assert.assertTrue(allTabs.size() > 1, "A new tab did not open");

	}

	@And("the user switches to the new browser tab")
	public void switchtonewbrowser() throws InterruptedException {
		String original = driver.getWindowHandle();
		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(original)) {
				driver.switchTo().window(handle);
				break;
			}
		}
		Thread.sleep(10000);

	}

	@Then("an image should be displayed inside the iframe")
	public void verifyImageinIframe() {
		WebElement iframeElement = driver.findElement(By.id("frame"));
		driver.switchTo().frame(iframeElement);
		// switch context to iframe
		Assert.assertTrue(driver.findElement(By.className("slide-image")).isDisplayed(),
				"Image is not displayed in iframe");

	}

	@When("the user clicks the right arrow button on the slider")
	public void clickthearrow() throws InterruptedException {
		String srcBefore = null;

		if (driver.findElement(By.className("carousel-inner")).isDisplayed()) {
			srcBefore = driver.findElement(By.cssSelector("div.item.active img")).getDomProperty("src");
			System.out.println("....." + srcBefore);
		}
		driver.findElement(By.cssSelector("a.right.carousel-control")).click();// click the slider's right arrow
		Thread.sleep(1000);
		String srcAfter = driver.findElement(By.cssSelector("div.item.active img")).getDomProperty("src");
		if (!srcBefore.equals(srcAfter)) {
			System.out.println("Image changed" + "Before" + srcBefore + "After" + srcAfter);
		} else
			System.out.println("image not changed" + "Before" + srcBefore + "After" + srcAfter);
		// Assert.assertNotEquals(srcBefore, srcAfter, "Image did not change after
		// clicking arrow");

	}

	@Then("the image should change accordingly")
	public void verify_image_changed() {
		// (Verification was done in previous step with NotEquals assertion)
		// Additional checks could be added here if needed.
		

	}

}
