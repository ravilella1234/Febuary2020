package com.frames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FrameDemo 
{
	WebDriver driver;
	
	@Test
	public void frame() throws InterruptedException 
	{
		driver=new ChromeDriver();
		driver.get("https://selenium.dev/selenium/docs/api/java/");
		driver.manage().window().maximize();
		
		driver.switchTo().frame(0);
		//driver.switchTo().frame(driver.findElement(By.name("packageListFrame")));
		driver.findElement(By.linkText("com.thoughtworks.selenium")).click();
		driver.switchTo().defaultContent();
		
		Thread.sleep(2000);
		
		driver.switchTo().frame(1);
		driver.findElement(By.xpath("//span[contains(text(),'Selenium')]")).click();
		driver.switchTo().defaultContent();

	}

}
