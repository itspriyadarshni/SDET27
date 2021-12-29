package com.crm.autodesk.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInfoPage {

	@FindBy(className="lvtHeaderText")
	private WebElement confirmationtext;

	public WebElement getConfirmationtext() {
		return confirmationtext;
	}
	
	public ProductInfoPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
