package com.crm.autodesk.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {

	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement Addorglookupimg;
	
	@FindBy(name="search_text")
	private WebElement searchtxtbox;
	
	@FindBy(id="bas_searchfield")
	private WebElement searchdropdown;
	
	@FindBy(name="submit")
	private WebElement submitbtn;
	
	public OrganizationPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getAddorglookupimg() {
		return Addorglookupimg;
	}

	public WebElement getSearchtxtbox() {
		return searchtxtbox;
	}

	public WebElement getSearchdropdown() {
		return searchdropdown;
	}

	public WebElement getSubmitbtn() {
		return submitbtn;
	}
	
	
}
