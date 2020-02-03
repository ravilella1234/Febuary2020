package com.POM;

import org.testng.annotations.Test;

import com.excelLibraries.BaseTest;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class POM_001 extends BaseTest
{
 
  @BeforeTest
  public void startProcess() throws Exception 
  {
	  init();
	  launchBrowser("chromebrowser");
	  launchUrl("automationurl");
  }
  
  
  @Test
  public void login() 
  {
	  driver.findElement(By.xpath("//a[@class='login']")).click();
	  driver.findElement(By.id("email")).sendKeys("qatest847584787@gmail.com");
	  driver.findElement(By.id("passwd")).sendKeys("password");
	  driver.findElement(By.xpath("//p[@class='submit']//span[1]")).click();
	  String actualElement = driver.findElement(By.xpath("//li[contains(text(),'Authentication failed.')]")).getText();
	  String expectedElement="Authentication failed";
	  Assert.assertEquals(actualElement, expectedElement);
  }

  @AfterTest
  public void endProcess() 
  {
	  
  }

}
