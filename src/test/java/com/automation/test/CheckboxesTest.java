package com.automation.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class CheckboxesTest {
	
	WebDriver driver = new ChromeDriver();
	
	@Test
	public void testCheckbox() {
		
		
		driver.get("https://testautomationcentral.com/demo/checkboxes.html");
		driver.manage().window().maximize();
		
		WebElement Option1 = driver.findElement(By.xpath("//span[text() = 'Option 1']"));
		Option1.click();  //Check
		Option1.click();  //Un-check
		
		WebElement Option2 = driver.findElement(By.xpath("//span[text() = 'Option 2']"));
		Option2.click();
		Option2.click();
		
		
		WebElement Option3 = driver.findElement(By.xpath("//span[text() = 'Option 3']"));
		Option3.click();
		
		WebElement StyleOption1 = driver.findElement(By.xpath("//span[text() = 'Styled Option 1']"));
		StyleOption1.click();
		
		driver.findElement(By.xpath("//span[text() = 'Styled Option 2']")).click();
		

		driver.findElement(By.xpath("//span[text() = 'Styled Option 3']")).click();
	}
	
	@AfterMethod
	public void tearDown() {
		if(driver != null) {
			driver.quit();
		}
	}
}
