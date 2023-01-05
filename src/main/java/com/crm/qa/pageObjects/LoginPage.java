package com.crm.qa.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class LoginPage extends TestBase{
	
	@FindBy(className="form-control") 
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//div[@class='input-group-btn']//input[@value='Login']") 
	WebElement loginBtn;
	
	@FindBy(xpath="//a[contains[text(), 'Sign Up']")
	WebElement singUpBtn;
	
	@FindBy(xpath="//img[contains(@class, 'img-responsive')]")
	WebElement crmLogo;
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateCRMLogo() {
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pw) {
		username.sendKeys(un);
		password.sendKeys(pw);
		loginBtn.click();
		return new HomePage();
	}
	

}
