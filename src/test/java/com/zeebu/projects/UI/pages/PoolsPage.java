package com.zeebu.projects.UI.pages;

import com.zeebu.reusableLibrary.keywords.WebUI;
import com.zeebu.reusableLibrary.pojo.Pool;
import org.openqa.selenium.By;

public class PoolsPage extends CommonPage{

   private static By liquidityPoolsTxt_Loc = By.xpath("//h2[text()='Liquidity pools']");
   private static By totalPools_Loc = By.xpath("//h2[text()='Liquidity pools']/parent::div//h2[2]");
   private static By filter_Loc = By.xpath("//button[@type='button' and contains(text(),'Filters')]");
   private static By allNetwork_Loc = By.xpath("//div[text()='All networks']/ancestor::button[@type='button']");
   private static By networkFilter_Loc = By.xpath("//p[text()='Filters']//ancestor::div[@data-popper-placement='bottom-end']");
   private static By poolTypesListOnTable_Loc = By.xpath("//p[@class='chakra-text css-qpgsy8']");
   private static By poolTypesFilter_Loc = By.xpath("//h3[text()='Pool types']/parent::div");
   private static By closeBtn_Loc = By.xpath("//button[@aria-label='Close']");
   private static By TVLSlide_Loc = By.xpath("//div[@role='slider']");
   private static By slideInput_Loc = By.xpath("//input[@type='hidden']");
   private static By poolsNetwork_Loc =By.xpath( "//div[@class='css-1n5opag']//img");
   private static By pools_Loc = By.xpath("//a[text()='Pools']");
   private static By PoolsPage_Loc = By.xpath("//h2[text()='Liquidity pools']");

  public void isUserOnPoolsPage() {
      WebUI.validatePage(PoolsPage_Loc,"Pools Page");
  }

    public void navigateToPoolsPage() {
      WebUI.waitForPageLoaded();
      WebUI.clickElement(pools_Loc,"Pools Button");
    }
}
