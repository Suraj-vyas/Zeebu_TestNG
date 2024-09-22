package com.zeebu.tests;

import com.zeebu.annotations.FrameworkAnnotation;
import com.zeebu.driver.DriverFactory;
import com.zeebu.enums.AuthorType;
import com.zeebu.enums.CategoryType;
import com.zeebu.enums.TestScenarioType;
import com.zeebu.projects.UI.pages.SwapPage;
import com.zeebu.reusableLibrary.common.Base;
import com.zeebu.reusableLibrary.dataProvider.dataProviderManager;
import com.zeebu.reusableLibrary.keywords.WebUI;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SwapPageTest extends Base {

    @FrameworkAnnotation(author = {AuthorType.Suraj}, category = {CategoryType.SANITY}, scenario = {TestScenarioType.POSITIVE})
    @Test(description = "Validating the user is on Swap Page or not")
    public void TC01Validate_Balancer_Swap_Page() {
        getSwapPage().navigateToSwapPage();
        getSwapPage().isUserOnSwapPage();
    }

    @FrameworkAnnotation(author = {AuthorType.Suraj}, category = {CategoryType.SANITY}, scenario = {TestScenarioType.POSITIVE})
    @Test(description = "Validating the Swap Page Title")
    public void TC02_Validate_Balancer_Swap_Page_Title() {
        getSwapPage().navigateToSwapPage();
        getSwapPage().isUserOnSwapPage();
        Assert.assertEquals(WebUI.getPageTitle(),"Swap tokens on Balancer");
    }

    @FrameworkAnnotation(author = {AuthorType.Suraj}, category = {CategoryType.SANITY}, scenario = {TestScenarioType.POSITIVE})
    @Test(description = "Validating the Swap To Token DropDown Operation")
    public void TC03_Validate_Balancer_Swap_ToToken_DropDown() {
        getSwapPage().navigateToSwapPage();
        getSwapPage().isUserOnSwapPage();
        getSwapPage().validateToTokenDropdown();
    }

    @FrameworkAnnotation(author = {AuthorType.Suraj}, category = {CategoryType.SANITY}, scenario = {TestScenarioType.POSITIVE})
    @Test(description = "Validating the Swap From Token DropDown Operation")
    public void TC04_Validate_Balancer_Swap_FromToken_DropDown() {
        getSwapPage().navigateToSwapPage();
        getSwapPage().isUserOnSwapPage();
        getSwapPage().validateFromTokenDropdown();
    }

    @FrameworkAnnotation(author = {AuthorType.Suraj}, category = {CategoryType.SANITY}, scenario = {TestScenarioType.POSITIVE})
    @Test(description = "Validating the Swap To Token textbox is disable")
    public void TC05_Validate_Balancer_Swap_ToToken_Textbox_Disable() {
        getSwapPage().navigateToSwapPage();
        getSwapPage().isUserOnSwapPage();
        getSwapPage().validateToToken_textbox_Disable();
    }

    @FrameworkAnnotation(author = {AuthorType.Suraj}, category = {CategoryType.SANITY}, scenario = {TestScenarioType.POSITIVE})
    @Test(dataProvider = "csvLoginData", dataProviderClass = dataProviderManager.class,description = "Validating the Swap To Token textbox is disable")
    public void TC06_Validate_Balancer_Swap_Amount(String Network) {
        getSwapPage().navigateToSwapPage();
        getSwapPage().isUserOnSwapPage();
        getSwapPage().selectNetwork(Network);
        getSwapPage().validateSwap();
    }
}
