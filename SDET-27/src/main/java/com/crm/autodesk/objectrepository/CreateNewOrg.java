package com.crm.autodesk.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.comcast.genericutility.WebdriverUtility;

public class CreateNewOrg {
	
	@FindBy(name="accountname")
	private WebElement orgname;
	
	@FindBy(name="industry")
	private WebElement industrydropdownbox;
	
	@FindBy(name="accounttype")
	private WebElement typedropdownbox;
	
	@FindBy(xpath="//input[@value='  Save  ']")
	private WebElement savebtn;
	
	public CreateNewOrg (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgname() {
		return orgname;
	}

	public WebElement getIndustrydropdownbox() {
		return industrydropdownbox;
	}

	public WebElement getTypedropdownbox() {
		return typedropdownbox;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}

	
	public void createNewOrg(String org) {
		orgname.sendKeys(org);
		savebtn.click();
	}
}
