package com.crm.qa.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.pages.Contacts;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utlil.TestUtil;
import com.crom.qa.base.TestBase;

public class ContactspageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	Contacts contacts;
	String sheetName="contacts";
	

	public ContactspageTest()
	{
	super();
	}
	@BeforeMethod
	public void setup() throws InterruptedException 
	{
		initialization();
		testutil=new TestUtil();
		contacts=new Contacts();
		//LoginPage loginpage=new LoginPage(); OR
		loginpage=new LoginPage();//we declared loginpage variable  as class variable
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		testutil.switchtoframe();
		contacts=homepage.clickonContactslink();
		
		}
	
	//@Test(priority=1)
	public void verifycontactpagelabel()
	{
		//Assert.assertTrue(contacts.verifycontactslabel(),"contact label is migging");
	}
	//@Test(priority=2)
	public void contacttest() throws InterruptedException
	{
		contacts.selectcontacts();
	}
	
	//@Test(priority=3)
	public void mulitiplecontacttest()
	{
		contacts.selectcontacts("Akshay Lange");
		contacts.selectcontacts("chaitanya ram");
	}
	
	
	@DataProvider
	public Object[][] getCRMTestData() {
	
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	
	@Test(priority=4, dataProvider="getCRMTestData")
	public void validateCreateNewContact(String title,String firstname,String lastname,String company) throws InterruptedException  
	{
		homepage.clickonnewcontactlink();
		//contacts.createnewcontact("Mr.", "ch","srinivas", "Switzerland");
		contacts.createnewcontact(title, firstname, lastname, company);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
//Testing purpose
}
