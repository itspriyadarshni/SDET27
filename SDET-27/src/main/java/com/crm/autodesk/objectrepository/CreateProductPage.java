package com.crm.autodesk.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.comcast.genericutility.WebdriverUtility;

public class CreateProductPage {
	
	@FindBy(name="productname")
	private WebElement productname;
	
//	@FindBy(name="productcategory")
//	private WebElement productcategory;
	
	@FindBy(xpath="//input[@value='  Save  ']")
	private WebElement savebtn;
	
	public CreateProductPage (WebDriver driver) {
	PageFactory.initElements(driver, this);
	}

	public WebElement getProductname() {
		return productname;
	}

//	public WebElement getProductcategory() {
//		return productcategory;
//	}

	public WebElement getSavebtn() {
		return savebtn;
	}

}
