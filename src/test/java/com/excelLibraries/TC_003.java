package com.excelLibraries;

import org.testng.annotations.Test;

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;

public class TC_003 
{
	WebDriver driver;
	
  @Test(dataProvider = "dp")
  public void f(Hashtable<String, String> data) 
  {
	 if(data.get("Runmode").equals("Y"))
		 System.out.println(data.get("UserName"));
	 	System.out.println(data.get("UserPassword"));
		 // throw new SkipException("Run mode set to no...");
	  
		  //System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//drivers//chromedriver.exe"); 
	  	  //driver=new ChromeDriver();
		  //driver.manage().window().maximize(); 
			
			//driver.get("https://www.facebook.com");	
			//driver.findElement(By.id("email")).sendKeys(data.get("col2"));
			//driver.findElement(By.id("pass")).sendKeys(data.get("col3"));
  }

  @DataProvider
  public Object[][] dp() throws Exception 
  {
	  System.out.println("iam data provider....");
	  ExcelAPI e=new ExcelAPI("C:\\Users\\DELL\\Desktop\\SuiteA.xlsx");
		String sheetName="data";
		String testCaseName="LoginTest";
		
		int testStartRowNum=0;
		while(!e.getCellData(sheetName, 0, testStartRowNum).equals(testCaseName)) 
		{
			testStartRowNum++;
		}
		System.out.println("Test Starts from row :-  " + testStartRowNum);
		
		
		int colStartRowNum=testStartRowNum+1;
		int dataStartRowNum=testStartRowNum+2;
		
		//calculate rows of data
		int rows=0;
		while(!e.getCellData(sheetName, 0, dataStartRowNum+rows).equals("")) 
		{
			rows++;
		}
		System.out.println("Total rows are :-  "+ rows);
		
		//Calculate total Columns
		int cols=0;
		while(!e.getCellData(sheetName, cols, colStartRowNum).equals("")) 
		{
			cols++;
		}
		System.out.println("Total Cols are :-  "+ cols);
		
		
		//read the data
		int dataRow=0;
		Object[][] data=new Object[rows][1];
		
		Hashtable<String,String> table=null;
		for(int rNum=dataStartRowNum;rNum<dataStartRowNum+rows;rNum++)
		{
			table=new Hashtable<String,String>();
			for(int cNum=0;cNum<cols;cNum++) 
			{
				//System.out.println(e.getCellData(sheetName, cNum, rNum));
				//data[dataRow][cNum]=e.getCellData(sheetName, cNum, rNum);
				String key=e.getCellData(sheetName, cNum, colStartRowNum);
				String value=e.getCellData(sheetName, cNum, rNum);
				table.put(key, value);
			}	
			data[dataRow][0]=table;
			dataRow++;
		}
		return data;	 
  }
}
