package Testngpractice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.crm.autodesk.objectrepository.HomePage;
import com.vtiger.comcast.genericutility.BaseClass;

public class CreateOrg extends BaseClass{

	@Test
	public void CreateOrg() throws Exception, IOException {
		
		//create random number
		int rannum = ju.getRandomNumber();
		
		//read data from excel
		String orgname = eu.getDataFromExcel("Sheet1", 1, 1)+rannum;
		
		Thread.sleep(2000);
		//create org
		HomePage hp=new HomePage(driver);
		//hp.getOrglink().click();
		hp.getContactslink().click();
		
	}
	
}
