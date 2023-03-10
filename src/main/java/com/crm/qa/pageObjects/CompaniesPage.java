package com.crm.qa.pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class CompaniesPage extends TestBase {
	
	@FindBy(xpath="//td[contains(text(),'Companies')]")
	WebElement companieLabels;
	
	@FindBy(xpath="//fieldset[@class='fieldset'] //legend[text()='Create New  Company']")
	WebElement createNewCompanyLabel;
	
	@FindBy(xpath="//strong[text()='Tags']")
	WebElement tagLabel;
	
	@FindBy(xpath="//strong[text()='Description']")
	WebElement descriptionLabel;
	
	@FindBy(id="company_name")
	WebElement companyName;
	
	@FindBy(name="industry")
	WebElement industryName;
	
	@FindBy(id="num_of_employees")
	WebElement numOfEmployees;
	
	@FindBy(name="status")
	WebElement statusSelect;
	
	@FindBy(name="source")
	WebElement source;
	
	@FindBy(xpath="//form[@id='companyForm']/table/tbody/tr[8]/td/input")
	WebElement SaveBtn;
	
	@FindBy(xpath="//a[@context='company']")
	List<WebElement> compainesName;
	
	@FindBy(xpath="//input[@name='client_id']")
	List<WebElement> checkBox;
	
	@FindBy(xpath="//input[@value='Delete Checked']")
	WebElement deleteCheckedBtn;
	
	public CompaniesPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyCreateNewCompaniesLabel() {
		return createNewCompanyLabel.isDisplayed();
	}
	public boolean verifyCompaniesTagLabel() {
		return createNewCompanyLabel.isDisplayed();
	}
	
	public boolean verifyCompaniesDescriptionLabel() {
		return createNewCompanyLabel.isDisplayed();
	}
	
	public void createNewCompanies(String comName, String indName, String numOfEmp, String staSelect, String sourelect ) {
		
		companyName.sendKeys(comName);
		industryName.sendKeys(indName);
		numOfEmployees.sendKeys(numOfEmp);
		Select select=new Select(statusSelect);
		select.selectByVisibleText(staSelect);
		Select selectSo=new Select(source);
		selectSo.selectByVisibleText(sourelect);
		SaveBtn.click();
	}
	
	public void deleteCreateNewCompanies(String comName) {
		for(int i=0; i<compainesName.size(); i++) {
		String s=compainesName.get(i).getText();
		if(s.equals(comName)) {
			checkBox.get(i+1).click();
			deleteCheckedBtn.click();
			driver.switchTo().alert().accept();
		}
		}
	}
	

}
