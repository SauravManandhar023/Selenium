package com.automation.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FrameandIFramesTest {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeMethod
	
	public void testSetup() {
		
		driver =  new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		driver.get("https://testautomationcentral.com/demo/frames_iframes.html");
		driver.manage().window().maximize();
		
	}
	
	@Test
	
	public void testIFrames() {
		
		WebElement iframe = driver.findElement(By.xpath("//div[@id = 'frame-tab'] //iframe"));
		driver.switchTo().frame(iframe);
		
		WebElement heading = driver.findElement(By.tagName("h1"));
		boolean isTrue = heading.getText().equals("Example Domain");
		
		if(isTrue) {
			System.out.println("Iframe Heading Located...");
		}else {
			System.out.println("Failed to Switch to IFrame");
		}
		
		driver.findElement(By.xpath("//a[text() = 'Learn more']")).click();
		
		//Switch back to main page
		
		driver.switchTo().defaultContent();
		
		WebElement iframe_active = driver.findElement(By.id("frame-tab"));
		String classValue = iframe_active.getAttribute("class");
		System.out.println("Class: " + classValue);
		
		Assert.assertEquals(classValue, "tab-content active");
		
	}
	
	@AfterMethod
	
	public void tearDown() {
		if(driver != null) {
			driver.quit();
		}
	}

}
