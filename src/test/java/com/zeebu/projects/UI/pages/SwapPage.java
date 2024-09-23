package com.zeebu.projects.UI.pages;

import com.zeebu.driver.DriverFactory;
import com.zeebu.reusableLibrary.keywords.WebUI;
import com.zeebu.reusableLibrary.utils.ExtentReportUtils;
import org.openqa.selenium.By;
import org.testng.Assert;

public class SwapPage extends CommonPage{

    //Locators of the Swap Pool in balancer UI
    private static By SwapPage_Loc = By.xpath("//span[text()='Swap']");
    private static By swap_loc = By.xpath("//a[normalize-space()='Swap']");
    private static By ToTokenDD_btn_loc = By.xpath("//button[text()='Select token']");
    private static By From_TxtBox_loc = By.xpath("(//input[@type='number'])[1]");
    private static By To_TxtBox_loc = By.xpath("(//input[@type='number'])[2]");
    private static By Network_TxtBox_loc = By.xpath("(//input[@type='text'])[1]");
    private static By toToken_Explorer_Firstloc = By.xpath("(//div[@class='chakra-stack css-1slo7oh'])[1]//a[@aria-label='View on block explorer']");
    private static By Token_Btn_Firstloc = By.xpath("(//div[@class='chakra-stack css-qwjqo1'])[1]");
    private static By First_Token_nameDD_loc = By.xpath("((//div[@class='chakra-stack css-qwjqo1'])[1]//p)[1]");
    private static By First_toToken_name_loc = By.xpath("(//button[@class='chakra-button css-1jzniqq'])[2]");
    private static By Close_loc = By.xpath("//button[@aria-label='Close']//*[name()='svg']//*[name()='path' and contains(@fill,'currentCol')]");
    private static By FromTokenDD_btn_loc = By.xpath("(//button[@class='chakra-button css-1jzniqq'])[1]");

    public void navigateToSwapPage(){
        WebUI.waitForPageLoaded();
        WebUI.clickElement(swap_loc,"Swap Link");
    }

     public void isUserOnSwapPage(){
        WebUI.waitForPageLoaded();
         WebUI.validatePage(SwapPage_Loc,"Swap Page");
     }

     public void  validateToTokenDropdown(){
         WebUI.clickElement(ToTokenDD_btn_loc,"To Token Dropdown");
         WebUI.clickElement(Token_Btn_Firstloc,"To First Token");
         String tokenName=WebUI.getText(First_Token_nameDD_loc);
         WebUI.clickElement(Close_loc,"Close Button");
         String NewtokenName=WebUI.getText(First_toToken_name_loc);
         Assert.assertEquals(NewtokenName,tokenName);
     }

    public void  validateFromTokenDropdown(){
        WebUI.clickElement(FromTokenDD_btn_loc,"From Token Dropdown");
        WebUI.clickElement(Token_Btn_Firstloc,"From First Token");
        String tokenName=WebUI.getText(First_Token_nameDD_loc);
        WebUI.clickElement(Close_loc,"Close Button");
        String NewtokenName=WebUI.getText(FromTokenDD_btn_loc);
        Assert.assertEquals(NewtokenName,tokenName);
    }

    public void  validateToToken_textbox_Disable(){
        boolean isReadOnly = DriverFactory.getDriver().findElement(To_TxtBox_loc).getAttribute("readonly") != null;
        Assert.assertEquals(isReadOnly,false);
    }

    public void selectNetwork(String Network){
        WebUI.EnterInputToTextBox(Network_TxtBox_loc,Network,Network);
        if(Network.equals("MAINNET"))
            Network="ETHEREUM";
        String xpath = "(//p[contains(translate(text(), \"ABCDEFGHIJKLMNOPQRSTUVWXYZ\", \"abcdefghijklmnopqrstuvwxyz\"), '" + Network.toLowerCase() + "')])[1]";
        WebUI.clickElement(By.xpath(xpath),Network);
    }

    public void  validateSwap(){
        WebUI.EnterInputToTextBox(From_TxtBox_loc,"1","From Token Amount");
        WebUI.clickElement(ToTokenDD_btn_loc,"To Token Dropdown");
        WebUI.clickElement(Token_Btn_Firstloc,"To First Token");
        WebUI.clickElement(Close_loc,"Close Button");
        WebUI.WaitForTimeout(5);
        String FromToken=WebUI.getText(FromTokenDD_btn_loc);
        String ToToken=WebUI.getText(First_toToken_name_loc);
        String SwapAmount= WebUI.getAttribute(To_TxtBox_loc,"title");
        ExtentReportUtils.passWithScreenshot("For 1 "+FromToken+" You will get :"+SwapAmount+" "+ToToken);
    }
}
