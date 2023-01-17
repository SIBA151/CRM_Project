package com.crm.qa.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//td[contains(text(),'User: R Siba Kumar Reddy')]") 
	WebElement userNameLabel;
	
	@FindBy(xpath="//a[@title='Companies']")
	WebElement companiesLink;
	
	@FindBy(xpath="//a[@title='New Company']")
	WebElement newCompanyLink;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	
	@FindBy(xpath="//a[contains(text(), 'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(@title, 'New Deal')]")
	WebElement newDealsLink;
	
	public HomePage() {
		PageFactory.initElements(driver, this );
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyUserName() {
		return userNameLabel.isDisplayed();
	}
	
	public CompaniesPage clickOnCompanyLink() {
		companiesLink.click();
		return new CompaniesPage();
	}
	
	public CompaniesPage clickOnNewCompanyLink() {
		Actions action=new Actions(driver);
		action.moveToElement(companiesLink).build().perform();
		action.moveToElement(newCompanyLink).click().perform();
		return new CompaniesPage();
	}
	
	public ContactsPage clickOnContactsLink() {
		contactsLink.click();
		return new ContactsPage();
	}
	public void clickOnNewContactsLink() {
		Actions action=new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		action.moveToElement(newContactLink).click().perform();
	}
	
	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}
	public void clickOnNewDealsLink() {
		Actions action=new Actions(driver);
		action.moveToElement(dealsLink).build().perform();
		action.moveToElement(newDealsLink).click().perform();
	}
	

}
