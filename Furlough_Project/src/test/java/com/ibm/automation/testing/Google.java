package com.ibm.automation.testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Google {
	
	WebDriver driver;
	@BeforeMethod(alwaysRun=true)
	public void bm()
	{
		
		//driver=new FirefoxDriver();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://google.com");
		
		
	}

	@AfterMethod(alwaysRun=true)
	public void am()
	{
		driver.quit();
		
	}

  @Test
  public void googleSearch() {
	  driver.findElement(By.name("q")).sendKeys("Jenkins");
	  driver.findElement(By.className("gNO89b")).click();
  }
}
