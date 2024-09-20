package com.zeebu.tests;

import  com.zeebu.common.Base;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumTest extends Base {

    @Test
    public void test() {
        driver.get("https://balancer.fi/pools");
        String title = driver.getTitle();
        Assert.assertEquals(title, "Balancer DeFi Liquidity Pools", "Title should be 'Balancer DeFi Liquidity Pools'");
    }
}
