package com.crm.autodesk.producttest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.vtiger.comcast.genericutility.FileUtility;
import com.vtiger.comcast.genericutility.JavaUtility;
import com.vtiger.comcast.genericutility.WebdriverUtility;

public class Product_6 {

	public static void main(String[] args) throws Exception {
		FileUtility fu=new FileUtility();
		String url = fu.getPropertyKeyValue("URL");
		String un = fu.getPropertyKeyValue("USERNAME");
		String pwd = fu.getPropertyKeyValue("PASSWORD");
		String browser = fu.getPropertyKeyValue("BROWSER");
		
		WebDriver driver=new ChromeDriver();
		WebdriverUtility wb=new WebdriverUtility();
		wb.waitForPageToLoad(driver);
		
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(un);
		driver.findElement(By.name("user_password")).sendKeys(pwd);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		JavaUtility ju=new JavaUtility();
		int rannum = ju.getRandomNumber();
		
		driver.findElement(By.name("productname")).sendKeys("Keyboard3"+rannum);
		driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
		
		
		
		
		
		

	}

}
