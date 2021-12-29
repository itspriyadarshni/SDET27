package practice.pompractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.autodesk.objectrepository.ContactInfo;
import com.crm.autodesk.objectrepository.ContactPage;
import com.crm.autodesk.objectrepository.CreateContactPage;
import com.crm.autodesk.objectrepository.CreateNewOrg;
import com.crm.autodesk.objectrepository.HomePage;
import com.crm.autodesk.objectrepository.LoginPage;
import com.crm.autodesk.objectrepository.OrganizationInfo;
import com.crm.autodesk.objectrepository.OrganizationPage;
import com.vtiger.comcast.genericutility.ExcelUtilities;
import com.vtiger.comcast.genericutility.FileUtility;
import com.vtiger.comcast.genericutility.JavaUtility;
import com.vtiger.comcast.genericutility.WebdriverUtility;

public class LoginUsingPom {

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

		//navigate to organization
		HomePage hp=new HomePage(driver);
		hp.getOrglink().click();

		//generate random number
		JavaUtility ju=new JavaUtility();
		int rannum = ju.getRandomNumber();

		//Create test data
		ExcelUtilities eu=new ExcelUtilities();
		String org = eu.getDataFromExcel("Sheet1", 1, 1);
		String orgname = org+rannum;

		//click addorganization
		OrganizationPage orgp=new OrganizationPage(driver);
		orgp.getAddorglookupimg().click();

		//create organization
		CreateNewOrg neworg=new CreateNewOrg(driver);
		neworg.createNewOrg(orgname);

		//		//check for infopage and org creation
		//		OrganizationInfo info=new OrganizationInfo(driver);
		//		String currenttext = info.getConfirmationtext().getText();		
		//		if(currenttext.contains(orgname)) {
		//			System.out.println("organization is created successfully");
		//		}		
		//		else {
		//			System.out.println("organization is not created");
		//		}

		WebdriverUtility wu=new WebdriverUtility();
		wu.waitAndClick(hp.getContactslink());
		
		
		//click on contact link
		hp.getContactslink().click();

		//creating contact
		ContactPage cp=new ContactPage(driver);
		cp.getAddorglookupimg().click();

		//create contact data
		String fname = eu.getDataFromExcel("Sheet2", 1, 0);
		String lname = eu.getDataFromExcel("Sheet2",1, 1);

		//create contact
		CreateContactPage ccp=new CreateContactPage(driver);
		ccp.createNewContact(lname, fname, orgname).
		


	}

}
