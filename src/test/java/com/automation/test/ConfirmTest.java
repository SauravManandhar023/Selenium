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

public class ConfirmTest {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeMethod
	public void testSetup() {
		
		driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://testautomationcentral.com/demo/alerts.html");
		driver.manage().window().maximize();
		
	}
	 
	@Test
	public void testConfirm() {
		
		WebElement confirm_tab = driver.findElement(By.xpath("//button[text() = 'Confirm']"));
		confirm_tab.click();
		
		WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text() = 'Confirm']")));
		Assert.assertEquals(heading.getText(), "Confirm");
		
		WebElement confirm_button = driver.findElement(By.xpath("//div[@id='confirm-tab']//button[contains(text(), Confirm)]"));
		confirm_button.click();
		
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		System.out.println("System says: " + alert.getText());
		
		alert.accept();
		
		WebElement confirm_message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("confirm-message")));
		Assert.assertEquals(confirm_message.getText(), "Confirmed");
	}
	
	@Test
	public void testCancel() {
		
		WebElement confirm_tab = driver.findElement(By.xpath("//button[text() = 'Confirm']"));
		confirm_tab.click();
		
		WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text() = 'Confirm']")));
		Assert.assertEquals(heading.getText(), "Confirm");
		
		WebElement confirm_button = driver.findElement(By.xpath("//div[@id='confirm-tab']//button[contains(text(), Confirm)]"));
		confirm_button.click();
		
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		System.out.println("System says: " + alert.getText());
		
		alert.dismiss();
		
		WebElement cancel_message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("confirm-message")));
		Assert.assertEquals(cancel_message.getText(), "Cancelled");
	}
	
	@AfterMethod
	public void tearDown() {
	    if (driver != null) {
	        driver.quit(); // Use quit instead of close
	    }
	}
	
}
