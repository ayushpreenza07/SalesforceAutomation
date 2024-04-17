package SalesforceModules;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pageobjects.SalesforceObjects.ContactObject;
import pageobjects.SalesforceObjects.OppurtunitiesObject;
import utilities.GlobalUtil;
import utilities.KeywordUtil;

import java.security.Key;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class OppurtunitiesUtil extends GlobalUtil {

    /**
     * click new button for creating new oppurtunity.
     *
     * @param logStep the log
     */
    public static void NewButtonOppurtunity(String logStep){
        KeywordUtil.waitForVisible(OppurtunitiesObject.createNewOpportunities);
        KeywordUtil.click(OppurtunitiesObject.createNewOpportunities,logStep);
    }

    /**
     * Set year
     *
     * @param year the year
     */
    public static int setYear(int year){
        if(1924>year || year>2124){
            Assert.fail("invalid year entry");
        }

        return year;
    }

    /**
     * Set month
     *
     * @param month the year
     */
    public static int setMonth(int month){
        if(month>12 || month<=0){
            Assert.fail("invalid month entry");
        }
        return month;
    }

    /**
     * Set date
     *
     * @param date the year
     */
    public static int setDate(int date){
        if(date>31 || date<=0){
            Assert.fail("invalid date entry");
        }
        return date;
    }

    /**
     * Set closedDate
     *
     * @param year the year
     * @param month the month
     * @param day the day
     */
    public static String closedDate(int year, int month, int day){

        LocalDate specificDate = LocalDate.of(setYear(year),setMonth(month),setDate(day));
        String date = specificDate.toString();

        return changeDateFormat(date);
    }

    /**
     * changing date format
     *
     * @param originalDateString the originalDateString
     *
     */
    public static String changeDateFormat(String originalDateString) {
        LocalDate originalDate = LocalDate.parse(originalDateString);
        DateTimeFormatter newFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return originalDate.format(newFormat);
    }

    /**
     * Enter close Date
     *
     * @param year the year
     * @param month the month
     * @param day the day
     */
    public static void enterCloseDate(int year, int month, int day, String logStep){
        KeywordUtil.waitForVisible(OppurtunitiesObject.CloseDate);
        KeywordUtil.inputText(OppurtunitiesObject.CloseDate, closedDate(year,month,day),logStep);
    }

    /**
     * Enter enterOppurtunityName
     *
     * @param name the name
     * @param logStep the logStep
     */
    public static void enterOppurtunityName(String name, String logStep){
        KeywordUtil.waitForVisible(OppurtunitiesObject.opportunityName);
        KeywordUtil.inputText(OppurtunitiesObject.opportunityName, name,logStep);
    }

    /**
     * Enter enterAmount
     *
     * @param amount the amount
     * @param logStep the logStep
     */
    public static void enterAmount(String amount, String logStep){
        KeywordUtil.waitForVisible(OppurtunitiesObject.amountField);
        KeywordUtil.inputText(OppurtunitiesObject.amountField, amount,logStep);
    }

    /**
     * click save button.
     *
     * @param logStep the log
     */
    public static void clickSaveButton(String logStep){
        KeywordUtil.waitForVisible(ContactObject.saveButton);
        KeywordUtil.click(ContactObject.saveButton,logStep);
    }

    /**
     * click Opportunity Button.
     *
     * @param logStep the log
     */
    public static void clickOpportunityButton(String logStep){
        KeywordUtil.waitForVisible(OppurtunitiesObject.opportunitiesBtn);
        KeywordUtil.click(OppurtunitiesObject.opportunitiesBtn,logStep);
    }

    /**
     * Setting the stage of opportunity
     *
     * @param stage the stage
     * @param logStep the log
     */
    public static void setStage(String stage, String logStep){
        boolean flag = false;
        KeywordUtil.waitForVisible(OppurtunitiesObject.Stage);
        KeywordUtil.click(OppurtunitiesObject.Stage,logStep);
        String xpath = "//lightning-base-combobox-item[contains(@data-value,'"+stage+"')]";
        try{
            flag = KeywordUtil.getDriver().findElement(By.xpath(xpath)).isDisplayed();
        }catch (Exception e){}

        if(!flag){
            Assert.fail("No such stage is present");
        }else {
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
        }catch(Throwable e) {
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
     *
     * @param logStep the log
     */
    public static void openOpportunity(String logStep) throws InterruptedException {
        KeywordUtil.delay(2000);
        KeywordUtil.waitForVisible(OppurtunitiesObject.selectOpportunity);
        KeywordUtil.click(OppurtunitiesObject.selectOpportunity,logStep);
    }

    /**
     * Select the Stage - Proposal in Quote
     *
     *
     * @param logStep the log
     */
    public static void selectStageProposalQuote(String logStep){
        try {
            KeywordUtil.waitForVisible(OppurtunitiesObject.proposalStage);
            KeywordUtil.click(OppurtunitiesObject.proposalStage, logStep);
        }catch (Exception e) {
            KeywordUtil.waitForVisible(OppurtunitiesObject.proposalStage);
            WebElement element = KeywordUtil.getDriver().findElement(OppurtunitiesObject.proposalStage);
            JavascriptExecutor executor = (JavascriptExecutor) KeywordUtil.getDriver();
            executor.executeScript("arguments[0].click();", element);
        }
    }

    /**
     * Clicking mark as stage button
     *
     *
     * @param logStep the log
     */
    public static void setMarkAsStage(String logStep){
        try {
            KeywordUtil.waitForVisible(OppurtunitiesObject.markStage);
            KeywordUtil.click(OppurtunitiesObject.markStage, logStep);
        }catch (Exception e) {
            KeywordUtil.waitForVisible(OppurtunitiesObject.markStage);
            WebElement element = KeywordUtil.getDriver().findElement(OppurtunitiesObject.markStage);
            JavascriptExecutor executor = (JavascriptExecutor) KeywordUtil.getDriver();
            executor.executeScript("arguments[0].click();", element);
        }
    }

    /**
     * Verify Product
     *
     *
     * @param logStep the log
     */
    public static void verifyProduct(String logStep){
        try{
            KeywordUtil.waitForVisible(OppurtunitiesObject.verifyProduct);
        }catch (Exception e){
            Assert.fail("product not added");
        }
    }

    /**
     * Verify Document Generated
     *
     *
     * @param logStep the log
     */
    public static void verifyDocumentGenerated(String logStep){
        try{
            KeywordUtil.waitForVisible(OppurtunitiesObject.verifyDocument);
        }catch (Exception e){
            Assert.fail("product not added");
        }
    }

    /**
     * Navigate to account
     *
     *
     * @param logStep the log
     */
    public static void goToAccount(String logStep){
        KeywordUtil.waitForVisible(OppurtunitiesObject.getBackToAccount);
        KeywordUtil.click(OppurtunitiesObject.getBackToAccount,logStep);
    }

    /**
     * mark stage to proposal and navigating back to account
     *
     */

    public static void markStage() throws InterruptedException {
        openOpportunity("Created opportunity opened");
        selectStageProposalQuote("proposal stage selected");
        setMarkAsStage("stage marked");
        goToAccount("Navigated back to account");
    }

    /**
     * selecting closed won after marking opportunity as proposal
     *
     *
     * @param logStep the name
     */
    public static void selectClosedStatus(String logStep){
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
        }catch(Exception e){
            KeywordUtil.getDriver().navigate().refresh();
            KeywordUtil.waitForVisible(OppurtunitiesObject.saveClosedWon);
            KeywordUtil.click(OppurtunitiesObject.saveClosedWon, logStep);
        }
    }

    /**
     * Enter createOpportunity
     *
     *
     * @param name the name
     * @param amount the amount
     * @param stage the stage
     */
    public static void createOpportunity(String name,String amount,String stage) throws InterruptedException {
        clickOpportunityButton("Opportunity button clicked");
        NewButtonOppurtunity("clicked new button for Opportunity");
        enterOppurtunityName(name, name+" entered in Opportunity");
        enterCloseDate(2024,1,2,"Close date entered");
        enterAmount(amount, "Amount entered "+amount);
        setStage(stage, "Stage selected - "+stage);
        clickSaveButton("saved");
        KeywordUtil.delay(3000);
//        backToAccount("Navigated back to account");
        markStage();
    }

}
