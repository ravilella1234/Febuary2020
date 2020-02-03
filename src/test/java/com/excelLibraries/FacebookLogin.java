package com.excelLibraries;

import org.openqa.selenium.By;



public class FacebookLogin extends BaseTest
{

	public static void main(String[] args) throws Exception 
	{
		ExcelAPI e1=new ExcelAPI("C:\\Users\\DELL\\Desktop\\testdata.xlsx");
		
		init();
		launchBrowser("chromebrowser");
		launchUrl("facebookurl");
		
		for(int i=1;i<e1.getRowCount("login");i++)
		{
			driver.findElement(By.id("email")).clear();
			driver.findElement(By.id("email")).sendKeys(e1.getCellData("login", "UserName", i));
			
			driver.findElement(By.id("pass")).clear();
			driver.findElement(By.id("pass")).sendKeys(e1.getCellData("login", "Password", i));
			
			Thread.sleep(3000);
		}
		
	
	}

}
