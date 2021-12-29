package com.crm.autodesk.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.comcast.genericutility.WebdriverUtility;

public class HomePage {

	@FindBy(linkText = "Organizations")
	private WebElement orglink;
	
	@FindBy(xpath="//a[text()='Contacts']")
	private WebElement contactslink;
	
	@FindBy(xpath="//a[text()='Products']")
	private WebElement productslink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorimg;
	
	@FindBy(xpath="//a[.='Sign Out']")
	private WebElement signoutlink;

	public HomePage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getOrglink() {
		return orglink;
	}

	public WebElement getContactslink() {
		return contactslink;
	}

	public WebElement getProductslink() {
		return productslink;
	}

	public WebElement getAdministratorimg() {
		return administratorimg;
	}

	public WebElement getSignoutlink() {
		return signoutlink;
	}
	
	WebdriverUtility wb=new WebdriverUtility();
	
	public void logout(WebDriver driver) {
		wb.mouseOverOnElement(driver, administratorimg);
		signoutlink.click();
	}
	
}
