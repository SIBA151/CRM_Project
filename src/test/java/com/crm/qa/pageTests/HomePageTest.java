package com.crm.qa.pageTests;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.Utility.TestUtility;
import com.crm.qa.base.TestBase;
import com.crm.qa.pageObjects.HomePage;
import com.crm.qa.pageObjects.LoginPage;

public class HomePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	TestUtility testUtility;
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		testUtility=new TestUtility();
		homePage = loginPage.login(prop.getProperty("Username"), prop.getProperty("Password"));
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String homePageTitle=homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO");	
	}
	@Test(priority=2)
	public void verifyUserNameTest() {
		testUtility.swichToFrame();
		Assert.assertTrue(homePage.verifyUserName());
	}
	
	@Test(priority=3)
	public void verifyContactsLink() {
		testUtility.swichToFrame();
		homePage.clickOnContactsLink();
	}
	
	
	
	@AfterMethod 
	public void tearDown(ITestResult result) {
		if(ITestResult.FAILURE == result.getStatus()) {
			TestUtility.takeScreenshotAtEndOfTest(driver, result.getName());
		}
		driver.quit();
	}
	

}
