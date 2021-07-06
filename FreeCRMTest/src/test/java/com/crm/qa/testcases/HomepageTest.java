package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.pages.Contacts;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utlil.TestUtil;
import com.crom.qa.base.TestBase;
//this is created for testing purpose.
//Cheruku testing cheruku testing

public class HomepageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	Contacts contacts;

	public HomepageTest()
	{
	super();
	}
//test cases should be separated --independent to each other
//before each test cases --launch the browser and login
//@test--execute test case
//after each test case---close the browser.
	
	@BeforeMethod
	public void setup() throws InterruptedException
	{
		initialization();
		testutil=new TestUtil();
		contacts=new Contacts();
		//LoginPage loginpage=new LoginPage(); OR
		loginpage=new LoginPage();//we declared loginpage variable  as class variable
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest()
	{
	String homepagetitle=homepage.HomepageTitle();
	Assert.assertEquals(homepagetitle, "CRMPRO","Home page title not matched");//the message "homepage title not matched will be printed only when testcase fails.
	}
	
	@Test(priority=2)
	public void verifyUsernametest()
	{
		testutil.switchtoframe();
		Assert.assertTrue(homepage.Verifyusername());
	}
	
	@Test(priority=3)
	public void verifycontactlinktest()
	{
		testutil.switchtoframe();
		contacts=homepage.clickonContactslink();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
}