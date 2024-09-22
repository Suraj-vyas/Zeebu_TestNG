package com.zeebu.tests;

import com.zeebu.reusableLibrary.common.Base;
import com.zeebu.reusableLibrary.keywords.WebUI;
import org.testng.annotations.Test;


public class PoolsPageTest extends Base {

    @Test(description = "Validating the Balancer Pools Page Title")
    public void TC01_Validate_Balancer_Pools_Page_Title(){
        WebUI.validatePageTitle("Balancer DeFi Liquidity Pools");
    }

    @Test(description = "Validating the User is on Balancer Pools Pagee")
    public void TC02_Validate_Balancer_Pools_Page(){
        getPoolsPage().navigateToPoolsPage();
        getPoolsPage().isUserOnPoolsPage();
    }

}

