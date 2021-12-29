package com.vtiger.comcast.genericutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.crm.autodesk.objectrepository.HomePage;
import com.crm.autodesk.objectrepository.LoginPage;

public class BaseClass {
	public WebDriver driver = null;
	public DatabaseUtility dbu=new DatabaseUtility();
	public FileUtility fu=new FileUtility();
	public JavaUtility ju=new JavaUtility();
	public ExcelUtilities eu=new ExcelUtilities();
	public WebdriverUtility wu=new WebdriverUtility();


	@BeforeSuite
	public void conectToDb() {
		System.out.println("Connected to database");
	}
	
	@BeforeClass
	public void openBrowser() throws Exception {
		String url = fu.getPropertyKeyValue("URL");
		String browser = fu.getPropertyKeyValue("BROWSER");
		if(browser.equalsIgnoreCase("chrome"))
		{
		driver = new ChromeDriver();	
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
		driver = new FirefoxDriver();
		}
		else {
			System.out.println("invalid browser");
		}
		wu.waitForPageToLoad(driver);
		driver.get(url);
	}
	
	
	@BeforeMethod
	public void loginApp() throws Exception {
		
		String un = fu.getPropertyKeyValue("USERNAME");
		String pwd = fu.getPropertyKeyValue("PASSWORD");
		LoginPage lp=new LoginPage(driver);
		lp.Login(un, pwd);
		lp.getLoginbtn().click();
	}
	
	@AfterMethod
	public void logoutApp() {
		HomePage hp=new HomePage(driver);
		hp.logout(driver);
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
	
	@AfterSuite
	public void disconnectDb() {
		System.out.println("disconnected from database");
	}

}
