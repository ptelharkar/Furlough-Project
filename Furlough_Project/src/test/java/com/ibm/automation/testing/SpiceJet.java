package com.ibm.automation.testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SpiceJet {
	
	WebDriver driver;
	@BeforeMethod
	public void Launch()
	{
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://spicejet.com");
		
	}
	
	@AfterMethod
	public void Close()
	{
		
		driver.quit();
		
	}
	@Test
	public void selectCity() throws InterruptedException
	{
		
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).clear();
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).sendKeys("PNQ");
		driver.findElement(By.linkText("Delhi (DEL)")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//td[@data-month='0']/a[text()='3']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='Div1']/button")).click();
		driver.findElement(By.xpath("//td[@data-month='0']/a[text()='10']")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("divpaxinfo")).click();
		Select adult=new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Adult")));
		adult.selectByValue("2");
		Select child=new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Child")));
		child.selectByIndex(1);
		Select infant=new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Infant")));
		infant.selectByVisibleText("1");
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(1000);
		Select currency=new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
		currency.selectByValue("INR");
		Thread.sleep(1000);
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
		
	
	}
	
}
