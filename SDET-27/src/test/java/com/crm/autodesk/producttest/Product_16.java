package com.crm.autodesk.producttest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.vtiger.comcast.genericutility.FileUtility;
import com.vtiger.comcast.genericutility.WebdriverUtility;

public class Product_16 {

	public static void main(String[] args) throws Exception {
		
		FileUtility fu=new FileUtility();
		String url =fu.getPropertyKeyValue("URL");
		String un = fu.getPropertyKeyValue("USERNAME");
		String pwd = fu.getPropertyKeyValue("PASSWORD");
		
		//FileInputStream fis = new FileInputStream("./Data/Property/logindetails.properties");
		//Properties p=new Properties();
		//p.load(fis);
		//String url = p.getProperty("URL");
		//String un = p.getProperty("USERNAME");
		//String pwd = p.getProperty("PASSWORD");
		
		
		WebDriver driver=new ChromeDriver();
		System.out.println(driver);
		WebdriverUtility wb=new WebdriverUtility();
		wb.waitForPageToLoad(driver);
		
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(un);
		driver.findElement(By.name("user_password")).sendKeys(pwd);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.name("productname")).sendKeys("Keyboard3");
		driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
		
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.name("search_text")).sendKeys("Keyboard");
		
		wb.selectByText(driver.findElement(By.id("bas_searchfield")), "Product Name");
		
		//WebElement sel = driver.findElement(By.id("bas_searchfield"));
		//Select s = new Select(sel);
		//s.selectByVisibleText("Product Name");
		//driver.findElement(By.name("submit")).click();
		
		driver.findElement(By.id("selectCurrentPageRec")).click();
		driver.findElement(By.xpath("//input[@value='Mass Edit']")).click();
		driver.findElement(By.xpath("//img[@alt='Close']")).click();
		String text = driver.findElement(By.xpath("//td[.='Mass Edit - Records Fields']")).getText();
		if(text.contains("Mass Edit - Records Fields")) {
			System.out.println("Massedit is available");
		}
		else
		{
			System.out.println("Massedit is not available");
		}
		
		Thread.sleep(5000);
		wb.mouseOverOnElement(driver,driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
		
		//Actions a = new Actions(driver);
		//a.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		
		driver.findElement(By.linkText("Sign Out")).click();
	}

}
