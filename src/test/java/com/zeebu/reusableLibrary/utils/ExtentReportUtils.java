package com.zeebu.reusableLibrary.utils;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.zeebu.reusableLibrary.common.Base;
import com.zeebu.driver.DriverFactory;
import com.zeebu.utils.ScreenshotUtils;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import java.io.IOException;

public class ExtentReportUtils {
//    public  static WebDriver driver = DriverFactory.getDriver();

    public static void log(String message, Status status) {
        Base.test.log(status, message);
    }

    public static void log(ITestResult message, Status status) {
        Base.test.log(status, message.getThrowable());
    }

    public static void info(String message) {
        Base.test.info(message);
    }

    public static void pass(String message) {
        Base.test.pass(message);
    }

    public static void fail(String message) {
        Base.test.fail(message);
    }

    public static void skip(String message) {
        Base.test.skip(message);
    }

    public static void error(String message) {
        Base.test.error(message);
    }

    public static void passWithScreenshot(String message) {
        WebDriver driver = DriverFactory.getDriver();
        String base64Screenshot = ScreenshotUtils.takeScreenshotAsBase64(driver, "Passed Screenshot");
        try {
            Base.test.pass(message,MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void addScreenshotToReport(ITestResult result, Status status) {
        WebDriver driver = DriverFactory.getDriver();
        String base64Screenshot = ScreenshotUtils.takeScreenshotAsBase64(driver, result.getMethod().getMethodName());
        try {
            Base.test.log(status,result.getThrowable(),
                    MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
