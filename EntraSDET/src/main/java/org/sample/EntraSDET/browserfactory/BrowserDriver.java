package org.sample.EntraSDET.browserfactory;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import io.github.bonigarcia.wdm.managers.EdgeDriverManager;
import io.github.bonigarcia.wdm.managers.FirefoxDriverManager;
import io.github.bonigarcia.wdm.managers.SafariDriverManager;
import utils.ConfigReader;

public class BrowserDriver {
	
	public static WebDriver createInstance() {
        WebDriver driver = null;
        String test_browser = null;
        ConfigReader config = ConfigReader.getInstance();
        test_browser = config.getBrowser();
        switch(test_browser) {
            case "chrome":
            	ChromeOptions chromeOptions = new ChromeOptions();
        		WebDriverManager.chromedriver().setup();
            	driver = new ChromeDriver(chromeOptions);
            	break;
            case "firefox":
            	FirefoxOptions firefoxOptions = new FirefoxOptions();
        		WebDriverManager.firefoxdriver().setup();
            	driver = new FirefoxDriver(firefoxOptions);
            	break;
        } 

        driver.get(config.getBaseUrl());       
        driver.manage().window().maximize();
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("cookie-accept")))).click();
		return driver;
    }

}
