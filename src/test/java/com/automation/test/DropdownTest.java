package com.automation.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class DropdownTest {
	
	WebDriver driver = new ChromeDriver();
	
	@Test
	public void tesetDropdown() {
		
		driver.get("https://testautomationcentral.com/demo/dropdown.html");
		driver.manage().window().maximize();
		
		//Simple Drop-down
		WebElement simple_dropdown = driver.findElement(By.cssSelector("#simple-dropdown .form-select"));
		simple_dropdown.click();
		Select select = new Select(simple_dropdown);  //Without Select , Selenium only sees WebElement simple_drop-down, where you can only do click() and getText() // Once it is wrapped in Select, you unlock dropdown-specific methods: select by text, by value, by index
		select.selectByVisibleText("Option 2");
		
		
		//Styled Drop-down
		driver.findElement(By.xpath("//button[text() = 'Styled Dropdown']")).click();
		WebElement styled_dropdown = driver.findElement(By.cssSelector("#styled-dropdown .form-select"));
		styled_dropdown.click();
		Select select1 = new Select(styled_dropdown);
		select1.selectByValue("option3");
		
		//Multi-Select Drop-down
		driver.findElement(By.xpath("//button[text() = 'Multi-Select']")).click();
		WebElement multi_select_dropdown = driver.findElement(By.cssSelector(".form-multiselect"));
		multi_select_dropdown.click();
		Select select2 = new Select(multi_select_dropdown);
		select2.selectByIndex(0);
		select2.selectByIndex(1);
		select2.selectByIndex(2);
		select2.selectByIndex(3);
		select2.selectByIndex(4);
		
		//Grouped Drop-down
		driver.findElement(By.xpath("//button[text() = 'Grouped Dropdown']")).click();
		WebElement grouped_dropdown = driver.findElement(By.cssSelector("#grouped-dropdown .form-select"));
		grouped_dropdown.click();
		Select select3 =  new Select(grouped_dropdown);
		select3.selectByVisibleText("Option 1");
		select3.selectByVisibleText("Option 2");
		select3.selectByValue("option3");
		select3.selectByValue("option4");
		
		System.out.println(select3.isMultiple()); // Only single-selection, so false
		
	}
	
	@AfterMethod
	public void tearDown() {
		if(driver != null) {
			driver.quit();
		}
	}
}
