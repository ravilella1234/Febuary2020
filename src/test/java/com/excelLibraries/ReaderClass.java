package com.excelLibraries;

import org.openqa.selenium.By;

public class ReaderClass extends BaseTest
{

	public static void main(String[] args) throws Exception 
	{
		ExcelAPI e1=new ExcelAPI("C:\\Users\\DELL\\Desktop\\testdata.xlsx");
		//System.out.println(e1.getCellData("login", 1, 3));
		//System.out.println(e1.getCellData("login", "UserName", 2));
		//e1.setCellData("login", 4, 3, "passed");
		
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
