package com.crm.qa.pageTests;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.Utility.TestUtility;
import com.crm.qa.base.TestBase;
import com.crm.qa.pageObjects.DealsPage;
import com.crm.qa.pageObjects.HomePage;
import com.crm.qa.pageObjects.LoginPage;

public class DealsPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	TestUtility testUtility;
	DealsPage dealsPage;
	
	@BeforeMethod
	public void setUp() {
		browserSetup();
		loginPage = new LoginPage();
		testUtility=new TestUtility();
		dealsPage= new DealsPage();
		
		homePage = loginPage.login(prop.getProperty("Username"), prop.getProperty("Password"));
		testUtility.swichToFrame();
		homePage.clickOnNewDealsLink();
	}
	
	@Test(priority=1, enabled = true)
	public void verifyDealsPageLabel() {
		Assert.assertTrue(dealsPage.getDealsLabelDis());
	}
	
	@DataProvider
	public Object[][] getNewDealsPage() {
		return TestUtility.getTestData("deals");
		
	}
	
	@Test(priority=2, dataProvider="getNewDealsPage")
	public void verifyCreateNewDeals(String titleFiled, String companyFiled, String amountField, String probabilityField, String commissionField) {
		dealsPage.createNewDeals(titleFiled, companyFiled, amountField, probabilityField, commissionField);
	}
	
	@AfterMethod 
	public void tearDown(ITestResult result) {
		if(ITestResult.FAILURE == result.getStatus()) {
			TestUtility.takeScreenshotAtEndOfTest(driver, result.getName());
		}
		driver.quit();
	}

}
