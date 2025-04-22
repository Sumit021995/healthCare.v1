package com.project.hrm.generic.BaseClass_Test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.project.hrm.generic.DatabaseUtility.DatabaseUtility;
import com.project.hrm.generic.FileUtility.PropertiesUtility;
import com.project.hrm.generic.WebDriverUtility.WebDriverUtility;

import objectRepo.AdminDashBoardPage;
import objectRepo.AdminLoginPage;
import objectRepo.HomePage;

public class BaseClass_Test implements ITestListener{
	public WebDriver driver;
	public DatabaseUtility dbUtil = new DatabaseUtility();
	public PropertiesUtility pUtil =new PropertiesUtility();
	public WebDriverUtility wUtil =new WebDriverUtility();
	public ThreadLocal<WebDriver> driverRef = new ThreadLocal();
	

	@BeforeSuite(alwaysRun=true)
	public void connectToDatabase() throws Exception
	{
		dbUtil.getDatabaseConnection();
	}
	
	@Parameters("browser")
	@BeforeClass(alwaysRun=true)
	public void launchingBrowser(@Optional("chrome") String browser) throws IOException
	{
		if(browser.equalsIgnoreCase("chrome"))
			driver = new ChromeDriver();
		else if(browser.equalsIgnoreCase("firefox"))
			driver = new FirefoxDriver();
		else if(browser.equalsIgnoreCase("edge"))
			driver = new EdgeDriver();
		else driver = new FirefoxDriver();
			
//		driver=getDriver();// for listeners
		wUtil.implicitWait(driver, 20);
		wUtil.maximizeWindow(driver);
		String url = pUtil.getDataFromPropertiesFile("url");
		wUtil.accesToApplication(driver, url);
		
	}
	@BeforeMethod(alwaysRun=true)
	public void setup(ITestResult result) {
	    String testName = result.getMethod().getMethodName();
	    System.out.println("🔍 Starting test: " + testName);

	    // need to follow naming convention
	    if (testName.contains("Admin")) {
	        loginAsAdmin();
	    } else if (testName.contains("Doctor")) {
	        loginAsDoctor();
	    } else if (testName.contains("Patient")) {
	        loginAsPatient();
	    }
	}

	
	public void loginAsPatient() {
		
		HomePage h = new HomePage(driver);
		h.getLoginsLink().click();
		h.getAdminLoginLink().click();
	}

	public void loginAsDoctor() {
		
		
	}

	public void loginAsAdmin() {
		
		HomePage h = new HomePage(driver);
		h.getLoginsLink().click();
		h.getAdminLoginLink().click();
		wUtil.switchToNewWindow(driver);
		AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
		adminLoginPage.loginAsAdmin();
		System.out.println("Logged in as Admin");
		
	}

	@AfterMethod(alwaysRun=true)
	public void logoutFromApplication()
	{
		String currentUrl = driver.getCurrentUrl();
		if(currentUrl.contains("admin"))
		{
			logoutFromAdmin();	
		}
	}
	public void logoutFromAdmin() {
		AdminDashBoardPage adminDashBoardPage = new AdminDashBoardPage(driver);
		adminDashBoardPage.logoutFromAdminPage(driver);
		
	}

	@AfterClass(alwaysRun=true)
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
	@AfterSuite(alwaysRun=true)
	public void closeDBConnection()
	{
		dbUtil.closeDBConnection();
	}
}
