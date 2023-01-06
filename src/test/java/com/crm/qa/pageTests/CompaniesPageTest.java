package com.crm.qa.pageTests;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.Utility.TestUtility;
import com.crm.qa.base.TestBase;
import com.crm.qa.pageObjects.CompaniesPage;
import com.crm.qa.pageObjects.HomePage;
import com.crm.qa.pageObjects.LoginPage;

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
	
	
	@Test(priority=1, enabled=true)
	public void verifyNewCompaniesPageLabel() {
		Assert.assertTrue(companiesPage.verifyCreateNewCompaniesLabel());
	}
	
	@Test(priority=2, enabled=true)
	public void verifyNewCompaniesPageTagLabel() {
		Assert.assertTrue(companiesPage.verifyCompaniesTagLabel());
	}
	
	@Test(priority=3, enabled=true)
	public void verifyNewCompaniesPageDescriptionLabel() {
		Assert.assertTrue(companiesPage.verifyCompaniesDescriptionLabel());
	}
	
	@DataProvider
	public Object[][] getCreateNewCompaniesData() {
		Object[][] data=TestUtility.getTestData("companies");
		return data;
	}
	
	@Test(priority=4, dataProvider="getCreateNewCompaniesData", enabled=true)
	public void createNewCompanies(String comName, String indName, String numOfEmp, String staSelect, String sourelect) {
		companiesPage.createNewCompanies(comName, indName, numOfEmp, staSelect, sourelect);
		
	}
	@Test(priority=5, dataProvider="getCreateNewCompaniesData", enabled=true)
	public void VerifydeletecreateNewCompanies(String comName, String indName, String numOfEmp, String staSelect, String sourelect) {
		homePage.clickOnCompanyLink();
		companiesPage.deleteCreateNewCompanies(comName);
	}
	
	@AfterMethod 
	public void tearDown(ITestResult result) {
		if(ITestResult.FAILURE == result.getStatus()) {
			TestUtility.takeScreenshotAtEndOfTest(driver, result.getName());
		}
		driver.quit();
	}

}
