package com.ibm.automation.testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Magento {
  
	WebDriver driver;
	@BeforeMethod(alwaysRun=true)
	public void bm()
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Training_Selenium\\Drivers\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://magento.com");
		
		
	}

	@AfterMethod(alwaysRun=true)
	public void am()
	{
		driver.quit();
		
	}

	
	@Test
	public void register()
	{
		driver.findElement(By.className("fa-user")).click();
		driver.findElement(By.xpath("//span[text()='Register']")).click();
		
		driver.findElement(By.id("firstname")).sendKeys("Prakash");
		driver.findElement(By.id("lastname")).sendKeys("Telharkar");
		
	}

	@Test(dependsOnMethods= {"register"},priority=0)
	public void positiveLogin()
	{
		driver.findElement(By.className("fa-user")).click();
		driver.findElement(By.id("email")).sendKeys("ptelharkar@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Welcome@123");
		driver.findElement(By.id("send2")).click();
		driver.findElement(By.linkText("Log Out")).click();
	}

	@Test
	public void negativeLogin() throws InterruptedException
	{
		driver.findElement(By.className("fa-user")).click();
		driver.findElement(By.id("email")).sendKeys("prakash@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Welcome1");
		driver.findElement(By.id("send2")).click();
		Thread.sleep(5000);
		Assert.assertEquals(driver.findElement(By.className("error-msg")).getText(), "Invalid login or password.");
			
	}

}
