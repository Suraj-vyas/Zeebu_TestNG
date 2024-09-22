// src/main/java/utils/ScreenshotUtil.java
package com.zeebu.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;

public class ScreenshotUtils {
    private static final String SCREENSHOT_FOLDER = System.getProperty("user.dir") + "/test-output/screenshots/";

    public static String takeScreenshot(WebDriver driver, String screenshotName) {
        // Create the screenshot directory if it doesn't exist
        try {
            Files.createDirectories(Paths.get(SCREENSHOT_FOLDER));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Take the screenshot
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timestamp = LocalDateTime.now().toString().replace(":", "-").replace(".", "-");
        String destPath = SCREENSHOT_FOLDER + screenshotName + "_" + timestamp + ".png";
        File destFile = new File(destPath);

        try {
            Files.copy(srcFile.toPath(), destFile.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return destPath;
    }

    public static String takeScreenshotAsBase64(WebDriver driver, String screenshotName) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
    }

}
