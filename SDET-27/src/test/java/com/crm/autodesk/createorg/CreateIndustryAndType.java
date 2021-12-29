package com.crm.autodesk.createorg;


import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CreateIndustryAndType {
	


public static class CreateOrganizationAndCreateContacts {
	public static void main(String[] args) throws Throwable {

		//Fetch the data from Properties
		FileInputStream fis=new FileInputStream("./Data/Property/logindetails.properties"); // Specify the Path in order to get the java representation object of the physical file
		Properties properties=new Properties();
		properties.load(fis); // Load the address of path of Properties File
		String URL=properties.getProperty("URL");
		String UserName=properties.getProperty("USERNAME");
		String Password=properties.getProperty("PASSWORD");
		String Browser=properties.getProperty("BROWSER");

		//get random Number
		Random ran=new Random();
		int randomNumber = ran.nextInt(1000);


		//Fetch the data from Excel
		FileInputStream fis_excel=new FileInputStream("./Data/Excel/Orgname.xlsx");// Specify the Path in order to get the java representation object of the physical file
		Workbook wb = WorkbookFactory.create(fis_excel);
		String testdata_org = wb.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue()+randomNumber;
		String testdata_contact = wb.getSheet("Sheet1").getRow(2).getCell(1).getStringCellValue()+randomNumber;


		//Open Browser and Enter URL
		WebDriver driver=null;
		if(Browser.equals("chrome")) {
			
			driver=new ChromeDriver();
		}
		else if(Browser.equals("firefox")) {
		
			driver=new FirefoxDriver();
		}
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


		//login to VTIGER application
		driver.findElement(By.name("user_name")).sendKeys(UserName);
		driver.findElement(By.name("user_password")).sendKeys(Password);
		driver.findElement(By.id("submitButton")).click();

		//Navigate to Organization Tab
		driver.findElement(By.linkText("Organizations")).click();

		//click on Create Organization
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();

		//Enter the details and click on save
		driver.findElement(By.name("accountname")).sendKeys(testdata_org);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("dvHeaderText"))));
		
		//Navigate to Organization Tab
		driver.findElement(By.linkText("Contacts")).click();

		//click on Create Organization
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();

		//Enter the details and click on save
		driver.findElement(By.name("lastname")).sendKeys(testdata_contact);
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
		Set<String> set = driver.getWindowHandles();
		Iterator<String>it=set.iterator();
		
		while (it.hasNext()) {
			String currentID=it.next();
			driver.switchTo().window(currentID);
			String cpageTitle = driver.getTitle();
			if (cpageTitle.contains("Accounts")) {
				break;
				
			}
		}
           
		  driver.findElement(By.name("search_text")).sendKeys(testdata_org);
		  driver.findElement(By.name("search")).click();
		  driver.findElement(By.xpath("//a[text()='"+testdata_org+"']")).click();
		  Set<String> set1 = driver.getWindowHandles();
			Iterator<String>it1=set1.iterator();
			
			while (it1.hasNext()) {
				String currentID=it1.next();
				driver.switchTo().window(currentID);
				String cpageTitle = driver.getTitle();
				if (cpageTitle.contains("contacts")) {
					break;
					
				}
			}
			
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			String actual_organame=driver.findElement(By.xpath("//td[@id='mouseArea_Organization Name']/a")).getText();
			System.out.println(actual_organame+" actual_organame" );
			if (actual_organame.trim().equals(testdata_org.trim())) {
				System.out.println(actual_organame+"is visible==>test case is pass");
			}else {
				System.out.println(actual_organame+"is not visible==>test case is fail");
			}
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
	

         Actions act=new Actions(driver);
       act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
       driver.findElement(By.linkText("Sign Out")).click();
       Thread.sleep(5000);
       driver.quit();

			}
}
}

