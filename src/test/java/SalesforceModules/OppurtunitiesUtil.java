package SalesforceModules;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.collections.bag.SynchronizedSortedBag;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pageobjects.SalesforceObjects.*;
import step_definitions.RunCukesTest;
import utilities.GlobalUtil;
import utilities.HTMLReportUtil;
import utilities.KeywordUtil;

import java.security.Key;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static utilities.KeywordUtil.catchAssertError;
import static utilities.KeywordUtil.takeScreenshotAndAttachInReport;

public class OppurtunitiesUtil extends GlobalUtil {

    /**
     * click new button for creating new oppurtunity.
     *
     * @param logStep the log
     */
    public static void NewButtonOppurtunity(String logStep) {
        KeywordUtil.waitForVisible(OppurtunitiesObject.createNewOpportunities);
        KeywordUtil.click(OppurtunitiesObject.createNewOpportunities, logStep);
    }

    /**
     * Set year
     *
     * @param year the year
     */
    public static int setYear(int year) {
        if (1924 > year || year > 2124) {
            Assert.fail("invalid year entry");
        }

        return year;
    }

    /**
     * Set month
     *
     * @param month the year
     */
    public static int setMonth(int month) {
        if (month > 12 || month <= 0) {
            Assert.fail("invalid month entry");
        }
        return month;
    }

    /**
     * Set date
     *
     * @param date the year
     */
    public static int setDate(int date) {
        if (date > 31 || date <= 0) {
            Assert.fail("invalid date entry");
        }
        return date;
    }

    /**
     * Set closedDate
     *
     * @param year  the year
     * @param month the month
     * @param day   the day
     */
    public static String closedDate(int year, int month, int day) {

        LocalDate specificDate = LocalDate.of(setYear(year), setMonth(month), setDate(day));
        String date = specificDate.toString();

        return changeDateFormat(date);
    }

    /**
     * changing date format
     *
     * @param originalDateString the originalDateString
     */
    public static String changeDateFormat(String originalDateString) {
        LocalDate originalDate = LocalDate.parse(originalDateString);
        DateTimeFormatter newFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return originalDate.format(newFormat);
    }

    /**
     * Enter close Date
     *
     * @param year  the year
     * @param month the month
     * @param day   the day
     */
    public static void enterCloseDate(int year, int month, int day, String logStep) {
        KeywordUtil.waitForVisible(OppurtunitiesObject.CloseDate);
        KeywordUtil.inputText(OppurtunitiesObject.CloseDate, closedDate(year, month, day), logStep);
    }

    /**
     * Enter enterOppurtunityName
     *
     * @param name    the name
     * @param logStep the logStep
     */
    public static void enterOppurtunityName(String name, String logStep) {
        KeywordUtil.waitForVisible(OppurtunitiesObject.opportunityName);
        KeywordUtil.inputText(OppurtunitiesObject.opportunityName, name, logStep);
    }

    /**
     * Enter enterAmount
     *
     * @param amount  the amount
     * @param logStep the logStep
     */
    public static void enterAmount(String amount, String logStep) {
        KeywordUtil.waitForVisible(OppurtunitiesObject.amountField);
        KeywordUtil.inputText(OppurtunitiesObject.amountField, amount, logStep);
    }

    /**
     * click save button.
     *
     * @param logStep the log
     */
    public static void clickSaveButton(String logStep) {
        KeywordUtil.waitForVisible(ContactObject.saveButton);
        KeywordUtil.click(ContactObject.saveButton, logStep);
    }

    /**
     * click Opportunity Button.
     *
     * @param logStep the log
     */
    public static void clickOpportunityButton(String logStep) {
        KeywordUtil.waitForVisible(OppurtunitiesObject.opportunitiesBtn);
        KeywordUtil.click(OppurtunitiesObject.opportunitiesBtn, logStep);
    }

    /**
     * Setting the stage of opportunity
     *
     * @param stage   the stage
     * @param logStep the log
     */
    public static void setStage(String stage, String logStep) {
        boolean flag = false;
        KeywordUtil.waitForVisible(OppurtunitiesObject.Stage);
        KeywordUtil.click(OppurtunitiesObject.Stage, logStep);
        String xpath = "//lightning-base-combobox-item[contains(@data-value,'" + stage + "')]";
        try {
            flag = KeywordUtil.getDriver().findElement(By.xpath(xpath)).isDisplayed();
        } catch (Exception e) {
        }

        if (!flag) {
            Assert.fail("No such stage is present");
        } else {
            KeywordUtil.click(By.xpath(xpath), "stage selected");
        }
    }

    /**
     * Navigate back to account
     *
     * @param logStep the log
     */
    public static void backToAccount(String logStep) throws InterruptedException {
        try {
            KeywordUtil.delay(5000);
            KeywordUtil.waitForVisible(OppurtunitiesObject.backToAccount);
            KeywordUtil.click(OppurtunitiesObject.backToAccount, logStep);
        } catch (Throwable e) {
            KeywordUtil.delay(3000);
            KeywordUtil.waitForVisible(OppurtunitiesObject.backToAccount);
            WebElement element = KeywordUtil.getDriver().findElement(OppurtunitiesObject.backToAccount);
            JavascriptExecutor executor = (JavascriptExecutor) KeywordUtil.getDriver();
            executor.executeScript("arguments[0].click();", element);
        }
    }

    /**
     * Open the Opportunity
     *
     * @param logStep the log
     */
    public static void openOpportunity(String logStep) throws InterruptedException {
        KeywordUtil.delay(2000);
        KeywordUtil.waitForVisible(OppurtunitiesObject.selectOpportunity);
        KeywordUtil.click(OppurtunitiesObject.selectOpportunity, logStep);
    }

    /**
     * Select the Stage - Proposal in Quote
     *
     * @param logStep the log
     */
    public static void selectStageProposalQuote(String logStep) {
        try {
            KeywordUtil.delay(2000);
            KeywordUtil.waitForVisible(OppurtunitiesObject.proposalStage);
            KeywordUtil.click(OppurtunitiesObject.proposalStage, logStep);
        } catch (Exception e) {
            KeywordUtil.waitForVisible(OppurtunitiesObject.proposalStage);
            KeywordUtil.clickJS(OppurtunitiesObject.proposalStage);
        }
    }

    public static void selectStageProposalQuotes(String logStep) {
        try {
            KeywordUtil.delay(2000);
            KeywordUtil.waitForVisible(OppurtunitiesObject.proposalStages);
            KeywordUtil.click(OppurtunitiesObject.proposalStages, logStep);
        } catch (Exception e) {
            KeywordUtil.waitForVisible(OppurtunitiesObject.proposalStages);
            KeywordUtil.clickJS(OppurtunitiesObject.proposalStages);
        }
    }

    /**
     * Clicking mark as stage button
     *
     * @param logStep the log
     */
    public static void setMarkAsStage(String logStep) throws InterruptedException {
        try {
            KeywordUtil.delay(3000);
            KeywordUtil.waitForVisible(OppurtunitiesObject.markStage);
            KeywordUtil.click(OppurtunitiesObject.markStage, logStep);
        } catch (Exception e) {
            KeywordUtil.delay(3000);
            KeywordUtil.waitForVisible(OppurtunitiesObject.markStage);
            WebElement element = KeywordUtil.getDriver().findElement(OppurtunitiesObject.markStage);
            JavascriptExecutor executor = (JavascriptExecutor) KeywordUtil.getDriver();
            executor.executeScript("arguments[0].click();", element);
        }
    }

    /**
     * Clicking mark as stage button
     *
     * @param logStep the log
     */
    public static void setMarkAsStages(String logStep) throws InterruptedException {
        try {
            KeywordUtil.delay(3000);
            KeywordUtil.waitForVisible(OppurtunitiesObject.markStages);
            KeywordUtil.click(OppurtunitiesObject.markStages, logStep);
        } catch (Exception e) {
            KeywordUtil.delay(3000);
            KeywordUtil.waitForVisible(OppurtunitiesObject.markStages1);
            WebElement element = KeywordUtil.getDriver().findElement(OppurtunitiesObject.markStages1);
            JavascriptExecutor executor = (JavascriptExecutor) KeywordUtil.getDriver();
            executor.executeScript("arguments[0].click();", element);
        }
    }

/**
     * Clicking mark Current stage button
     *
     * @param logStep the log
     */
    public static void setMarkAsCurrentStages(String logStep) throws InterruptedException {
        try {
            KeywordUtil.delay(3000);
            KeywordUtil.waitForVisible(OppurtunitiesObject.markCurrentStages);
            WebElement element = KeywordUtil.getDriver().findElement(OppurtunitiesObject.markCurrentStages);
            JavascriptExecutor executor = (JavascriptExecutor) KeywordUtil.getDriver();
            executor.executeScript("arguments[0].click();", element);
            RunCukesTest.logger.log(LogStatus.PASS, logStep);
        } catch (Exception e) {
            Assert.fail("stage not marked");

        }
    }

    /**
     * Verify Product
     *
     * @param logStep the log
     */
    public static void verifyProduct(String logStep) {
        try {
            KeywordUtil.waitForVisible(OppurtunitiesObject.verifyProduct);
        } catch (Exception e) {
            Assert.fail("product not added");
        }
    }

    /**
     * Verify Document Generated
     *
     * @param logStep the log
     */
    public static void verifyDocumentGenerated(String logStep) {
        try {
            KeywordUtil.waitForVisible(OppurtunitiesObject.verifyDocument);
        } catch (Exception e) {
            Assert.fail("product not added");
        }
    }

    /**
     * Navigate to account
     *
     * @param logStep the log
     */
    public static void goToAccount(String logStep) {
        KeywordUtil.waitForVisible(OppurtunitiesObject.getBackToAccount);
        KeywordUtil.click(OppurtunitiesObject.getBackToAccount, logStep);
    }

    /**
     * mark stage to proposal and navigating back to account
     */

    public static void markStage() throws InterruptedException {
        openOpportunity("Created opportunity opened");
        selectStageProposalQuote("proposal stage selected");
        setMarkAsStage("stage marked");
        goToAccount("Navigated back to account");
    }

    // Leads Mark As Stage
    public static void markAsStage() throws InterruptedException {
        selectStageProposalQuote("proposal stage selected");
        setMarkAsStage("stage marked");
    }

    public static void markAsStages() throws InterruptedException {
        selectStageProposalQuotes("proposal stage selected");
        setMarkAsStages("stage marked");
    }

    /**
     * selecting closed won after marking opportunity as proposal
     *
     * @param logStep the name
     */
    public static void selectClosedStatus(String logStep) {
        //Clicking on closed status
        KeywordUtil.waitForClickable(OppurtunitiesObject.closedStatus);
        WebElement element1 = KeywordUtil.getDriver().findElement(OppurtunitiesObject.closedStatus);
        JavascriptExecutor executor = (JavascriptExecutor) KeywordUtil.getDriver();
        executor.executeScript("arguments[0].click();", element1);

        //clicking on mark stage button
        KeywordUtil.waitForClickable(OppurtunitiesObject.selectClosedStage);
        WebElement element2 = KeywordUtil.getDriver().findElement(OppurtunitiesObject.selectClosedStage);
        executor.executeScript("arguments[0].click();", element2);

        //select closed won value from dropdown
        KeywordUtil.waitForVisible(OppurtunitiesObject.selectClosedStageDropdown);
        KeywordUtil.selectByValue(OppurtunitiesObject.selectClosedStageDropdown, "Closed Won", "Closed won selected from dropdown");

        //save option
        try {
            KeywordUtil.waitForVisible(OppurtunitiesObject.saveClosedWon);
            KeywordUtil.click(OppurtunitiesObject.saveClosedWon, logStep);
        } catch (Exception e) {
            KeywordUtil.getDriver().navigate().refresh();
            KeywordUtil.waitForVisible(OppurtunitiesObject.saveClosedWon);
            KeywordUtil.click(OppurtunitiesObject.saveClosedWon, logStep);
        }
    }

    /**
     * Enter createOpportunity
     *
     * @param name   the name
     * @param amount the amount
     * @param stage  the stage
     */
    public static void createOpportunity(String name, String amount, String stage) throws InterruptedException {
        clickOpportunityButton("Opportunity button clicked");
        NewButtonOppurtunity("clicked new button for Opportunity");
        enterOppurtunityName(name, name + " entered in Opportunity");
        enterCloseDate(2024, 1, 2, "Close date entered");
        enterAmount(amount, "Amount entered " + amount);
        setStage(stage, "Stage selected - " + stage);
        clickSaveButton("saved");
        KeywordUtil.delay(3000);
//        backToAccount("Navigated back to account");
        markStage();
    }

    /**
     * Click On Opportunity Tab
     */
    public static void clickOnOpportunityTab() throws InterruptedException {
        try {
            KeywordUtil.delay(2000);
            KeywordUtil.isWebElementVisible(OppurtunitiesObject.opportunitiesTab, "verify Opportunity Tab");
            KeywordUtil.click(OppurtunitiesObject.opportunitiesTab, "Clicked on Opportunities Tab");
        } catch (Exception e) {
            KeywordUtil.delay(2000);
            KeywordUtil.isWebElementVisible(OppurtunitiesObject.opportunitiesTab, "verify Opportunity Tab");
            KeywordUtil.clickJS(OppurtunitiesObject.opportunitiesTab);

        }
    }

    /**
     * Click On Opportunity Name in Opportunity
     */
    public static void clickOnOpportunityName() {
        try {
            KeywordUtil.isWebElementVisible(OppurtunitiesObject.opportunityNameInTable, "verify Opportunity Tab");
            KeywordUtil.click(OppurtunitiesObject.opportunityNameInTable, "Clicked on Opportunities Name");
        } catch (Exception e) {
            KeywordUtil.isWebElementVisible(OppurtunitiesObject.opportunityNameInTable, "verify Opportunity Tab");
            KeywordUtil.clickJS(OppurtunitiesObject.opportunityNameInTable);

            System.out.println(e);
        }
    }

    public static void clickOnSalesforceCPQ() {
        try {
            KeywordUtil.isWebElementVisible(OppurtunitiesObject.salesForceCPQ, "verify Opportunity Tab");
            KeywordUtil.clickJS(OppurtunitiesObject.salesForceCPQ);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void verifyOpportunityStage() throws InterruptedException {
        KeywordUtil.delay(5000);
        String stageStatus = KeywordUtil.getVisibleText(OppurtunitiesObject.opportunityStage);
        if (KeywordUtil.isWebElementVisible(OppurtunitiesObject.opportunityStage, "Closed Won Stage Displayed")) {
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("Verify Status: " + stageStatus));
        } else {
            RunCukesTest.logger.log(LogStatus.FAIL, "Status is not showing: " + stageStatus);

        }
    }

    /**
     * Click on the Opportunity Tab
     *
     * @param logStep the log step
     * @throws InterruptedException the interrupted exception
     */
    public static void clickOpportunityTab(String logStep) throws InterruptedException {
        try {
            KeywordUtil.delay(3000);
            KeywordUtil.waitForVisible(OppurtunitiesObject.opportunitiesTabb);
            WebElement element = KeywordUtil.getDriver().findElement(OppurtunitiesObject.opportunitiesTabb);
            JavascriptExecutor executor = (JavascriptExecutor) KeywordUtil.getDriver();
            executor.executeScript("arguments[0].click();", element);
        } catch (Exception e) {
            catchAssertError(e);
        }
    }

    /**
     * create Opportunity from Opportunity tab
     *
     * @param name   the name
     * @param amount the amount
     * @param stage  the stage
     */
    public static void createOpportunityFromOpportunityTab(String name, String amount, String stage) throws InterruptedException {
        NewButtonOppurtunity("clicked new button for Opportunity");
        enterOppurtunityName(name, name + " entered in Opportunity");
        enterCloseDate(2024, 1, 2, "Close date entered");
        enterAmount(amount, "Amount entered " + amount);
        setStage(stage, "Stage selected - " + stage);
        takeScreenshotAndAttachInReport();
        clickSaveButton("saved");
        KeywordUtil.delay(3000);
        KeywordUtil.isWebElementVisible(ForecastingPage.newForecastAdded("DemoOpportunity"), "Verify new opportunity created.");
        takeScreenshotAndAttachInReport();
    }

    /**
     * Edit Opportunity from Opportunity tab
     *
     * @param name   the name
     * @param amount the amount
     */
    public static void editOpportunityFromOpportunityTab(String name, String amount) throws InterruptedException {
        KeywordUtil.waitForVisible(OppurtunitiesObject.editButton);
        KeywordUtil.click(OppurtunitiesObject.editButton, "Click on edit button.");
        enterOppurtunityName(name, name + " entered in Opportunity");
        enterAmount(amount, "Amount entered " + amount);
        takeScreenshotAndAttachInReport();
        clickSaveButton("saved");
        KeywordUtil.isWebElementVisible(ForecastingPage.newForecastAdded("DemoOpportunityUpdated"), "Verify opportunity is edited.");
        takeScreenshotAndAttachInReport();
    }
    /**
     * Delete Opportunity from Opportunity tab
     *
     */
    public static void deleteOpportunityFromOpportunityTab() throws InterruptedException {
        KeywordUtil.waitForVisible(OppurtunitiesObject.opportunitiesTabShowMoreButton);
        KeywordUtil.click(OppurtunitiesObject.opportunitiesTabShowMoreButton, "Click on opportunities details screen show more button.");
        KeywordUtil.isWebElementVisible(ForecastingPage.newForecastAdded("Delete"), "Verify delete option is visible.");
        takeScreenshotAndAttachInReport();
        KeywordUtil.click(ForecastingPage.newForecastAdded("Delete"), "Click on delete option.");
        KeywordUtil.isWebElementVisible(OppurtunitiesObject.deleteOpportunityPopup, "Verify delete opportunity popup is visible on screen.");
        takeScreenshotAndAttachInReport();
        KeywordUtil.click(OppurtunitiesObject.deleteButton,"Click on delete button.");
        KeywordUtil.isWebElementVisible(OppurtunitiesObject.toastMessage, "Success message visible on screen after opportunity is deleted.");
        takeScreenshotAndAttachInReport();

    }

}
