package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crom.qa.base.TestBase;

public class Contacts extends TestBase {

	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactslabel;
	
	@FindBy(xpath="//input[@value='52771327']") //To avoid hardcode the name below we have return the method seleccontacts
	WebElement selectcontacts;
	
	@FindBy(id="first_name")
	WebElement firstname;
	
	
	@FindBy(id="surname")
	WebElement lastname;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement savebutton;
	
	//Initializing the page objects by creating constructor
	
		public Contacts()
		{
			PageFactory.initElements(driver, this);
		}
		
		public boolean verifycontactslabel()
		{
			return contactslabel.isDisplayed();
		}
		
		public void selectcontacts() 
		{
			selectcontacts.click();
		}
		
		public void selectcontacts(String name)
		{
	//driver.findElement(By.xpath("//a[text()='Chung Li']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']  	")).click();	
	driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();		
		}	
		
	public void createnewcontact(String title, String ftname, String ltname,String comp) 
	{
		Select select=new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		firstname.sendKeys(ftname);
		lastname.sendKeys(ltname);
		company.sendKeys(comp);
		savebutton.click();
	}
		
}
