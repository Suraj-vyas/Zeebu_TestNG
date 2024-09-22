package com.zeebu.tests;

import com.zeebu.annotations.FrameworkAnnotation;
import com.zeebu.enums.CategoryType;
import com.zeebu.reusableLibrary.common.Base;
import com.zeebu.enums.*;
import com.zeebu.reusableLibrary.keywords.WebUI;
import jdk.jfr.Category;
import org.testng.annotations.Test;

public class BalancerHomePageTest extends Base {

    @FrameworkAnnotation(author = {AuthorType.Suraj}, category = {CategoryType.SANITY}, scenario = {TestScenarioType.POSITIVE})
    @Test(description = "Validating the Balancer Home Page Title")
    public void TC01_Validate_Balancer_Home_Page_Title(){
        getBalancerHomePage().validateBalancerHomePageTitle("Balancer DeFi AMMs made easy");
    }

    @FrameworkAnnotation(author = {AuthorType.Suraj}, category = {CategoryType.SANITY}, scenario = {TestScenarioType.POSITIVE})
    @Test(description = "Validating the User is on Balancer Home Page")
    public void TC02_Validate_Balancer_Home_Page(){
        getBalancerHomePage().isUserOnBalancerHomePage();
    }

    @FrameworkAnnotation(author = {AuthorType.Suraj}, category = {CategoryType.SANITY}, scenario = {TestScenarioType.POSITIVE})
    @Test(description = "Validating the Pools button on Balancer Home Page")
    public void TC03_Validate_Balancer_Home_Page_PoolsButton(){
        getBalancerHomePage().validatePoolsButton();
    }

    @FrameworkAnnotation(author = {AuthorType.Suraj}, category = {CategoryType.SANITY}, scenario = {TestScenarioType.POSITIVE})
    @Test(description = "Validating the Swap button on Balancer Home Page")
    public void TC04_Validate_Balancer_Home_Page_SwapButton(){
        getBalancerHomePage().validateSwapButton();
    }

    @FrameworkAnnotation(author = {AuthorType.Suraj}, category = {CategoryType.SANITY}, scenario = {TestScenarioType.POSITIVE})
    @Test(description = "Validating the Portfolio button on Balancer Home Page")
    public void TC05_Validate_Balancer_Home_Page_PortfolioButton(){
        getBalancerHomePage().validatePortfolioButton();
    }

    @FrameworkAnnotation(author = {AuthorType.Suraj}, category = {CategoryType.SANITY}, scenario = {TestScenarioType.POSITIVE})
    @Test(description = "Validating the Explore Pool button on Balancer Home Page")
    public void TC06_Validate_Balancer_Home_Page_ExplorePoolButton(){
        getBalancerHomePage().validateExplorePoolButton();
    }

    @FrameworkAnnotation(author = {AuthorType.Suraj}, category = {CategoryType.SANITY}, scenario = {TestScenarioType.POSITIVE})
    @Test(description = "Validating the Footer on Balancer Home Page")
    public void TC07_Validate_Balancer_Home_Page_Footer(){
        getBalancerHomePage().validateFooter();
    }

    @FrameworkAnnotation(author = {AuthorType.Suraj}, category = {CategoryType.SANITY}, scenario = {TestScenarioType.POSITIVE})
    @Test(description = "Validating the Theme button on Balancer Home Page")
    public void TC08_Validate_Balancer_Home_Page_Theme_Button(){
        getBalancerHomePage().validatePageTheme();
    }
}
