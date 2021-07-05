package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crom.qa.base.TestBase;
//created page library for home page
public class HomePage extends TestBase {

	//creating page objects
	
	//@CacheLookup 
		/***Very important
		@CacheLookup--To improve the performance of the script. 
		Advantages:
		How it works:
		1)Lets suppose the element is hitting the browser number of times to get the element path.There will be performance issues.
		2)So if we use @CacheLookup for that element, there will be temporary memory created if we use @cachelookup.
		3)So next time it will not go to browser every time it will taken from @cachelookup

		Disadvantages:
		1)Let see we are in homepage, if that page is refreshed then this cache memory will be corrupted. We will get stale element exception.
		2)May be when dom model be changed in that case cache memory element will be staled or disturbed. 
	*/
	@FindBy(xpath="//td[contains(text(),'automation')]")
	WebElement usernamelabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactslink;
	
	@FindBy(xpath="//a[@title=\"New Contact\"]")
	WebElement newcontactlink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement taskslink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealslink;
	
	//Initializing the page objects by creating constructor
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public String HomepageTitle() {
		return driver.getTitle();
	}
	
	public boolean Verifyusername()
	
	{
		return usernamelabel.isDisplayed();
		
			}
	public Contacts clickonContactslink()
	{
		 contactslink.click();
		return new Contacts();
	}
	
	public Deals clickondealslink()
	{
		dealslink.click();
		return new Deals();
	}
	public TasksPage clickontasklink()
	{
		taskslink.click();
		return new TasksPage();
	}
	
	public void clickonnewcontactlink() throws InterruptedException
	{
		Thread.sleep(5000);
		Actions action=new Actions(driver);
		action.moveToElement(newcontactlink).build().perform();
		newcontactlink.click();
	}
	}

