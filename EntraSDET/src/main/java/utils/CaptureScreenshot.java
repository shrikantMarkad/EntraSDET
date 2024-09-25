package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

public class CaptureScreenshot {
	
	public static WebDriver driver = null;
	public void getDriverInstance(WebDriver driver_ins) {
		driver = driver_ins;
	}
	
	public String takeScreenshot(ITestResult result) {
		System.out.println("Test "+result.getMethod().getMethodName()+" failed therefore taking screenshot");
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String fileName = System.getProperty("user.dir")+"/allure-results/"+result.getMethod().getMethodName()+".jpg";
		try {
			FileUtils.copyFile(src, new File(fileName));
		}catch(IOException ex){
			ex.printStackTrace();
			
		}
		return fileName;
		
	}	

}
