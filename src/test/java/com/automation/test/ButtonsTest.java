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

public class ButtonsTest {
	
	WebDriver driver;
	
	@BeforeMethod
	public void testSetup() {
		driver =  new ChromeDriver();
		driver.get("https://testautomationcentral.com/demo/buttons.html");
	}
	

    @Test
    public void testBasicButton() {

        driver.findElement(By.xpath("//button[text() = 'Click Me']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement message = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("basic-message"))
        );

        String actualText = message.getText();
        String expectedText = "Basic button clicked";

        Assert.assertEquals(actualText, expectedText);

    }
    
    @Test
    
    public void testSubmitButton() {
    	
    	driver.findElement(By.xpath("//button[text() = 'Submit Button']")).click();
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    	
    	WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text() ='Submit Button']")));
    	Assert.assertEquals(heading.getText(), "Submit Button");
    	
    	driver.findElement(By.xpath("//button[text() = 'Submit']")).click();
    	
    	WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submit-message")));
    	Assert.assertEquals(message.getText(), "Submit button clicked");
    }
    
    @Test
    
    public void testResetButton() {
    	
    	driver.findElement(By.xpath("//button[text() = 'Reset Button']")).click();
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    	
    	WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text() = 'Reset Button']")));
    	Assert.assertEquals(heading.getText(), "Reset Button");
    	
    	driver.findElement(By.xpath("//button[text() = 'Reset']")).click();
    	
    	WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("reset-message")));
    	Assert.assertEquals(message.getText(), "Reset button clicked");
    	
    }
    
    @AfterMethod
	public void tearDown() {
		if(driver != null) {
			driver.quit();
		}
	}
}