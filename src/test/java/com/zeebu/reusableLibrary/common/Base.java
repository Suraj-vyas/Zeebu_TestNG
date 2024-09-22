package com.zeebu.reusableLibrary.common;

import com.aventstack.extentreports.reporter.configuration.Theme;
import com.zeebu.driver.DriverFactory;
import com.zeebu.reusableLibrary.listeners.TestListener;
import com.zeebu.projects.UI.pages.CommonPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import static com.zeebu.constants.FrameworkConstants.*;
import static com.zeebu.constants.FrameworkConstants.AUTHOR;

@Listeners(TestListener.class)
public abstract class Base extends CommonPage {

    protected WebDriver driver;
    public static ExtentReports extent;
    public static com.aventstack.extentreports.ExtentTest test;

    @BeforeSuite
    public void setupReport() {
//        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/ExtentReport.html");
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(EXTENT_REPORT_FILE_PATH);
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
        driver.get(UIBaseURL);
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }

    @AfterSuite
    public void tearDownReport() {
        extent.flush();
    }

}