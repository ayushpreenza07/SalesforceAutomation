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
    public static void ButtonContract(String logStep) throws InterruptedException {
        try {
            KeywordUtil.delay(10000);
            ((JavascriptExecutor) KeywordUtil.getDriver()).executeScript("window.scrollBy(0,700)");
            KeywordUtil.waitForVisible(ContractObject.contractBtn);
            KeywordUtil.clickJS(ContractObject.contractBtn, logStep);
        }catch(Exception e){
            KeywordUtil.scrollElementIntoViewUsingActions(ContractObject.contractBtn);
          //  KeywordUtil.getDriver().navigate().refresh();
           // ((JavascriptExecutor) KeywordUtil.getDriver()).executeScript("window.scrollBy(0,700)");
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
        KeywordUtil.delay(3000);
        KeywordUtil.waitForVisible(ContractObject.newContract);
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
    public static void enterContractTerm(int term, String logStep){
        KeywordUtil.waitForVisible(ContractObject.contractTerm);
        KeywordUtil.inputText(ContractObject.contractTerm, String.valueOf(term),logStep);
    }

    /**
     * Navigating back to opportunity after creating contract
     *
     *
     * @param logStep the name
     */
    public static void navigateToOpportunity(String opportunity,String logStep) throws InterruptedException {
        String xpath = "//a[@title='"+opportunity+"']";
        System.out.println(xpath);
        try {
            KeywordUtil.waitForVisible(KeywordUtil.getDriver().findElement(By.xpath(xpath)));
            KeywordUtil.click(KeywordUtil.getDriver().findElement(By.xpath(xpath)), logStep);
        }catch (Exception e){
            WebElement element = KeywordUtil.getDriver().findElement(By.xpath(xpath));
            JavascriptExecutor executor = (JavascriptExecutor) KeywordUtil.getDriver();
            executor.executeScript("arguments[0].click();", element);
        }
        KeywordUtil.delay(5000);
    }


    /**
     * Create contract
     *
     * @param account the log
     */
    public static void createContract(String account) throws InterruptedException {

        ButtonContract("Navigated to contract page");
        newButtonContract("new button clicked for contract");
        enterStartDate(2024,4,10,"Entered start date");
        enterContractTerm(2,"Entered contract term");
        QuoteUtil.selectAccount(account,"Account selected");
        QuoteUtil.clickSaveButton("Save button clicked for new contract");
        KeywordUtil.delay(3000);
    }
}
