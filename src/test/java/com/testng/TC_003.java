package com.testng;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.excelLibraries.BaseTest;
import com.relevantcodes.extentreports.LogStatus;

public class TC_003 extends BaseTest
{
	
	@BeforeMethod(groups = {"regression"})
	@Parameters("browser")
  public void startProcess(String btype) throws Exception 
  {
	  System.out.println("before Test.....");
	  
	    init();
		test=report.startTest("TC_003");
		test.log(LogStatus.INFO, "initializing the Properties files (data, or, envronments, log4jconfig) ........");
		
		launchBrowser(btype);
		test.log(LogStatus.INFO, "Opened the browser :- " + p.getProperty("chromebrowser"));
		
		launchUrl("amazonurl");
		test.log(LogStatus.INFO, "Navigated to URl :- " + p.getProperty("amazonurl"));
  }
  
  
  @Test(groups = {"regression"})
  public void amazon() 
  {
	  System.out.println("amazon Test.....");
	  
	  	selectDropItem("amazondropbox_id","amazondropvalue");
		test.log(LogStatus.PASS, "Selected the option :- " + or.getProperty("amazondropvalue") + " by using the locator:- " + or.getProperty("amazondropbox_id"));
		
		typeValue("amazonsearchtext_name","amazonsearchtext");
		test.log(LogStatus.FAIL, "Entered the text :- " + or.getProperty("amazonsearchtext") + " by using the locator :- " + or.getProperty("amazonsearchtext_name"));
		
		
		clickElement("amazonsearchbutton_xpath");
		test.log(LogStatus.SKIP, "Clicked on Element by using the Locator :- " + or.getProperty("amazonsearchbutton_xpath"));
  }

  @AfterMethod(groups = {"regression"})
  public void endProcess() 
  {
	  System.out.println("after Test.....");
	  
	  closeBrowser();
	  report.endTest(test);
	  report.flush();
  }

}
