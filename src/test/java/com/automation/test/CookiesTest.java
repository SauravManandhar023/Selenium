package com.automation.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CookiesTest {

	WebDriver driver;
	WebDriverWait wait;

	@BeforeMethod

	public void testSetup() {

		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		driver.get("https://testautomationcentral.com/demo/cookies.html");
		driver.manage().window().maximize();

	}

	@Test

	public void testSetCookies() {

		WebElement heading = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@id = 'set-cookie-tab'] //h3[text() = 'Set Cookie']")));
		Assert.assertEquals(heading.getText(), "Set Cookie");

		WebElement setCookie_btn = driver
				.findElement(By.xpath("//div[@id='set-cookie-tab'] //button[text() = 'Set Cookie']"));
		setCookie_btn.click();

		WebElement msg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("set-cookie-message")));
		boolean isCookieSet = msg.getText().equals("Cookie set");

		if (isCookieSet) {
			System.out.println("Cookie has been set.");

			Cookie cookie = driver.manage().getCookieNamed("testCookie");
			System.out.println("Cookie Name: " + cookie.getName());
			System.out.println("Cookie Value: " + cookie.getValue());

		} else {
			System.out.println("No Cookies Set");
		}

	}
	
	@Test
	public void testGetCookie() {
		
		// Manually inject the cookie first since each test has fresh driver
	    Cookie cookie_set = new Cookie("testCookie", "Saurav%20Manandhar");
	    driver.manage().addCookie(cookie_set);
	    driver.navigate().refresh(); // refresh so page recognizes the cookie
	    
		
		WebElement getCookieTab = driver.findElement(By.xpath("//button[@data-target = 'get-cookie-tab']"));
		getCookieTab.click();
		
		WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id = 'get-cookie-tab'] //h3[text() = 'Get Cookie']")));
		boolean isVisible = heading.getText().equals("Get Cookie");
		
		if(isVisible) {
			System.out.println("Get Cookie visible");
		}else {
			System.out.println("Get Cookie not visible");
		}
	    
		WebElement getCookie_btn = driver.findElement(
		        By.xpath("//div[@id='get-cookie-tab']//button[contains(text(),'Get')]"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", getCookie_btn);
		
		WebElement msg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("get-cookie-message"))); // here cookie value is; Saurav Manandhar
		
		Cookie cookie_get = driver.manage().getCookieNamed("testCookie");
		String cookie_value = cookie_get.getValue(); // here cookie value is "Saurav%20Manandhar"
		
		String decoded_value = cookie_value.replace("%20", " "); //Saurav Manandhar
		
		boolean isTrue = msg.getText().contains(decoded_value);
		
		if(isTrue) {
			System.out.println("Cookie Name: " + cookie_get.getName());
			System.out.println("Cookie Value: " + cookie_get.getValue());
			System.out.println("Cookie Domain: " + cookie_get.getDomain());
		}else {
			System.out.println("No cookie");
		}
		
		
	}

}
