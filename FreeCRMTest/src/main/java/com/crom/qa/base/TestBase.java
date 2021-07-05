package com.crom.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.utlil.TestUtil;


public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	//created constructor for the class
	public TestBase() {
		try {
			prop = new Properties();

			FileInputStream fis = new FileInputStream(
					"C:\\Users\\SrinivasCheruku\\eclipse-workspace\\javatraining\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization()
	{
		String browsername=prop.getProperty("browser");
		if(browsername.equals("chrome"))//we will get null pointer excepton when we use == so we need to use equals
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\SrinivasCheruku\\eclipse-workspace\\javatraining\\FreeCRMTest\\src\\main\\java\\drivers\\chromedriver.exe");
			 driver = new ChromeDriver();
		}
		
		else if(browsername.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","C://Users//SrinivasCheruku//eclipse-workspace//javatraining//FreeCRMTest//src//main//java//drivers//geckodriver.exe");
			driver = new FirefoxDriver();
			//System.setProperty("webdriver.gecko.driver", "C:\\Cheruku_Selenium\\geckodriver.exe");
			//driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS); OR
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); OR
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICT_WAIT,TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}
	
}
