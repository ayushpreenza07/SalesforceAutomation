package SalesforceModules;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageobjects.SalesforceObjects.LeadsPage;
import step_definitions.RunCukesTest;
import utilities.*;

import java.io.IOException;
import java.util.HashMap;


import static org.testng.Assert.assertEquals;


public class Leads {
    public static HashMap<String, String> dataMap = new HashMap<String, String>();

    public static void ClickOnHamburgerMenu(String logStep) throws InterruptedException {
        KeywordUtil.delay(1000);
        try {
            KeywordUtil.waitForVisible(LeadsPage.hamburgerMenu);
            KeywordUtil.click(LeadsPage.hamburgerMenu, logStep);
        }
        catch (Exception e){
            Assert.fail("Hamburger menu not clicked");
        }
    }

    public static void EnterText(String text) throws InterruptedException {
        KeywordUtil.delay(1000);
        try {
            KeywordUtil.inputText(LeadsPage.searchText, ConfigReader.getValue("SearchText"), "User Entered Text");
            KeywordUtil.delay(2000);
            KeywordUtil.pressEnter(LeadsPage.searchText);
        }
        catch (Exception e){
            Assert.fail("Text not entered in Search box");
        }
    }

    public static void verifyPageTitle(){
        String expectedTitle;
        try {
            expectedTitle = KeywordUtil.getElementText(LeadsPage.leadsPageTitle);
            assertEquals(KeywordUtil.getElementText(LeadsPage.leadsPageTitle), "Leads");
            RunCukesTest.logger.log(LogStatus.PASS,
                    HTMLReportUtil.passStringGreenColor("verified <font color='green'>" + expectedTitle + "</font> page"));
        }
        catch (Exception e){
            Assert.fail("leades page title not showing");
        }
        }

    public static void clickNewButton() throws InterruptedException {

        try {
            KeywordUtil.waitForVisible(LeadsPage.leadesNewButton);
            KeywordUtil.click(LeadsPage.leadesNewButton, "Clicked New Button");
        }
        catch (Exception e){
            Assert.fail("New button not tapped");
        }
        }

    public static void clickOnSaveButton(){
        try {
            KeywordUtil.waitForVisible(LeadsPage.saveButton);
            KeywordUtil.click(LeadsPage.saveButton, "Clicked on Save Button");
        }
        catch (Exception e){
            Assert.fail("Save button not clicked");
        }
     }

    public static void verifyOpenNotContacted(){
    try {
        String expectedText = KeywordUtil.getVisibleText(LeadsPage.openNotContacted);
        assertEquals(KeywordUtil.getElementText(LeadsPage.openNotContacted), "Open - Not Contacted");
        RunCukesTest.logger.log(LogStatus.PASS,
                HTMLReportUtil.passStringGreenColor("verified <font color='green'>" + expectedText + "</font> page"));
    }
    catch (Exception e){
        Assert.fail("Open not contacted button not displayed ");
    }
    }

    public static void clickOnCovertedTab () throws InterruptedException {
        try {
        KeywordUtil.scrollup(LeadsPage.converted);
        KeywordUtil.waitForVisible(LeadsPage.converted);
        KeywordUtil.click(LeadsPage.converted, "Clicked on Converted Tab");
       }
    catch (Throwable e){
    KeywordUtil.waitForVisible(LeadsPage.converted);
    WebElement element = KeywordUtil.getDriver().findElement(LeadsPage.converted);
    JavascriptExecutor executor = (JavascriptExecutor) KeywordUtil.getDriver();
    executor.executeScript("arguments[0].click();", element);
        }
    }
    public static void clickOnCovertedStatusButton () throws InterruptedException {
        try {
            KeywordUtil.scrollup(LeadsPage.selectConvertedStatusButton);
            KeywordUtil.waitForVisible(LeadsPage.selectConvertedStatusButton);
            KeywordUtil.clickJS(LeadsPage.selectConvertedStatusButton, "Clicked on Converted Status Button");
        }
        catch (Throwable e){
            KeywordUtil.delay(3000);
        KeywordUtil.waitForVisible(LeadsPage.selectConvertedStatusButton);
        WebElement element = KeywordUtil.getDriver().findElement(LeadsPage.selectConvertedStatusButton);
        JavascriptExecutor executor = (JavascriptExecutor) KeywordUtil.getDriver();
        executor.executeScript("arguments[0].click();", element);
        }
    }
    public static void clickOnCovertedButton ()  {
       boolean buttonDisplayed= KeywordUtil.isWebElementVisible(LeadsPage.convertButton,"");
        if(KeywordUtil.isWebElementVisible(LeadsPage.convertButton,"")){
           KeywordUtil.click(LeadsPage.convertButton,"Clicked on Convert Button");
        }
        else{
            Assert.fail("Button Not displayed or not enabled "+buttonDisplayed);
        }
        }

    public static void verifyConvertStatusMessage() throws InterruptedException {
        KeywordUtil.delay(1000);
        try {
            KeywordUtil.waitForVisible(LeadsPage.convertStatusMessage);
            String statusMessage = KeywordUtil.getElementText(LeadsPage.convertStatusMessage);
            System.out.println("statusMessage: " + statusMessage);
            assertEquals(statusMessage, "Your lead has been converted");
            RunCukesTest.logger.log(LogStatus.PASS,
                    HTMLReportUtil.passStringGreenColor("verified <font color='green'>" + statusMessage + "</font> page"));
        }
        catch (Exception e){
            Assert.fail("lead not converted");
        }
        }

}
