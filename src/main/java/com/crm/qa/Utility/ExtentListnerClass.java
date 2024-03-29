package com.crm.qa.Utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentListnerClass implements ITestListener{
	ExtentSparkReporter htmlReport;
	ExtentReports reports;
	ExtentTest test;
	
	public void configureReport() {
		htmlReport= new ExtentSparkReporter(System.getProperty("user.dir")+"//Reports//CRM_Project_Result.html");
		reports= new ExtentReports();
		reports.attachReporter(htmlReport);
		
		reports.setSystemInfo("Machine", "HP");
		reports.setSystemInfo("OS", "Windos10");
		reports.setSystemInfo("Browser", "Chrome");
		
		htmlReport.config().setDocumentTitle("CRM_Project_Result_Report");
		htmlReport.config().setReportName("Happy_path_Result");
		htmlReport.config().setTheme(Theme.STANDARD);
		htmlReport.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
	}
	
	
	@Override
	public void onTestStart(ITestResult result) {
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test = reports.createTest(result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel("Name of the passed testcase is: "+result.getName(), ExtentColor.GREEN));
	
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test = reports.createTest(result.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel("Name of the failed testcase is: "+result.getName(), ExtentColor.RED));
		test.fail(result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test = reports.createTest(result.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel("Name of the skip testcase is: "+result.getName(), ExtentColor.YELLOW));
	
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		configureReport();
	}

	@Override
	public void onFinish(ITestContext context) {
		reports.flush();
	}
}
