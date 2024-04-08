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
        KeywordUtil.delay(5000);
        ((JavascriptExecutor) KeywordUtil.getDriver()).executeScript("window.scrollBy(0,700)");
        KeywordUtil.waitForVisible(ContractObject.contractBtn);
        KeywordUtil.click(ContractObject.contractBtn,logStep);
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

    /**
     * Enter start date for new contract.
     *
     * @param year,month,day the log
     */
    public static void enterStartDate(int year, int month, int day, String logStep){
        KeywordUtil.waitForVisible(ContractObject.startDate);
        KeywordUtil.inputText(ContractObject.startDate, closedDate(year,month,day),logStep);
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

    public static void createContract(String account) throws InterruptedException {

        ButtonContract("Navigated to contract page");
        newButtonContract("new button clicked for contract");
        enterStartDate(2024,4,10,"Entered start date");
        enterContractTerm(2,"Entered contract term");
        QuoteUtil.selectAccount(account,"Account selected");
        QuoteUtil.clickSaveButton("Save button clicked for new contract");
    }
}
