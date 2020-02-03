package com.project.December2019MavenProject;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.excelLibraries.BaseTest;
import com.relevantcodes.extentreports.LogStatus;

public class TC_003 extends BaseTest
{
	
  @BeforeTest
  public void startProcess() throws Exception 
  {
	  System.out.println("before Test.....");
	  
	    init();
		test=report.startTest("TC_005");
		test.log(LogStatus.INFO, "initializing the Properties files (data, or, envronments, log4jconfig) ........");
		
		launchBrowser("chromebrowser");
		test.log(LogStatus.INFO, "Opened the browser :- " + p.getProperty("chromebrowser"));
		
		launchUrl("amazonurl");
		test.log(LogStatus.INFO, "Navigated to URl :- " + p.getProperty("amazonurl"));
  }
  
  
  @Test
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

  @AfterTest
  public void endProcess() 
  {
	  System.out.println("after Test.....");
	  
	  closeBrowser();
	  report.endTest(test);
	  report.flush();
  }

}
