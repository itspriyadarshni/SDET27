package practice.pompractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.autodesk.objectrepository.ContactPage;
import com.crm.autodesk.objectrepository.CreateContactPage;
import com.crm.autodesk.objectrepository.HomePage;
import com.crm.autodesk.objectrepository.LoginPage;
import com.vtiger.comcast.genericutility.ExcelUtilities;
import com.vtiger.comcast.genericutility.FileUtility;

public class CreateContact extends LoginUsingPom {

	public static void main(String[] args) throws Exception {

		//login 

		FileUtility fis=new FileUtility();
		String url = fis.getPropertyKeyValue("URL");
		String un = fis.getPropertyKeyValue("USERNAME");
		String pwd = fis.getPropertyKeyValue("PASSWORD");
		String browser=fis.getPropertyKeyValue("BROWSER");

		WebDriver driver=null;

		if(browser.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		else {
			System.out.println("invalid browser");
		}

		driver.get(url);
		LoginPage lp=new LoginPage(driver);
		lp.Login(un, pwd);

		//click on contact link
		HomePage hp= new HomePage(driver);
		hp.getContactslink().click();
		
		//creating contact
		ContactPage cp=new ContactPage(driver);
		cp.getAddorglookupimg().click();
		
		//create contact data
		ExcelUtilities eu=new ExcelUtilities();
		String fname = eu.getDataFromExcel("Sheet2", 1, 0);
		String lname = eu.getDataFromExcel("Sheet2",1, 1);

		
		
		//create contact
		CreateContactPage ccp=new CreateContactPage(driver);
		ccp.createNewContact(lname, fname, LoginUsingPom.orgname);


	}

}
