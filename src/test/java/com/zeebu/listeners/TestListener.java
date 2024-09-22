package com.zeebu.listeners;

import com.zeebu.utils.BrowserInfoUtils;
import com.aventstack.extentreports.Status;
import com.zeebu.utils.ExtentReportUtils;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.zeebu.common.Base;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        // Initialize the test in ExtentReports
        Base.test = Base.extent.createTest(result.getMethod().getMethodName());
        ExtentReportUtils.info("Test Running on : " + BrowserInfoUtils.getBrowserInfo()+" Browser and on "+BrowserInfoUtils.getOSInfo()+" OS");
        ExtentReportUtils.info(result.getMethod().getMethodName()+ " Execution Started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentReportUtils.passWithScreenshot(result.getMethod().getDescription()+" Scenario got Passed");
        ExtentReportUtils.pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentReportUtils.addScreenshotToReport(result,Status.FAIL);
        ExtentReportUtils.fail(result.getMethod().getDescription()+" Scenario got failed");
        ExtentReportUtils.fail("Test Failed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
       ExtentReportUtils.skip("Test Skipped");
       ExtentReportUtils.skip(String.valueOf(result.getThrowable()));
    }
}

