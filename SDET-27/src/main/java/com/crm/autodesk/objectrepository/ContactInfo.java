package com.crm.autodesk.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfo {

	@FindBy(className="dvHeaderText")
	private WebElement confirmationtext;

	public WebElement getConfirmationtext() {
		return confirmationtext;
	}
	
	public ContactInfo (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
}
