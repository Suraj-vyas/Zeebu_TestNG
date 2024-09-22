package com.zeebu.tests;

import com.zeebu.reusableLibrary.common.Base;
import com.zeebu.reusableLibrary.dataProvider.dataProviderManager;
import static com.zeebu.constants.FrameworkConstants.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

public class SeleniumTest extends Base {

    @Test(dataProvider = "excelLoginData",dataProviderClass = dataProviderManager.class)
    public void test(String username, String password) throws InterruptedException {
        System.out.println("username "+ username);
        System.out.println("Password "+ password);
//        driver.get("https://balancer.fi/pools");
//        String title = driver.getTitle();
//        System.out.println("test() running on thread: " + Thread.currentThread().getId());
//        Assert.assertEquals(title, "Balancer DeFi Liquidity Pools", "Title should be 'Balancer DeFi Liquidity Pools'");
//        Thread.sleep(5000); // Add delay to observe parallelism
    }

    @Test(dataProvider = "jsonDataProvider", dataProviderClass = dataProviderManager.class)
    public void testLoginWithJsonData(Map<String, Object> testData) throws InterruptedException {
        // Extract data from the Map
        String username = (String) testData.get("username");
        String password = (String) testData.get("password");
        String expectedTitle = (String) testData.get("expectedTitle");
        System.out.println("username "+ username);
        System.out.println("Password "+ password);
    }
    @Test(description = "Validating the page Title")
    public void test1() throws InterruptedException, IOException {
        driver.get(UIBaseURL);
        String title = driver.getTitle();
        Assert.assertEquals(title, "Balancer DeFi Liquidity Pool", "Title should be 'Balancer DeFi Liquidity Pools'");

    }

    @Test(description = "Validating the page Title")
    public void test2() throws InterruptedException {
//        getPoolsPage().updateProfile();
//        driver.get(UIBaseURL);
//        String title = driver.getTitle();
//        Assert.assertEquals(title, "Balancer DeFi Liquidity Pools", "Title should be 'Balancer DeFi Liquidity Pools'");
    }
}
