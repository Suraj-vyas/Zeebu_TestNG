package com.zeebu.tests;

import com.zeebu.annotations.FrameworkAnnotation;
import com.zeebu.enums.AuthorType;
import com.zeebu.enums.CategoryType;
import com.zeebu.enums.TestScenarioType;
import com.zeebu.reusableLibrary.common.Base;
import com.zeebu.reusableLibrary.dataProvider.dataProviderManager;
import com.zeebu.reusableLibrary.keywords.WebUI;
import org.openqa.selenium.By;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import java.util.Map;

public class PoolsPageTest extends Base {

    @FrameworkAnnotation(author = {AuthorType.Suraj}, category = {CategoryType.SANITY}, scenario = {TestScenarioType.POSITIVE})
    @Test(description = "Validating the Balancer Pools Page Title")
    public void TC01_Validate_Balancer_Pools_Page_Title(){
        getPoolsPage().navigateToPoolsPage();
        getPoolsPage().isUserOnPoolsPage();
        WebUI.validatePageTitle("Balancer DeFi Liquidity Pools");
    }

    @FrameworkAnnotation(author = {AuthorType.Suraj}, category = {CategoryType.SANITY}, scenario = {TestScenarioType.POSITIVE})
    @Test(description = "Validating the User is on Balancer Pools Pagee")
    public void TC02_Validate_Balancer_Pools_Page(){
        getPoolsPage().navigateToPoolsPage();
        getPoolsPage().isUserOnPoolsPage();
    }

    @FrameworkAnnotation(author = {AuthorType.Suraj}, category = {CategoryType.SANITY}, scenario = {TestScenarioType.POSITIVE})
    @Test(dataProvider = "jsonDataProvider", dataProviderClass = dataProviderManager.class,description = "Validating the Network Filter on Balancer Pools Page")
    public void Validate_NetWork_Filter_for_SupportedNetworks(Map<String, Object> testData){
        // Extract data from the Map
        String Network = (String) testData.get("network");
        getPoolsPage().navigateToPoolsPage();
        getPoolsPage().isUserOnPoolsPage();
        getPoolsPage().NetworkFilter(Network);
    }

    @FrameworkAnnotation(author = {AuthorType.Suraj}, category = {CategoryType.SANITY}, scenario = {TestScenarioType.NEGATIVE})
    @Test(description = "Validating the No Pool Found on Mode Network")
    public void TC03_Validate_No_Pool_found_Filter_for_Mode_Network() {
        getPoolsPage().navigateToPoolsPage();
        getPoolsPage().isUserOnPoolsPage();
        //Applying the network Filter
        getPoolsPage().NetworkFilter("MODE");
        //Validating the network filter
        getPoolsPage().poolTypesFilter("CoW AMM");
        //Validate No Pools Found
       getPoolsPage().validateNoPoolFound();
    }
}

