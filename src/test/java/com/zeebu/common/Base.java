package com.zeebu.common;

import com.aventstack.extentreports.reporter.configuration.Theme;
import com.zeebu.driver.DriverFactory;
import com.zeebu.listeners.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import static com.zeebu.constants.FrameworkConstants.*;
import static com.zeebu.constants.FrameworkConstants.AUTHOR;

@Listeners(TestListener.class)
public abstract class Base {

    protected WebDriver driver;
    public static ExtentReports extent;
    public static com.aventstack.extentreports.ExtentTest test;

    @BeforeSuite
    public void setupReport() {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/ExtentReport.html");
        htmlReporter.config().setDocumentTitle(REPORT_TITLE);
        htmlReporter.config().setReportName(TESTCATEGORY);
        htmlReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Project", PROJECT);
        extent.setSystemInfo("Test Environment", ENVIRONMENT);
        extent.setSystemInfo("Release", RELEASE);
        extent.setSystemInfo("User Name",  AUTHOR);
    }

    @BeforeMethod
    public void setUp() {
        DriverFactory.initDriver();
        driver = DriverFactory.getDriver();
        System.out.println("Driver initialized in thread: " + Thread.currentThread().getId());
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
        System.out.println("Driver quit in thread: " + Thread.currentThread().getId());
    }

    @AfterSuite
    public void tearDownReport() {
        extent.flush();
    }

}