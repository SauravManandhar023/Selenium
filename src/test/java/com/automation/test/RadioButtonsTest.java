package com.automation.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class RadioButtonsTest {
	WebDriver driver = new ChromeDriver();
	
	@Test
	public void testRadiobtn() {
		
		driver.get("https://testautomationcentral.com/demo/radiobuttons.html");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//span[text() = 'Option A']")).click();
		driver.findElement(By.xpath("//span[text() = 'Option B']")).click();
		driver.findElement(By.xpath("//span[text() = 'Option C']")).click();
		
		driver.findElement(By.xpath("//span[text() = 'Styled Option A']")).click();
		driver.findElement(By.xpath("//span[text() = 'Styled Option B']")).click();
		driver.findElement(By.xpath("//span[text() = 'Styled Option C']")).click();
	}
	
	@AfterMethod
	public void tearDown() {
	    if (driver != null) {
	        driver.quit(); // Use quit instead of close
	    }
	}
}
