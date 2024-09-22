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

    /**
     * Initialize the WebDriver based on the specified browser type.
     *
     * @param browser The type of browser to initialize.
     */
    public static void initDriver(BrowserType browser) {
        WebDriver webDriver;

        switch (browser) {
            case CHROME:
                ChromeOptions chromeOptions = new ChromeOptions();
                // Add any Chrome-specific options here
                webDriver = new ChromeDriver(chromeOptions);
                break;

            case FIREFOX:
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                // Add any Firefox-specific options here
                webDriver = new FirefoxDriver(firefoxOptions);
                break;

            case EDGE:
                EdgeOptions edgeOptions = new EdgeOptions();
                // Add any Edge-specific options here
                webDriver = new EdgeDriver(edgeOptions);
                break;

            case SAFARI:
                SafariOptions safariOptions = new SafariOptions();
                // Add any Safari-specific options here
                webDriver = new SafariDriver(safariOptions);
                break;

            default:
                throw new IllegalArgumentException("Browser type not supported: " + browser);
        }

        // Maximize the browser window
        webDriver.manage().window().maximize();

        // Set implicit wait using Duration (recommended in Selenium 4)
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Set the WebDriver instance to ThreadLocal
        driver.set(webDriver);
    }

    /**
     * Initialize the WebDriver based on the browser type from config.
     */
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

    /**
     * Get the current WebDriver instance.
     *
     * @return The WebDriver instance.
     */
    public static WebDriver getDriver() {
        return driver.get();
    }

    /**
     * Quit the WebDriver instance and remove it from ThreadLocal.
     */
    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
