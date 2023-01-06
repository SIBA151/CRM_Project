package com.crm.qa.pageTests;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.pageObjects.CompaniesPage;
import com.crm.qa.pageObjects.HomePage;
import com.crm.qa.pageObjects.LoginPage;

import Utility.TestUtility;
import base.TestBase;

public class CompaniesPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtility testUtility;
	CompaniesPage companiesPage;
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage=new LoginPage();
		testUtility=new TestUtility();
		companiesPage=new CompaniesPage();
		homePage= loginPage.login( prop.getProperty("Username"), prop.getProperty("Password") );
		testUtility.swichToFrame();
		homePage.clickOnNewCompanyLink();
		
	}
	
	
	@Test(priority=1, enabled=false)
	public void verifyNewCompaniesPageLabel() {
		Assert.assertTrue(companiesPage.verifyCreateNewCompaniesLabel());
	}
	
	@Test(priority=2, enabled=false)
	public void verifyNewCompaniesPageTagLabel() {
		Assert.assertTrue(companiesPage.verifyCompaniesTagLabel());
	}
	
	@Test(priority=3, enabled=false)
	public void verifyNewCompaniesPageDescriptionLabel() {
		Assert.assertTrue(companiesPage.verifyCompaniesDescriptionLabel());
	}
	
	@DataProvider
	public Object[][] getCreateNewCompaniesData() {
		Object[][] data=TestUtility.getTestData("companies");
		return data;
	}
	
	@Test(priority=4, dataProvider="getCreateNewCompaniesData")
	public void createNewCompanies(String comName, String indName, String numOfEmp, String staSelect, String sourelect) {
		companiesPage.createNewCompanies(comName, indName, numOfEmp, staSelect, sourelect);
		
	}
	
	@AfterMethod 
	public void tearDown(ITestResult result) {
		if(ITestResult.FAILURE == result.getStatus()) {
			TestUtility.takeScreenshotAtEndOfTest(driver, result.getName());
		}
		driver.quit();
	}

}
