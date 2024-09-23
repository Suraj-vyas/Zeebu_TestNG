package com.zeebu.driver;

import com.zeebu.utils.ConfigReader;
import static com.zeebu.constants.FrameworkConstants.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;


import java.time.Duration;

public class DriverFactory {

    // ThreadLocal ensures thread safety in parallel execution
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    // Enum for supported browsers
    public enum BrowserType {
        CHROME,
        FIREFOX,
        EDGE,
        SAFARI
    }

    //Browser Initilization
    public static void initDriver(BrowserType browser) {
        WebDriver webDriver;

        switch (browser) {
            case CHROME:
                ChromeOptions chromeOptions = new ChromeOptions();
                webDriver = new ChromeDriver(chromeOptions);
                break;

            case FIREFOX:
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                webDriver = new FirefoxDriver(firefoxOptions);
                break;

            case EDGE:
                EdgeOptions edgeOptions = new EdgeOptions();
                webDriver = new EdgeDriver(edgeOptions);
                break;

            case SAFARI:
                SafariOptions safariOptions = new SafariOptions();
                webDriver = new SafariDriver(safariOptions);
                break;

            default:
                throw new IllegalArgumentException("Browser type not supported: " + browser);
        }

        // Maximize the browser window
        webDriver.manage().window().maximize();

        // Set implicit wait using Duration
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Set the WebDriver instance to ThreadLocal
        driver.set(webDriver);
    }

    //Initialize the WebDriver based on the browser type from config.
    public static void initDriver() {
        String browserName = BROWSER.toUpperCase();
        BrowserType browser;
        try {
            browser = BrowserType.valueOf(browserName);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid browser type specified in config.properties: " + browserName, e);
        }
        initDriver(browser);
    }


    //Return the Driver Instance
    public static WebDriver getDriver() {
        return driver.get();
    }

    //Quit the WebDriver instance and remove it from ThreadLocal.
    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
