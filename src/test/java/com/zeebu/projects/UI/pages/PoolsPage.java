package com.zeebu.projects.UI.pages;

import com.zeebu.reusableLibrary.keywords.WebUI;
import com.zeebu.reusableLibrary.pojo.Pool;
import org.openqa.selenium.By;

import java.util.Objects;

public class PoolsPage extends CommonPage{

   private static By liquidityPoolsTxt_Loc = By.xpath("//h2[text()='Liquidity pools']");
   private static By totalPools_Loc = By.xpath("//h2[text()='Liquidity pools']/parent::div//h2[2]");
   private static By filter_Loc = By.xpath("//button[@type='button' and contains(text(),'Filters')]");
   private static By allNetwork_Loc = By.xpath("//div[text()='All networks']/ancestor::button[@type='button']");
   private static String networkFilter_Loc = "//p[text()='Filters']//ancestor::div[@data-popper-placement='bottom-end']";
   private static By poolTypesListOnTable_Loc = By.xpath("//p[@class='chakra-text css-qpgsy8']");
   private static By poolTypesFilter_Loc = By.xpath("//h3[text()='Pool types']/parent::div");
   private static By closeBtn_Loc = By.xpath("//button[@aria-label='Close']");
   private static By TVLSlide_Loc = By.xpath("//div[@role='slider']");
   private static By slideInput_Loc = By.xpath("//input[@type='hidden']");
   private static By poolsNetwork_Loc =By.xpath( "//div[@class='css-1n5opag']//img");
   private static By pools_Loc = By.xpath("//a[text()='Pools']");
   private static By PoolsPage_Loc = By.xpath("//h2[text()='Liquidity pools']");
    private static By poolNotFound_Loc = By.xpath("//p[text()='No pools found']");
    private static By serachInput_Loc = By.xpath("//input[@id='search']");

  public void isUserOnPoolsPage() {
      WebUI.validatePage(PoolsPage_Loc,"Pools Page");
  }

    public void navigateToPoolsPage() {
      WebUI.waitForPageLoaded();
      WebUI.clickElement(pools_Loc,"Pools Button");
    }

    public void demotest(){
      String network="ethereum";
        System.out.println(networkFilter_Loc+"//span[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz',"+network+"/");

    }

    public void NetworkFilter(String network){
      WebUI.clickElement(filter_Loc,"Filter button");
      WebUI.clickElement(allNetwork_Loc,"All Network Dropdown");
        if (Objects.equals(network, "MAINNET"))
            network = "ethereum";
        String xpath = "("+networkFilter_Loc + "//span[contains(translate(text(), \"ABCDEFGHIJKLMNOPQRSTUVWXYZ\", \"abcdefghijklmnopqrstuvwxyz\"), '" + network.toLowerCase() + "')])[1]";
        WebUI.clickElement(By.xpath(xpath),network);
        WebUI.WaitForTimeout(5);
        WebUI.ScrollToWebElement(TVLSlide_Loc);
        WebUI.clickElementUsingJS(closeBtn_Loc,"Close Button");
    }

    public void poolTypesFilter(String PoolType) {
      WebUI.clickElementUsingJS(filter_Loc,"Filter");
        String xpath = "("+poolTypesFilter_Loc + "//p[contains(text(),"+PoolType+")]";
        WebUI.WaitForTimeout(5);
        WebUI.clickElementUsingJS(closeBtn_Loc,"Close");
    }

    public void validateNoPoolFound() {
      WebUI.EnterInputToTextBox(serachInput_Loc,"abcdefghijklm","Pool Search");
      WebUI.validateWebElement(poolNotFound_Loc,"Pool Not Found");
    }
}
