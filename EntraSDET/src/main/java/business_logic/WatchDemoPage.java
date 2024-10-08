package business_logic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class WatchDemoPage {
	
WebDriver driver = null;
	
	public WatchDemoPage(WebDriver test_driver) {
		driver = test_driver;
	}
	
	public void FillDemoDetails(String fname, String lname, String email, String comp, String phone) {
		driver.findElement(By.id("FirstName")).sendKeys(fname);
		driver.findElement(By.id("LastName")).sendKeys(lname);
		driver.findElement(By.id("Email")).sendKeys(email);
		driver.findElement(By.id("Company")).sendKeys(comp);
		driver.findElement(By.id("Phone")).sendKeys(phone);
		Select objSelect = new Select(driver.findElement(By.id("Unit_Count__c")));
		objSelect.selectByValue("11 - 100");
		driver.findElement(By.id("Title")).sendKeys("SDET");
		Select demoSelect = new Select(driver.findElement(By.id("demoRequest")));
		demoSelect.selectByValue("an Owner/Operator or Property Manager");
	}

}
