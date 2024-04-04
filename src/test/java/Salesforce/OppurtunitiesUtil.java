package Salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageobjects.SalesforceObjects.AccountObject;
import pageobjects.SalesforceObjects.ContactObject;
import pageobjects.SalesforceObjects.OppurtunitiesObject;
import utilities.GlobalUtil;
import utilities.KeywordUtil;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

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

    public static int setYear(int year){
        if(1924>year || year>2124){
            Assert.fail("invalid year entry");
        }

        return year;
    }

    public static int setMonth(int month){
        if(month>12 || month<=0){
            Assert.fail("invalid month entry");
        }
        return month;
    }

    public static int setDate(int date){
        if(date>31 || date<=0){
            Assert.fail("invalid date entry");
        }
        return date;
    }

    public static String closedDate(int year, int month, int day){

        LocalDate specificDate = LocalDate.of(setYear(year),setMonth(month),setDate(day));
        String date = specificDate.toString();

        return changeDateFormat(date);
    }

    public static String changeDateFormat(String originalDateString) {
        LocalDate originalDate = LocalDate.parse(originalDateString);
        DateTimeFormatter newFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return originalDate.format(newFormat);
    }

    public static void enterCloseDate(int year, int month, int day, String logStep){
        KeywordUtil.waitForVisible(OppurtunitiesObject.CloseDate);
        KeywordUtil.inputText(OppurtunitiesObject.CloseDate, closedDate(year,month,day),logStep);
    }

    public static void enterOppurtunityName(String name, String logStep){
        KeywordUtil.waitForVisible(OppurtunitiesObject.opportunityName);
        KeywordUtil.inputText(OppurtunitiesObject.opportunityName, name,logStep);
    }

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

    public static void clickOpportunityButton(String logStep){
        KeywordUtil.waitForVisible(OppurtunitiesObject.opportunitiesBtn);
        KeywordUtil.click(OppurtunitiesObject.opportunitiesBtn,logStep);
    }

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

    public static void openOpportunity(String logStep){
        KeywordUtil.waitForVisible(OppurtunitiesObject.selectOpportunity);
        KeywordUtil.click(OppurtunitiesObject.selectOpportunity,logStep);
    }

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

    public static void verifyProduct(String logStep){
        try{
            KeywordUtil.waitForVisible(OppurtunitiesObject.verifyProduct);
        }catch (Exception e){
            Assert.fail("product not added");
        }
    }

    public static void verifyDocumentGenerated(String logStep){
        try{
            KeywordUtil.waitForVisible(OppurtunitiesObject.verifyDocument);
        }catch (Exception e){
            Assert.fail("product not added");
        }
    }

    public static void goToAccount(String logStep){
        KeywordUtil.waitForVisible(OppurtunitiesObject.getBackToAccount);
        KeywordUtil.click(OppurtunitiesObject.getBackToAccount,logStep);
    }

    public static void markStage(){
        openOpportunity("Created opportunity opened");
        selectStageProposalQuote("proposal stage selected");
        setMarkAsStage("stage marked");
        goToAccount("Navigated back to account");
    }

    public static void createOppurtunity(String name,String amount,String stage) throws InterruptedException {
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
