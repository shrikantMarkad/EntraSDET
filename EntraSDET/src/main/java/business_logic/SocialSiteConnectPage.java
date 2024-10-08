package business_logic;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SocialSiteConnectPage {
	
WebDriver driver = null;
	
	public SocialSiteConnectPage(WebDriver test_driver) {
		driver = test_driver;
	}
		
	
	public void navigateTowindowAndAddDetails(String email, String password) {
		String parenHandle=driver.getWindowHandle();
		Set<String> set = driver.getWindowHandles();
		Iterator<String> iter= set.iterator();

		while(iter.hasNext())
		{

		String child_window=iter.next();

		if(!parenHandle.equals(child_window))
		{
		driver.switchTo().window(child_window);

		System.out.println(driver.switchTo().window(child_window).getTitle());
		
		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(By.name("email-or-phone")));
		Assert.assertEquals(driver.getTitle(), "Sign Up | LinkedIn");
		driver.findElement(By.name("email-or-phone")).sendKeys(email);
		driver.findElement(By.name("password")).sendKeys(password);

		driver.close();
		
		driver.switchTo().window(parenHandle);
		}
		}
	}

}
