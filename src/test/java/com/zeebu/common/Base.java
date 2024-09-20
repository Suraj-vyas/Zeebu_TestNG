package com.zeebu.common;

import com.zeebu.driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class Base {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Initialize driver based on config
        DriverFactory.initDriver();
        driver = DriverFactory.getDriver();
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
