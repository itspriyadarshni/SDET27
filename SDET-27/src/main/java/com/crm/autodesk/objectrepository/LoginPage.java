package com.crm.autodesk.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {//Rule 1: create separate pom class for every web page
	
	
	//rule 2:declare the web elements using @findby/@findall/@findbys
	
	@FindBy (name="user_name")
	private WebElement usernametxtbox;
	
	@FindBy (name="user_password")
	private WebElement passwordtxtbox;
	
	@FindBy (id="submitButton")
	private WebElement loginbtn;
	
	
	//rule 3: initialize the elements
	
	public LoginPage (WebDriver driver) {
			PageFactory.initElements(driver, this);
		}

	public WebElement getUsernametxtbox() {
		return usernametxtbox;
	}

	public WebElement getPassowrdtxtbox() {
		return passwordtxtbox;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}
	
	
	
	//business library for login
	
	public void Login(String username,String password) {
	usernametxtbox.sendKeys(username);
	passwordtxtbox.sendKeys(password);
	loginbtn.click();
	}
}
