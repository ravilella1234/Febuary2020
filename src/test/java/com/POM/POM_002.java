package com.POM;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.excelLibraries.BaseTest;

public class POM_002 extends BaseTest
{
 
	Login obj;
	CustomerRegistration reg;
	
  @BeforeTest
  public void startProcess() throws Exception 
  {
	  init();
	  launchBrowser("chromebrowser");
	  launchUrl("automationurl");
  }
  
  
  @Test(enabled=false)
  public void login() 
  {
	  obj = new Login(driver);
	  obj.customerLogin();
	  Assert.assertEquals(obj.validateCustomer(), "Authentication failed");
  }
  
   
  
  @Test
  public void registration() throws InterruptedException
  {
	  reg=new CustomerRegistration(driver);
	  reg.customerRegistration();
  }

  @AfterTest
  public void endProcess() 
  {
	  
  }

}
