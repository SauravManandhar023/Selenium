package com.automation.test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrowserNavigationTest {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeMethod
	public void testSetup() {
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		driver.get("https://testautomationcentral.com/demo/browser_navigation.html");
		driver.manage().window().maximize();
	}
	
	@Test
	public void testBrowserNavigation() throws InterruptedException {
		
		//1. Refresh the current page
		driver.navigate().refresh();
		Assert.assertTrue(driver.getCurrentUrl().contains("navigation.html"));  //One way
		Thread.sleep(2000);
		
		//2. Navigate to new page
		driver.navigate().to("https://www.saurav-manandhar.com.np");
		boolean correctPage = driver.getCurrentUrl().contains("saurav");  //Another way
		
		if(correctPage) {
			System.out.println("Navigated to Saurav Manandhar page...");
		}else {
			System.out.println("Navigation failed");
		}
		Thread.sleep(2000);
		
		//3. Go back to previous page
		driver.navigate().back();
		
		//4. Again forward to the previous page
		driver.navigate().forward();
		
	}
}
