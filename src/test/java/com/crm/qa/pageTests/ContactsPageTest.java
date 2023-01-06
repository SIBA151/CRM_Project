package com.crm.qa.pageTests;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.pageObjects.ContactsPage;
import com.crm.qa.pageObjects.HomePage;
import com.crm.qa.pageObjects.LoginPage;


import Utility.TestUtility;
import base.TestBase;

public class ContactsPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	TestUtility testUtility;
	ContactsPage contactsPage;
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		testUtility=new TestUtility();
		contactsPage= new ContactsPage();
		homePage = loginPage.login(prop.getProperty("Username"), prop.getProperty("Password"));
		testUtility.swichToFrame();
		homePage.clickOnContactsLink();
	}
	
	
	@Test(priority=1, enabled=true)
	public void verifyContactsPageLabel() {
		Assert.assertTrue(contactsPage.verifyContactsLabel());
	}
	
	@Test(priority=2, enabled=true)
	public void selectContactsTest() {
		contactsPage.selectContactByName("abc abc");
	}
	
	@DataProvider
	public Object[][] getCRMTestData() {
		Object [][] data=TestUtility.getTestData("contacts");
		return data;
	}
	
	 
	@Test(priority=4, dataProvider="getCRMTestData", enabled=true)
	public void validateCreateNewContactinC(String title, String firstName, String lastName, String company) {
		contactsPage.addNewContactBtn();
		contactsPage.createNewContact(title, firstName, lastName, company);
	}
	
	@AfterMethod 
	public void tearDown(ITestResult result) {
		if(ITestResult.FAILURE == result.getStatus()) {
			TestUtility.takeScreenshotAtEndOfTest(driver, result.getName());
		}
		driver.quit();
	}

}
