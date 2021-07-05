package com.crm.qa.testcases;

//hi hi testing
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crom.qa.base.TestBase;


public class LoginPageTest extends TestBase {
LoginPage loginpage; //created LoginPage, HomePage objects in global level so that we can use it everywhere.
HomePage homePage;
	public LoginPageTest()
	{
	super();//what it does its calls super class constructor which is TestBase.
		         //Super class constructor(TesBase) will be called using Super keyword
	}
	
	
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		//LoginPage loginpage=new LoginPage(); OR
		loginpage=new LoginPage();//we declared loginpage variable  as class variable
		
		}
	
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		String title=loginpage.validateloginpagetitle();
		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
	
	}

	@Test(priority=2)
	public void CRMLogoImageTest()
	{
		boolean flag=loginpage.validatecrmimage();
		Assert.assertTrue(flag);
	}
	@Test(priority=3)
	public void loginTest() throws InterruptedException
	{
	
		homePage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}
