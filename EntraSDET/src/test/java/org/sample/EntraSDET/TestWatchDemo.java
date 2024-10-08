package org.sample.EntraSDET;

import org.openqa.selenium.WebDriver;
import org.sample.EntraSDET.browserfactory.BrowserDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import business_logic.HomePage;
import business_logic.WatchDemoPage;
import utils.AllureTestListner;
import utils.CaptureScreenshot;


@Listeners(AllureTestListner.class)
public class TestWatchDemo {

	WebDriver driver = BrowserDriver.createInstance();
	HomePage homePage = new HomePage(driver);
	WatchDemoPage demoPage = new WatchDemoPage(driver);

	@Test
	public void testWatchDemo() {

		Assert.assertEquals(driver.getTitle(), "Property Management Software | Entrata");
		homePage.clickWatchDemo();
		Assert.assertEquals(driver.getTitle(), "Entrata | Optimize Property Management with One Platform");
		demoPage.FillDemoDetails("Shrikant", "Markad", "markad.shrikant@gmail.com", "ACL", "9890146266");
	}

	
	 @AfterMethod 
	 public void postCondition(){ 
		 driver.quit(); 
		 } 
	 
}
