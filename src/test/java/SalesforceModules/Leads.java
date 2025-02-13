package SalesforceModules;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageobjects.SalesforceObjects.LeadsPage;
import step_definitions.RunCukesTest;
import utilities.ConfigReader;
import utilities.HTMLReportUtil;
import utilities.KeywordUtil;

import java.security.Key;
import java.util.HashMap;

import static org.testng.Assert.assertEquals;


public class Leads {
    public static HashMap<String, String> dataMap = new HashMap<String, String>();

    /**
     Click on HamburgerMenu in Leads
     *  @param logStep the log
     */
    public static void clickOnHamburgerMenu(String logStep) throws InterruptedException {
        try {
            KeywordUtil.waitForElementPresence(LeadsPage.hamburgerMenu);
            KeywordUtil.click(LeadsPage.hamburgerMenu, logStep);
        }
        catch (Exception e){
            Assert.fail("Hamburger menu not clicked");
        }
    }

    /**
     * Enter text in Leads
     * @param text the text
     */
    public static void enterText(String text) throws InterruptedException {
        KeywordUtil.waitForElementPresence(LeadsPage.searchText);
        try {
            KeywordUtil.inputText(LeadsPage.searchText, text, "User Entered Text");
            KeywordUtil.waitForElementPresence(LeadsPage.searchText);
            KeywordUtil.pressEnter(LeadsPage.searchText);
        }
        catch (Exception e){
            Assert.fail("Text not entered in Search box");
        }
    }

    /**
     * Verify Page title
     *
     */
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

    /**
     * Click New Button
     *
     */
    public static void clickNewButton() throws InterruptedException {

        try {
            KeywordUtil.waitForVisible(LeadsPage.leadesNewButton);
            KeywordUtil.click(LeadsPage.leadesNewButton, "Clicked New Button");
        }
        catch (Exception e){
            Assert.fail("New button not tapped");
        }
        }

    /**
     * Click on save button
     *
     */
    public static void clickOnSaveButton(){
        try {
            KeywordUtil.waitForElementPresence(LeadsPage.saveButton);
            KeywordUtil.click(LeadsPage.saveButton, "Clicked on Save Button");
        }
        catch (Exception e){
            Assert.fail("Save button not clicked");
        }
     }

    /**
     * Verify open not contacted section
     *
     */
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

    /**
     * Click on converted tab
     *
     */
    public static void clickOnConvertedTab () throws InterruptedException {
        try {
        KeywordUtil.waitForElementPresence(LeadsPage.converted);
        KeywordUtil.scrollup(LeadsPage.converted);
        KeywordUtil.waitForVisible(LeadsPage.converted);
        KeywordUtil.click(LeadsPage.converted, "Clicked on Converted Tab");
       }
    catch (Throwable e){
        KeywordUtil.waitForElementPresence(LeadsPage.converted);
        KeywordUtil.clickJS(LeadsPage.converted);
        }
    }

    /**
     * Click on convertedstatus button
     *
     */
    public static void clickOnConvertedStatusButton () throws InterruptedException {
        try {
            KeywordUtil.waitForElementPresence(LeadsPage.selectConvertedStatusButton);
            KeywordUtil.scrollup(LeadsPage.selectConvertedStatusButton);
            KeywordUtil.waitForVisible(LeadsPage.selectConvertedStatusButton);
            KeywordUtil.clickJS(LeadsPage.selectConvertedStatusButton, "Clicked on Converted Status Button");
        }
        catch (Throwable e){
            KeywordUtil.waitForElementPresence(LeadsPage.selectConvertedStatusButton);
             KeywordUtil.clickJS(LeadsPage.selectConvertedStatusButton);
        }
    }

    /**
     * Click on converted button
     *
     */
    public static void clickOnConvertedButton () throws InterruptedException {

        try {
            KeywordUtil.waitForElementPresence(LeadsPage.convertButton);
            KeywordUtil.clickJS(LeadsPage.convertButton, "Clicked on Converted Button");
        }
        catch (Throwable e){
            KeywordUtil.waitForElementPresence(LeadsPage.convertButton);
            KeywordUtil.clickJS(LeadsPage.convertButton);
        }
      }

    /**
     * Verify converted status message
     *
     */
    public static void verifyConvertStatusMessage() throws InterruptedException {
        try {
            KeywordUtil.waitForElementPresence(LeadsPage.convertStatusMessage);
            String statusMessage = KeywordUtil.getElementText(LeadsPage.convertStatusMessage);
            HTMLReportUtil.passStringGreenColor("statusMessage: " + statusMessage );
            assertEquals(statusMessage, "Your lead has been converted");
            RunCukesTest.logger.log(LogStatus.PASS,
                    HTMLReportUtil.passStringGreenColor("verified <font color='green'>" + statusMessage + "</font> page"));
        }
        catch (Exception e){
            Assert.fail("lead not converted");
        }
    }

    /**
     * Click on existing account radio button
     *
     */
    public static void clickOnExistingAccountRadioBtn(){
        KeywordUtil.waitForVisible(LeadsPage.existingAccountSearch);
        KeywordUtil.click(LeadsPage.existingAccountSearch,"Click Existing Account  Radio Button");

        KeywordUtil.waitForVisible(LeadsPage.existingAccountTextBox);
        KeywordUtil.click(LeadsPage.existingAccountTextBox,"Click on TextBox");
        KeywordUtil.waitForVisible(LeadsPage.existingAccountList);
        KeywordUtil.click(LeadsPage.existingAccountList,"Click on List");
    }

    /**
     * Click on existing contact radio button
     *
     */
    public static void clickOnExistingContactRadioBtn() throws InterruptedException {
        KeywordUtil.waitForElementPresence(LeadsPage.existingContactSearch);
        try {
            KeywordUtil.scrolldown(LeadsPage.existingContactSearch);
            KeywordUtil.scrollingToElementofAPage(LeadsPage.existingContactSearch,"");
            KeywordUtil.waitForVisible(LeadsPage.existingContactSearch);
            KeywordUtil.click(LeadsPage.existingContactSearch,"Clicked on Contact Search Radio Button");
            KeywordUtil.waitForVisible(LeadsPage.existingContactSearchTextBox);
            KeywordUtil.click(LeadsPage.existingContactSearchTextBox,"Clicked on Contact Search Text Box");
            KeywordUtil.waitForVisible(LeadsPage.existingContactList);
            KeywordUtil.click(LeadsPage.existingContactList,"Clicked on Contacted list");
        }
        catch (Exception e){
            KeywordUtil.clickJS(LeadsPage.existingContactSearch);
            KeywordUtil.waitForVisible(LeadsPage.existingContactSearchTextBox);
            KeywordUtil.click(LeadsPage.existingContactSearchTextBox,"Clicked on Contact Search Text Box");
            KeywordUtil.waitForVisible(LeadsPage.existingContactList);
            KeywordUtil.click(LeadsPage.existingContactList,"Clicked on Contacted list");

        }
    }

    /**
     * Click on existing opportunity radio button
     *
     */
    public static void clickOnExistingOpportunityRadioBtn() throws InterruptedException {

        try {
            KeywordUtil.waitForElementPresence(LeadsPage.existingOpportunitySearch);
            KeywordUtil.click(LeadsPage.existingOpportunitySearch, "Click Existing Opportunity Radio Button");
            KeywordUtil.waitForVisible(LeadsPage.opportunityExistingRadioButton);
            KeywordUtil.click(LeadsPage.opportunityExistingRadioButton, "clicked on Existing Opportunity radio button");
        }
       catch (Exception e){
           KeywordUtil.clickJS(LeadsPage.existingOpportunitySearch);
           KeywordUtil.waitForVisible(LeadsPage.opportunityExistingRadioButton);
           KeywordUtil.click(LeadsPage.opportunityExistingRadioButton, "clicked on Existing Opportunity radio button");
    }
    }

    /**
     * Click on opportunity name
     *
     */

    public static void clickOnOpportunityName(){
        KeywordUtil.waitForVisible(LeadsPage.convertOpportunity);
        KeywordUtil.click(LeadsPage.convertOpportunity,"Clicked on Opportunity Titile");
    }

    /**
     * Verify opportunity account name
     *
     */
    public static void verifyOpportunityAccountName() throws InterruptedException {
        KeywordUtil.waitForElementPresence(LeadsPage.opportunityAccountName);
        boolean addedMessage = KeywordUtil.isWebElementVisible(LeadsPage.opportunityAccountName, "verify AccountName");
        if (addedMessage) {
            String accountTitle = KeywordUtil.getVisibleText(LeadsPage.opportunityAccountName);
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil
                    .passStringGreenColor("verify Opportunity account title" + accountTitle));
        } else {
            Assert.fail("Account not displayed");
        }
    }
}
