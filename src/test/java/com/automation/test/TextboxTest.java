package com.automation.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextboxTest {

	WebDriver driver;
	WebDriverWait wait;

	@BeforeMethod
	public void testSetup() {
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		driver.get("https://testautomationcentral.com/demo/textboxes.html");
		driver.manage().window().maximize();
	}

	@Test
	public void testSimpleTextBox() {

		WebElement heading = driver.findElement(By.xpath("//div[@id= 'simple-textbox']//h3[text()= 'Simple Textbox']"));
		System.out.println("Heading Says: " + heading.getText());

		WebElement textBox = driver
				.findElement(By.xpath("//div[@id = 'simple-textbox'] // input[@placeholder = 'Enter text']"));
		textBox.sendKeys("Saurav Manandhar");

		for (int i = 0; i < 5; i++) {
			textBox.sendKeys(Keys.BACK_SPACE);
		}

		textBox.clear();

	}

	@Test

	public void testPassowrdTestBox() {
		
		WebElement passowrd_tab = driver.findElement(By.xpath("//button[@data-target = 'password-textbox' and text() = 'Password Textbox']"));
		passowrd_tab.click();
		
		WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id = 'password-textbox'] //h3[text() = 'Password Textbox']")));
		Assert.assertEquals(heading.getText(), "Password Textbox");
		System.out.println("Heading Says: " + heading.getText());
		
		WebElement passwordBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id = 'password-textbox'] //input[@type = 'password']")));
		passwordBox.sendKeys("Saurav@123");
		
		for(int i=0; i<5; i++) {
			passwordBox.sendKeys(Keys.SPACE);
		}
	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
