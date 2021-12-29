package com.crm.autodesk.producttest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.vtiger.comcast.genericutility.FileUtility;
import com.vtiger.comcast.genericutility.WebdriverUtility;

public class Product_17 {

	public static void main(String[] args) throws Exception {

		FileUtility fu=new FileUtility();
		String url =fu.getPropertyKeyValue("URL");
		String un = fu.getPropertyKeyValue("USERNAME");
		String pwd = fu.getPropertyKeyValue("PASSWORD");
		
		WebDriver driver=new ChromeDriver();
		WebdriverUtility wb=new WebdriverUtility();
		wb.waitForPageToLoad(driver);
		
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
		driver.findElement(By.id("selectCurrentPageRec")).click();
		
		driver.findElement(By.xpath("//input[@value='Delete']")).click();
		
		wb.SwitchToAlertWindowAndAccept(driver);
		
		Thread.sleep(5000);
		wb.mouseOverOnElement(driver,driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
		
		driver.findElement(By.linkText("Sign Out")).click();
	}
}
