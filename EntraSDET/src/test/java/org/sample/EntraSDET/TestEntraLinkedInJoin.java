package org.sample.EntraSDET;

import org.openqa.selenium.WebDriver;
import org.sample.EntraSDET.browserfactory.BrowserDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import business_logic.HomePage;
import business_logic.SocialSiteConnectPage;
import utils.AllureTestListner;

@Listeners(AllureTestListner.class)
public class TestEntraLinkedInJoin {
	
    WebDriver driver = BrowserDriver.createInstance();
	HomePage homePage = new HomePage(driver);
	SocialSiteConnectPage socialPage = new SocialSiteConnectPage(driver);

	@Test
	public void testLinkedInSocialForEntra() {

		Assert.assertEquals(driver.getTitle(), "Property Management Software | Entrata");
		homePage.clickToJoinLinkedInNetwork();
		socialPage.navigateTowindowAndAddDetails("markad.shrikant@gmailcom", "@12345");
		homePage.verifyHomePageAndSignIn();
	}
	

	 @AfterMethod 
	 public void postCondition(){ 
		 driver.quit(); 
		 }
	 

}
