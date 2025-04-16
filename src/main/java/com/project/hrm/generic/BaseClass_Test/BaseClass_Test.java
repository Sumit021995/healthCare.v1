package com.project.hrm.generic.BaseClass_Test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.project.hrm.generic.DatabaseUtility.DatabaseUtility;
import com.project.hrm.generic.FileUtility.PropertiesUtility;
import com.project.hrm.generic.WebDriverUtility.WebDriverUtility;

public class BaseClass_Test {
	public WebDriver driver;
	DatabaseUtility dbUtil = new DatabaseUtility();
	PropertiesUtility pUtil =new PropertiesUtility();
	WebDriverUtility wUtil =new WebDriverUtility();
	ThreadLocal<WebDriver> driverRef = new ThreadLocal();
	

	@BeforeSuite
	public void connectToDatabase() throws Exception
	{
		dbUtil.getDatabaseConnection();
	}
	
	@Parameters("browser")
	@BeforeClass
	public void launchingBrowser(@Optional("firefox") String browser) throws IOException
	{
		if(browser.equalsIgnoreCase("chrome"))
			driver = new ChromeDriver();
		else if(browser.equalsIgnoreCase("firefox"))
			driver = new FirefoxDriver();
		else if(browser.equalsIgnoreCase("edge"))
			driver = new EdgeDriver();
		else driver = new FirefoxDriver();
			
		driver=getDriver();
		wUtil.implicitWait(driver, 20);
		wUtil.maximizeWindow(driver);
		String url = pUtil.getDataFromPropertiesFile("url");
		wUtil.accesToApplication(driver, url);
		
	}
//	@BeforeMethod
//	public void loginAsAdmin()
//	{
//		
//	}
	
	@AfterMethod
	public void logoutFromApplication()
	{
		
	}
	@AfterClass
	public void closingOfBrowser()
	{
		driver.quit();
	}
	
	public WebDriver getDriver() {
		return driverRef.get();
	}
	
	public void setDriver(WebDriver driver) {
		driverRef.set(driver);
	}
}
