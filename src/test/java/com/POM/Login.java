package com.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login 
{
		
	@FindBy(xpath="//a[@class='login']")public WebElement signInLink;
	@FindBy(id="email")public WebElement customerEmailId;
	@FindBy(id="passwd")public WebElement customerPassword;
	@FindBy(xpath="//p[@class='submit']//span[1]")public WebElement signInButton;
	@FindBy(xpath="//li[contains(text(),'Authentication failed.')]")public WebElement getAuthenticationText;

	
	public Login(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	public void customerLogin()
	{
		signInLink.click();
		customerEmailId.sendKeys("qatest9485948@gmail.com");
		customerPassword.sendKeys("password");
		signInButton.click();
	}
	
	public String validateCustomer()
	{
		String actualText = getAuthenticationText.getText();
		return actualText;
	}
	
}
