package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.vtiger.comcast.genericutility.ExcelUtilities;
import com.vtiger.comcast.genericutility.FileUtility;
import com.vtiger.comcast.genericutility.JavaUtility;
import com.vtiger.comcast.genericutility.WebdriverUtility;

public class CreateOrganization {

	public static void main(String[] args) throws Exception {
		
		FileUtility fu=new FileUtility();
		String url = fu.getPropertyKeyValue("URL");
		String un = fu.getPropertyKeyValue("USERNAME");
		String pwd = fu.getPropertyKeyValue("PASSWORD");
		String b = fu.getPropertyKeyValue("BROWSER");
		
		//FileInputStream fis=new FileInputStream("./Data/Property/logindetails.properties");
		//Properties p=new Properties();		
		//p.load(fis);
		
//		String url = p.getProperty("URL");
//		String un = p.getProperty("USERNAME");
//		String pwd = p.getProperty("PASSWORD");
//		String b = p.getProperty("BROWSER");
		
		JavaUtility ju=new JavaUtility();
		int rannum = ju.getRandomNumber();
		
//		Random r=new Random();
//		int rannum = r.nextInt();
		
		ExcelUtilities eu=new ExcelUtilities();
		String orgname = eu.getDataFromExcel("Sheet1", 1, 1)+rannum;
		String indus = eu.getDataFromExcel("Sheet1", 1, 2);
		String type = eu.getDataFromExcel("Sheet1", 1, 3);
		
		
		
		
//		FileInputStream fis_e=new FileInputStream("./Data/Excel/Orgname.xlsx");
//		Workbook wb=WorkbookFactory.create(fis_e);
//		String orgname = wb.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue()+rannum;
//		String indus = wb.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue();
//		String type = wb.getSheet("Sheet1").getRow(1).getCell(3).getStringCellValue();
		
		WebDriver driver=null;
		if(b.equals("CHROME"))
		{
			driver=new ChromeDriver();
		}
		else
		{
			driver=new FirefoxDriver();
		}
		
		WebdriverUtility wu=new WebdriverUtility();
		wu.waitForPageToLoad(driver);
		
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
		
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(un);
		driver.findElement(By.name("user_password")).sendKeys(pwd);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgname);
		driver.findElement(By.name("button")).click();
		
		
		
		WebElement industry = driver.findElement(By.name("industry"));
		wu.selectByText(industry, indus);
		
//		Select s1= new Select(industry);
//		s1.selectByVisibleText(indus);
		
		WebElement acctype = driver.findElement(By.name("accounttype"));
		wu.selectByText(acctype, type);
		
//		Select s2=new Select(acctype);
//		s2.selectByVisibleText(type);
		
		String text = driver.findElement(By.className("dvHeaderText")).getText();
		if(text.contains(orgname))
		{
		System.out.println("created");
		}
		else
		{
			System.out.println("not created");
		}
		
		
		wu.waitForTheElementToBeClickable(driver, driver.findElement(By.xpath("//span[contains(text(),'Organization Information')]")));
		
//		WebDriverWait wait=new WebDriverWait(driver, 20);
//		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[contains(text(),'Organization Information')]"))));
		
		
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		
		String lname = eu.getDataFromExcel("Sheet1", 1, 4);
		
//		String lname = wb.getSheet("Sheet1").getRow(1).getCell(4).getStringCellValue();
		
		driver.findElement(By.name("lastname")).sendKeys(lname);
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
		
		
		wu.switchToWindow(driver, "Accounts");
		
//		Set<String> awh = driver.getWindowHandles();
//		Iterator<String> itr = awh.iterator();
//		
//		while(itr.hasNext()) {
//			String currentid = itr.next();
//			driver.switchTo().window(currentid);
//			String title = driver.getTitle();
//			if(title.contains("Accounts")) {
//				break;
//			}
//		}
		
		driver.findElement(By.id("search_txt")).sendKeys(orgname);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
		
		wu.switchToWindow(driver, "Contacts");
		
//		Set<String> set = driver.getWindowHandles();
//		Iterator<String> itr2 = set.iterator();
//		
//		while(itr2.hasNext()) {
//			String currentid = itr2.next();
//			driver.switchTo().window(currentid);
//			String title = driver.getTitle();
//			if(title.contains("Contacts")) {
//				break;
//			}
//		}
		
		
		driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
		
	
		wu.mouseOverOnElement(driver,driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
		
//		Actions a=new Actions(driver);
//		a.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		driver.quit();
	}

}
