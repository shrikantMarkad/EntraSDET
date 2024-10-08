package business_logic;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage{
	
	WebDriver driver = null;
	
	public HomePage(WebDriver test_driver) {
		driver = test_driver;
	}
	
	String home_demo = "//div[@class='button-text'][normalize-space()='Watch Demo']";
	String linedin = "//div[@class='social-wrapper']/a[contains(@href, 'linkedin')]/img";
	String signIn = "//section[@class='main-section hp']//a[normalize-space()='Sign In']";
	
	public void clickWatchDemo() {
		WebElement demo_button = driver.findElement(By.xpath(home_demo));
		Actions action = new Actions(driver);
		action.moveToElement(demo_button).click().build().perform();
	}
	
	public void clickToJoinLinkedInNetwork() {
		
		WebElement element = driver.findElement(By.xpath(linedin));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(linedin)))).click();
	}
	
	public void verifyHomePageAndSignIn() {
		Assert.assertEquals(driver.getTitle(), "Property Management Software | Entrata");
		//new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(signIn)))).click();
	}
	
	

}
