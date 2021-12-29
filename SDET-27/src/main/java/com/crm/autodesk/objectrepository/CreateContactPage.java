package com.crm.autodesk.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactPage {

	@FindBy(name="firstname")
	private WebElement firstname;
	
	@FindBy(name="lastname")
	private WebElement lastname;
	
	@FindBy(name="account_name")
	private WebElement orgname;
	
	@FindBy(xpath="//input[@value='  Save  ']")
	private WebElement savebtn;
	
	public CreateContactPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getFirstname() {
		return firstname;
	}

	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getOrgname() {
		return orgname;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}

	public void createNewContact(String lname, String fname, String oname) {
		firstname.sendKeys(fname);
		lastname.sendKeys(lname);
		orgname.sendKeys(oname);
		savebtn.click();
	}
}

