package com.zeebu.projects.UI.pages;

import com.zeebu.reusableLibrary.keywords.WebUI;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class IndividualPoolPage extends CommonPage{

  //Locators of the Individual Pool in balancer UI
  private By firstPool_loc = By.xpath("//p[text()='Pool name']/parent::div/parent::div/parent::div//div[@class='css-1ki54i'][1]//a");
  private By totalLiquidityValue_loc = By.xpath("(//h2[normalize-space()='Total liquidity']/parent::div/parent::div//h2)[2]");
  private By poolStats_loc = By.xpath("//div[normalize-space()='Pool stats']");
  private By poolActivity_loc = By.xpath("//h2[normalize-space()='Pool activity']");
  private By poolComposition_loc = By.xpath("//h2[normalize-space()='Pool composition']");
  private By poolAttributes_loc = By.xpath("//h2[normalize-space()='Pool attributes']");
  private By poolContracts_loc = By.xpath("//h2[normalize-space()='Pool contracts']");
  private By poolCreationDate_loc = By.xpath("(//p[text()='Creation date']/parent::div/parent::div//p)[2]");
  private By poolType_loc = By.xpath("(//p[text()='Type']/parent::div/parent::div//p)[2]");
  private By poolWeight_loc = By.xpath("(//div[@class='chakra-stack css-1dbqolu']//p)");
  private By poolAddress_loc = By.xpath("(//p[text()='Pool address']/parent::div/parent::div//p)[2]//ancestor::a");
  private By poolName_loc = By.xpath("(//p[text()='Name']/parent::div/parent::div//p)[2]");
  private By poolTypesListOnTable_Loc = By.xpath("//p[@class='chakra-text css-qpgsy8']");
  private By poolNotFound_Loc = By.xpath("//p[text()='No pools found']");
  private By serachInput_Loc = By.xpath("//input[@id='search']");



  public String gotoFirstPoolAndReturnID() {
   String[] ID= WebUI.getAttribute(firstPool_loc,"href").split("/");
   WebUI.clickElement(firstPool_loc,"First Pool");
    return ID[ID.length-1];
  }

  public String gotoFirstPoolAndReturnPoolType() {
    String poolType=WebUI.getText(poolTypesListOnTable_Loc);
    WebUI.clickElement(firstPool_loc,"First Pool");
    return poolType;
  }

  public void isUserOnPoolPage() {
   WebUI.validateWebElement(poolStats_loc,"Pool Stats");
   WebUI.validateWebElement(poolActivity_loc,"Pool Activity");
   WebUI.validateWebElement(poolComposition_loc,"Pool composition");
   WebUI.validateWebElement(poolAttributes_loc,"Pool Attributes");
   WebUI.validateWebElement(poolContracts_loc,"Pool Contracts");
  }

  public void  validatePoolCreationDate(long unixTimestamp) {

    // Convert to Instant
    Instant instant = Instant.ofEpochSecond(unixTimestamp);

    // Convert Instant to ZonedDateTime with system's default timezone
    ZonedDateTime dateTime = instant.atZone(ZoneId.systemDefault());

    // Define the desired date format
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");

    // Format the ZonedDateTime to a string
    String formattedDate = dateTime.format(formatter);

    // Output the result
    System.out.println(formattedDate);

   String UICreatedDate= WebUI.getText(poolCreationDate_loc);
    Assert.assertEquals(UICreatedDate,formattedDate);

  }

  public void validatePoolType(String type) {
    WebUI.WaitForTimeout(5);
    String UIPoolType=WebUI.getText(poolType_loc);
    if (type.equalsIgnoreCase("composable_stable"))
      type = "stable";
    Assert.assertEquals(UIPoolType.toLowerCase(),type.toLowerCase());
  }

  public void validatePoolAddress(String poolAddress) {
    WebUI.ScrollToWebElement(poolAddress_loc);
    String[] actualPoolAddressArr= WebUI.getAttribute(poolAddress_loc,"href").split("/");
    String actualPoolAddress= actualPoolAddressArr[actualPoolAddressArr.length-1];
    Assert.assertEquals(actualPoolAddress,poolAddress);
  }

  public void  validatePoolName(String poolName) {
    WebUI.ScrollToWebElement(poolName_loc);
    String actualPoolName= WebUI.getText(poolName_loc);
    Assert.assertEquals(actualPoolName,poolName);
  }
}
