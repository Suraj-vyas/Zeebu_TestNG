package com.zeebu.projects.UI.pages;

import org.openqa.selenium.By;

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
}
