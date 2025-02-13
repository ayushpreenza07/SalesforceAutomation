package SalesforceModules;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageobjects.SalesforceObjects.ContactObject;
import pageobjects.SalesforceObjects.ContractObject;
import pageobjects.SalesforceObjects.OppurtunitiesObject;
import utilities.KeywordUtil;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class ContractUtil {

    static HashMap<String, String> map = new HashMap<>();

    /**
     * click contract button
     *
     * @param logStep the log
     */
    public static void buttonContract(String logStep) throws InterruptedException {
        try {

            ((JavascriptExecutor) KeywordUtil.getDriver()).executeScript("window.scrollBy(0,700)");
            KeywordUtil.waitForElementPresence(ContractObject.contractBtn);
            KeywordUtil.clickJS(ContractObject.contractBtn, logStep);
        }catch(Exception e){
            KeywordUtil.scrollElementIntoViewUsingActions(ContractObject.contractBtn);
            KeywordUtil.waitForVisible(ContractObject.contractBtn);
            KeywordUtil.click(ContractObject.contractBtn, logStep);
        }
    }

    /**
     * click new button for creating new contract.
     *
     * @param logStep the log
     */
    public static void newButtonContract(String logStep) throws InterruptedException {
        KeywordUtil.waitForElementPresence(ContractObject.newContract);
        KeywordUtil.click(ContractObject.newContract,logStep);
    }

    /**
     * Enter start date for new contract.
     *
     * @param year,month,day the log
     */
    public static void enterStartDate(int year, int month, int day, String logStep){
        KeywordUtil.waitForVisible(ContractObject.startDate);
        KeywordUtil.inputText(ContractObject.startDate, OppurtunitiesUtil.closedDate(year,month,day),logStep);
    }

    /**
     * Enter status for new contract.
     *
     * @param status the log
     */
    public static void contractStatus(String status, String logStep){
        boolean flag = false;
        KeywordUtil.waitForVisible(ContractObject.contractStatus);
        KeywordUtil.click(ContractObject.contractStatus,logStep);
        String xpath = "//lightning-base-combobox-item[contains(@data-value,'"+status+"')]";
        try{
            flag = KeywordUtil.getDriver().findElement(By.xpath(xpath)).isDisplayed();
        }catch (Exception e){}

        if(!flag){
            Assert.fail("No such status is present");
        }else {
            KeywordUtil.click(By.xpath(xpath), "status selected");
        }
    }

    /**
     * Enter contract term in months for new contract.
     *
     * @param term the log
     */
    public static void enterContractTerm(String term, String logStep){
        KeywordUtil.waitForVisible(ContractObject.contractTerm);
        KeywordUtil.inputText(ContractObject.contractTerm, term,logStep);
    }

    /**
     * Navigating back to opportunity after creating contract
     *
     *
     * @param logStep the name
     */
    public static void navigateToOpportunity(String opportunity,String logStep) throws InterruptedException {
        String xpath = "//a[@title='"+opportunity+"']";

        try {
            KeywordUtil.waitForVisible(By.xpath("//li//a[@title='"+opportunity+"']"));
            KeywordUtil.click(By.xpath("//li//a[@title='"+opportunity+"']"), logStep);
        }catch (Exception e){
            WebElement element = KeywordUtil.getDriver().findElement(By.xpath(xpath));
            JavascriptExecutor executor = (JavascriptExecutor) KeywordUtil.getDriver();
            executor.executeScript("arguments[0].click();", element);
        }

    }


    /**
     * Create contract
     *
     * @param account the log
     */
    public static void createContract(String account, String term) throws InterruptedException {

        buttonContract("Navigated to contract page");
        KeywordUtil.takeScreenshotAndAttachInReport();
        newButtonContract("new button clicked for contract");
        KeywordUtil.takeScreenshotAndAttachInReport();
        enterStartDate(2024,4,10,"Entered start date");
        enterContractTerm( term,"Entered contract term");
        QuoteUtil.selectAccount(account,"Account selected");
        KeywordUtil.takeScreenshotAndAttachInReport();
        QuoteUtil.clickSaveButton("Save button clicked for new contract");
        KeywordUtil.takeScreenshotAndAttachInReport();

    }

    /**
     * Create contract in billing section
     *
     * @param account the log
     */
    public static void createContract_billing(String account, String term) throws InterruptedException {
        KeywordUtil.clickJS_component(OppurtunitiesObject.opportunitiesTab,"Click on Opportunity");
        KeywordUtil.clickJS_component(OppurtunitiesObject.selectOpportunity_b,"Open Opportunity");
        KeywordUtil.waitForElementPresence(ContractObject.contractDropDownBtn);
        KeywordUtil.clickJS_component(ContractObject.contractDropDownBtn,"Click on drop down");
        KeywordUtil.clickJS_component(ContractObject.newContractButton,"Click new button");
        KeywordUtil.takeScreenshotAndAttachInReport();
        enterStartDate(2024,4,10,"Entered start date");
        enterContractTerm(term,"Entered contract term");
        QuoteUtil.selectAccount(account,"Account selected");
        KeywordUtil.takeScreenshotAndAttachInReport();
        QuoteUtil.clickSaveButton("Save button clicked for new contract");
        KeywordUtil.takeScreenshotAndAttachInReport();

    }
}
