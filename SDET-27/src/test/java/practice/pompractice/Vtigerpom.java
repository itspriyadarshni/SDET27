package practice.pompractice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.autodesk.objectrepository.ContactInfo;
import com.crm.autodesk.objectrepository.ContactPage;
import com.crm.autodesk.objectrepository.CreateContactPage;
import com.crm.autodesk.objectrepository.CreateNewOrg;
import com.crm.autodesk.objectrepository.CreateProductPage;
import com.crm.autodesk.objectrepository.HomePage;
import com.crm.autodesk.objectrepository.LoginPage;
import com.crm.autodesk.objectrepository.OrganizationInfo;
import com.crm.autodesk.objectrepository.OrganizationPage;
import com.crm.autodesk.objectrepository.ProductInfoPage;
import com.crm.autodesk.objectrepository.ProductPage;
import com.vtiger.comcast.genericutility.ExcelUtilities;
import com.vtiger.comcast.genericutility.FileUtility;
import com.vtiger.comcast.genericutility.JavaUtility;
import com.vtiger.comcast.genericutility.WebdriverUtility;

public class Vtigerpom {

	public static void main(String[] args) throws Exception, IOException {
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

				//check for infopage and org creation
				
//				OrganizationInfo orginfo=new OrganizationInfo(driver);
//				String currenttext = orginfo.getConfirmationtext().getText();	
//				System.out.println(currenttext);
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
				ccp.createNewContact(lname, fname, orgname);
				
				//validate contact creation
				ContactInfo info=new ContactInfo(driver);
				String currenttxt = info.getConfirmationtext().getText();
				
				if(currenttxt.contains(fname)){
					System.out.println("Contact created successfully");
				}
				else {
					System.out.println("Contact created failed");
				}
				
				wu.waitAndClick(hp.getProductslink());
				
				//click on products link
				hp.getProductslink();
				
				//create product
				ProductPage pp=new ProductPage(driver);
				pp.getAddorglookupimg().click();
				
				//create a new product
				String productname = eu.getDataFromExcel("Sheet3", 1, 0);
				//String category = eu.getDataFromExcel("Sheet3", 1, 1);
				
				
				CreateProductPage cpp=new CreateProductPage(driver);
				cpp.getProductname().sendKeys(productname);
				
				//cpp.createproduct(productname, category);
				
				pp.getSubmitbtn().click();
				
				ProductInfoPage pif=new ProductInfoPage(driver);
				String currentext = pif.getConfirmationtext().getText();
				
				if(currenttxt.contains(productname)){
					System.out.println("Product created successfully");
				}
				else {
					System.out.println("Product created failed");
				}
				
				//logout
				hp.getAdministratorimg();
				hp.logout(driver);
				driver.close();
	}

}
