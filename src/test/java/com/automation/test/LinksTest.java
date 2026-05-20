package com.automation.test;

import java.time.Duration;

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

public class LinksTest {

	WebDriver driver;

	@BeforeMethod

	public void testSetup() {
		driver = new ChromeDriver();
		driver.get("https://testautomationcentral.com/demo/links.html");
		driver.manage().window().maximize();
	}

	@Test
	public void testBasicLink() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// 1. Wait for the link to be CLICKABLE, not just present
		// This ensures Selenium waits for animations to finish
		WebElement clickMeLink = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='basic-link']//a[text() = 'Click Me']")));

		clickMeLink.click();
		System.out.println("Link clicked successfully!");

		// 2. Now wait for the message text
		boolean isTextCorrect = wait.until(
				ExpectedConditions.textToBePresentInElementLocated(By.id("basic-message"), "Basic link clicked"));

		Assert.assertTrue(isTextCorrect, "The message text did not update!");
	}
	
	@AfterMethod
	public void tearDown() {
		if(driver != null) {
			driver.quit();
		}
	}
}
