package com.crm.qa.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.crm.qa.base.TestBase;

public class DealsPage extends TestBase{
	
	private By dealsLabel=By.xpath("//legend[contains(text(),'Deal')]");
	private By titleFiled=By.cssSelector("#title");
	private By companyFiled=By.cssSelector("input[name='client_lookup']");
	private By amountField=By.cssSelector("input[name='amount']");
	private By probabilityField=By.id("probability"); 
	private By commissionField=By.name("commission");
	private By saveAndCreateAnotherBtn=By.xpath("//td[@colspan='2']//input[@value='Save']");
	
	public boolean getDealsLabelDis() {
		return getElement(dealsLabel).isDisplayed();
	}
	
	public WebElement getTitleFiled() {
		return getElement(titleFiled);
	}
	
	public WebElement getCompanyFiled() {
		return getElement(companyFiled);
	}
	
	public WebElement getAmountField() {
		return getElement(amountField);
	}
	
	public WebElement getProbabilityField() {
		return getElement(probabilityField);
	}
	
	public WebElement getCommissionField() {
		return getElement(commissionField);
	}
	
	public WebElement getSaveAndCreateAnotherBtn() {
		return getElement(saveAndCreateAnotherBtn);
	}
	
	public void createNewDeals(String tit, String comp, String amo, String pro, String com ) {
		getTitleFiled().sendKeys(tit);
		getCompanyFiled().sendKeys(comp);
		getAmountField().sendKeys(amo);
		getProbabilityField().sendKeys(pro);
		getCommissionField().sendKeys(com);
		getSaveAndCreateAnotherBtn().click();
	}

}
