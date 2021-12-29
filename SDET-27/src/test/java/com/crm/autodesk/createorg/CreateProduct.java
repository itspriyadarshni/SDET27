package com.crm.autodesk.createorg;


import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateProduct {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		
		 //step-1 get the java representation object of the physical file
		FileInputStream fis=new FileInputStream("./data/testdata.properties.txt");
		// step-2 create an object to property class to load all the keys
		Properties pobj=new Properties();
		pobj.load(fis);
		// step-3 read the value using getproprty("key")
		String BROWSER=pobj.getProperty("browser");
		String URL=pobj.getProperty("url");
		String USERNAME=pobj.getProperty("username");
		String PASSWORD=pobj.getProperty("password");
		
		
		//getrandom num
		Random ran=new Random();
		int random = ran.nextInt(100);
		
		//read test data from excel file
		FileInputStream fis_e=new FileInputStream("./data/trail.xlsx");
		// open the workbook read
		 Workbook wb = WorkbookFactory.create(fis_e);
		 //to specify the sheet name
		Sheet s = wb.getSheet("org");
		//to specify the row
		Row r = s.getRow(1);
		//to specify the column
		Cell c = r.getCell(3);
		String contacts = c.getStringCellValue()+random;
		System.out.println(contacts);
		
		//step-4 read common data from properties file
     	WebDriver driver = null;
     	if (BROWSER.equals("chrome")) {
     		driver=new ChromeDriver();
     		
			}else if (BROWSER.equals("firefox")) {
				driver=new FirefoxDriver();
				}else {
					driver=new ChromeDriver();
				}
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//step-5 login
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(contacts);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(2000);
		String conf_msg = driver.findElement(By.className("dvHeaderText")).getText();
		if (conf_msg.contains(contacts)) {
			System.out.println("org is successfully created..pass");
			
		}else {
			System.out.println("org is not created...fail");
		}
	
		

		//step-10 logout
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		
		Thread.sleep(5000);
		driver.quit();
		
		
	}

}
