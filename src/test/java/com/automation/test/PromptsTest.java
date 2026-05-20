package com.automation.test;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PromptsTest {
	WebDriver driver = new ChromeDriver();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

	@BeforeMethod
	public void testSetup() {
		driver.get("https://testautomationcentral.com/demo/alerts.html");
		driver.manage().window().maximize();
	}

	@Test
	public void testPromptAccept() {
		
		String name = "Saurav Manandhar";
		
		WebElement prompt_tab = driver.findElement(By.xpath("//button[text() = 'Prompt']"));
		prompt_tab.click();

		WebElement heading = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text() = 'Prompt']")));
		Assert.assertEquals(heading.getText(), "Prompt");

		WebElement prompt_btn = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@id='prompt-tab']//button[contains(text(), 'Prompt')]")));
		
		// Use JS click instead of normal click
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", prompt_btn);
		
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.sendKeys(name);

		alert.accept();
		
		WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("prompt-message")));
		Assert.assertEquals(message.getText(), "You entered: "+name);
	}
	
	@Test
	public void testPromptDecline() {
		
		WebElement prompt_tab = driver.findElement(By.xpath("//button[text() = 'Prompt']"));
		prompt_tab.click();

		WebElement heading = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text() = 'Prompt']")));
		Assert.assertEquals(heading.getText(), "Prompt");

		WebElement prompt_btn = wait.until(ExpectedConditions
		        .visibilityOfElementLocated(By.xpath("//div[@id='prompt-tab']//button[contains(text(), 'Prompt')]")));

		// Use JS click instead of normal click
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", prompt_btn);

		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.dismiss();
		
		WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("prompt-message")));
		Assert.assertEquals(message.getText(), "Prompt was cancelled");
	}
	
	@AfterMethod
	public void tearDown() {
	    if (driver != null) {
	        driver.quit(); // Use quit instead of close
	    }
	}
	
	
}
