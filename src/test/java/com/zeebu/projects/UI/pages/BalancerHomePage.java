package com.zeebu.projects.UI.pages;

import com.zeebu.driver.DriverFactory;
import com.zeebu.reusableLibrary.keywords.WebUI;
import org.openqa.selenium.By;
import org.testng.Assert;

public class BalancerHomePage extends CommonPage {

    //Balancer Home Page Locators
     private static By BalancerIcon_loc = By.xpath("//div[@class='css-ozv6cb']//*[name()='svg']//*[name()='path' and contains(@class,'svg-path')]");
     private static By pools_loc = By.xpath("//a[normalize-space()='Pools']");
     private static By swap_loc = By.xpath("//a[normalize-space()='Swap']");
     private static By portfolio_loc = By.xpath("//a[normalize-space()='Portfolio']");
     private static By veBAL_loc = By.xpath("//a[normalize-space()='veBAL']");
     private static By ExplorePool_loc = By.xpath("//a[@class='chakra-button css-8cbk3k']");
     private static By BuildIcon_loc = By.xpath("//h2[@class='chakra-heading css-jhq7t9']");
     private static By footer_Loc = By.xpath("//footer");
     private static By PoolsPage_Loc = By.xpath("//h2[text()='Liquidity pools']");
     private static By SwapPage_Loc = By.xpath("//span[text()='Swap']");
     private static By PortfolioPage_Loc = By.xpath("//h2[text()='Balancer portfolio']");
     private static By ThemeChange_Loc = By.xpath("//button[@type='button']//i//*[name()='svg']");
     private static By LightTheme = By.xpath("//body[@class='__className_f62a92 chakra-ui-light']");
     private static By DarkTheme= By.xpath("//body[@class='__className_f62a92 chakra-ui-dark']");


    public void validateBalancerHomePageTitle(String Expectedtitle){
        WebUI.validatePageTitle(Expectedtitle);
    }

    public void isUserOnBalancerHomePage(){
        WebUI.validateWebElement(BalancerIcon_loc,"Balancer Icon");
        WebUI.validateWebElement(pools_loc,"Pools Link");
        WebUI.validateWebElement(swap_loc,"Swap Link");
        WebUI.validateWebElement(portfolio_loc,"Portfolio Link");
        WebUI.validateWebElement(veBAL_loc,"VeBAL Link");
    }

    public void validatePoolsButton(){
       WebUI.waitForPageLoaded();
       WebUI.clickElement(pools_loc,"Pools Link");
       WebUI.validatePage(PoolsPage_Loc,"Pools Page");
    }

    public void validateSwapButton(){
        WebUI.waitForPageLoaded();
        WebUI.clickElement(swap_loc,"Swap Link");
        WebUI.validatePage(SwapPage_Loc,"Swap Page");
    }

    public void validatePortfolioButton(){
        WebUI.waitForPageLoaded();
        WebUI.clickElement(portfolio_loc,"Portfolio Link");
        WebUI.validatePage(PortfolioPage_Loc,"Portfolio Page");
    }

    public void validateExplorePoolButton(){
        WebUI.waitForPageLoaded();
        WebUI.clickElement(ExplorePool_loc,"Explore Pool_loc Link");
        WebUI.validatePage(PoolsPage_Loc,"Pools Page");
    }

    public void validateFooter(){
        WebUI.waitForPageLoaded();
        WebUI.validateWebElement(footer_Loc,"Footer");
    }

    public void validatePageTheme(){
        WebUI.waitForPageLoaded();
        WebUI.validateWebElement(ThemeChange_Loc,"Theme Change Icon");
        if(DriverFactory.getDriver().findElement(DarkTheme).isDisplayed()){
            WebUI.clickElement(ThemeChange_Loc,"Theme Change Icon");
            WebUI.validatePage(LightTheme,"Light Theme Page");
        }
        else {
            WebUI.clickElement(ThemeChange_Loc,"Theme Change Icon");
            WebUI.validatePage(DarkTheme,"Dark Theme Page");
        }


    }
}
