package com.automation.test;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertsTest {
	WebDriver driver = new ChromeDriver();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
	
	@BeforeMethod
	
	public void testSetup() {
		driver.get("https://testautomationcentral.com/demo/alerts.html");
		driver.manage().window().maximize();
	}
	 
	@Test
	
	public void testAlert() {
		WebElement heading = driver.findElement(By.xpath("//h3[text() = 'Alert']"));
		Assert.assertEquals(heading.getText(), "Alert");
		
		WebElement alert_button = driver.findElement(By.xpath("//button[text() = 'Show Alert']"));
		alert_button.click();
		
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		System.out.println("Alert Message:" + alert.getText());
		
		alert.accept();
		
		WebElement alert_message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("alert-message")));
		System.out.println("Message: " + alert_message.getText());
		Assert.assertEquals(alert_message.getText(), "Alert displayed");
	}
	
	@AfterMethod
	public void tearDown() {
	    if (driver != null) {
	        driver.quit(); // Use quit instead of close
	    }
	}

}
