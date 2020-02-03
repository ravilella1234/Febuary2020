package com.excelLibraries;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestA 
{

	@Test(dataProvider="getData")
	public void testB(String RunMode,String col1,String col2,String col3)
	{
		System.out.println("test method....");
	}
	
	@DataProvider
	public Object[][] getData() throws Exception{
		
		System.out.println("Data provider....");
		ExcelAPI e=new ExcelAPI("C:\\Users\\DELL\\Desktop\\SuiteA.xlsx");
		String sheetName="data";
		String testCaseName="TestA";
		
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
		Object[][] data=new Object[rows][cols];
		
		for(int rNum=dataStartRowNum;rNum<dataStartRowNum+rows;rNum++)
		{
			for(int cNum=0;cNum<cols;cNum++) 
			{
				data[dataRow][cNum]=e.getCellData(sheetName, cNum, rNum);	
			}
			dataRow++;
		}
		return data;
	}
	

}
