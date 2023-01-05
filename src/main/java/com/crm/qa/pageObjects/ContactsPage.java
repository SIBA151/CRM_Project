package com.crm.qa.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.TestBase;

public class ContactsPage extends TestBase{
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]") 
	WebElement contactsLabel;
	
	@FindBy(xpath="//input[@value='New Contact']")
	WebElement NewContactBtn;
	
	//New Contact fields
	@FindBy(xpath="//select[@name='title']") 
	WebElement title;
	
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id="surname")
	WebElement lastName;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(xpath="//input[@value='Save']")
	WebElement saveBtn;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsLabel() {
		return contactsLabel.isDisplayed();
	}
	
	public void selectContactByName(String name) {
		driver.findElement(By.xpath("//a[contains(text(), '"+name+"')]//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@type='checkbox']")).click();
	}
	
	public void addNewContactBtn() { 
		NewContactBtn.click();
	}
	
	public void createNewContact(String tit, String fName, String lName, String comp) {
		Select select=new Select(title);
		select.selectByVisibleText(tit);
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		company.sendKeys(comp);
		saveBtn.click();
		
	}
	

}
