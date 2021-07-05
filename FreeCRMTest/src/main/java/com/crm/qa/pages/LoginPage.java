package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crom.qa.base.TestBase;

public class LoginPage extends TestBase {
	//created page library for loginpage
//pagefactory or object repository
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[@href='https://register.freecrm.com/register/']")
	WebElement signupbtn;
	
	@FindBy(xpath="//img[@src='https://classic.freecrm.com/img/logo.png']")
	WebElement crmlogo;
	
	//Initializing the page objects
	public LoginPage(){//contructor
	PageFactory.initElements(driver, this);// all the variables in Loginclass will be initialize by driver and "this" means this current class
	}
	//Actions
	
	public String validateloginpagetitle()
	{
		return driver.getTitle();
	}
	
	public boolean validatecrmimage()
	{
		return crmlogo.isDisplayed();
	}
	
	public HomePage login(String un,String pwd) throws InterruptedException
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		Thread.sleep(5000);
		loginBtn.click();
		return new HomePage();
		
	}
}
