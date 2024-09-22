package com.zeebu.reusableLibrary.keywords;

import com.zeebu.driver.DriverFactory;
import com.zeebu.reusableLibrary.utils.ExtentReportUtils;
import static com.zeebu.constants.FrameworkConstants.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class WebUI {


    public static void waitForPageLoaded() {
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(WAIT_PAGE_LOADED));
        JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();

        // wait for Javascript to loaded
        ExpectedCondition<Boolean> jsLoad = driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");

        //Get JS is Ready
        boolean jsReady = js.executeScript("return document.readyState").toString().equals("complete");

        //Wait Javascript until it is Ready!
        if (!jsReady) {
            ExtentReportUtils.info("Javascript in NOT Ready!");
            //Wait for Javascript to load
            try {
                wait.until(jsLoad);
            } catch (Throwable error) {
                ExtentReportUtils.error("Timeout waiting for page load. (" + WAIT_PAGE_LOADED + "s)");
                Assert.fail("Timeout waiting for page load. (" + WAIT_PAGE_LOADED + "s)");
            }
        }
    }


    public static WebElement getWebElement(By by){
        return DriverFactory.getDriver().findElement(by);
    }

    public static List<WebElement> getWebElements(By by){
        return DriverFactory.getDriver().findElements(by);
    }

    public static void clickElement(By by, String ElementName){
        DriverFactory.getDriver().findElement(by).click();
        ExtentReportUtils.info("Clicked the "+ElementName+" WebElement successfully");
    }

    public static String getPageTitle() {
        String title = DriverFactory.getDriver().getTitle();
        ExtentReportUtils.info("Get Page Title: "+DriverFactory.getDriver().getTitle());
        return title;
    }

    public static void ScrollToWebElement(WebElement webElement){
        waitForPageLoaded();
        JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", webElement);
        ExtentReportUtils.info("Scroll to element " + webElement);

    }

    public static void validatePageTitle(String Expectedtitle) {
        waitForPageLoaded();
        String Actual=getPageTitle();
        Assert.assertEquals(Actual,Expectedtitle,"Page Title Matched Successfully");
        ExtentReportUtils.pass(Expectedtitle+" : Matched with Actual Page title : "+Actual);

    }

    public static void validatePage(By by, String ElementName) {
        waitForPageLoaded();
        boolean flag = DriverFactory.getDriver().findElement(by).isDisplayed();
        if (flag)
            ExtentReportUtils.passWithScreenshot(ElementName+" is Validated Successfully");
        else {
            ExtentReportUtils.fail(ElementName + " is Not is Validated Successfully");
            Assert.fail();
        }
    }


    public static void validateWebElement(By by, String ElementName) {
        waitForPageLoaded();
        WebElement element= DriverFactory.getDriver().findElement(by);
        boolean flag = element.isDisplayed();
        if (flag) {
            ScrollToWebElement(element);
            ExtentReportUtils.passWithScreenshot(ElementName + " is Present on WebPage");
        }
        else {
            ExtentReportUtils.fail(ElementName + " is Not Present on WebPage");
            Assert.fail();
        }
    }
}
