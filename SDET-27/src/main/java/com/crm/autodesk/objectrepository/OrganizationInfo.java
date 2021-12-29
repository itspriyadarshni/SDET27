package com.crm.autodesk.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfo {

	@FindBy(className = "dvHeaderText")
	private WebElement confirmationtext;
	
	public OrganizationInfo (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getConfirmationtext() {
		return confirmationtext;
	}
	
	
}
