package com.excelLibraries;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TC_004 extends BaseTest
{
	
	  @Test(dataProvider = "getData")
	  public void f(Hashtable<String, String> data) 
	  {
		  System.out.println("iam test method.....");
	  }
	  
	  @DataProvider
	  public Object[][] getData()
	  {
		  System.out.println("iam data provider......");
		return DataUtils.getTestData("data", "TestB");
		  
	  }
}
